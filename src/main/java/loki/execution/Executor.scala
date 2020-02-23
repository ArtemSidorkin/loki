package loki.execution

import java.io.{ByteArrayInputStream, File, PrintStream}
import java.nio.charset.StandardCharsets
import java.util.concurrent.ConcurrentHashMap

import loki.language.generation.BytecodeGenerator
import loki.language.parsing.{LokiLexer, LokiParser}
import loki.language.preprocessing.Preprocessor
import loki.runtime.unit.LModule
import loki.runtime.unit.unit.LUnit
import loki.util.FileUtil
import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree.ParseTreeWalker

import scala.collection.JavaConversions._

private[execution] class Executor(
	_modulePaths:Seq[String],
	val outputPrintStream:PrintStream = System.out,
	val errorPrintStream:PrintStream = System.err,
	protected val generatorFactory: String=>BytecodeGenerator
)
{
	private val modules:collection.mutable.Map[String, LModule] = new ConcurrentHashMap[String, LModule]()
	private val moduleInstances:collection.mutable.Map[String, LUnit] = new ConcurrentHashMap[String, LUnit]()
	private val modulePaths = (
		_modulePaths.view
		map (_ replace ('\\' , '/'))
		map (modulePath => if (modulePath endsWith "/" unary_!) modulePath + "/" else modulePath)
	)

	//TODO: each module should have pathname to starting module. So class names of units will be fixed. $$$ nested folder. $$$$$ - outer folder.
	def getModuleInstance(relativeModulePathname:String):LUnit =
	{
		val moduleName = getModuleName(relativeModulePathname)

		if (moduleInstances containsKey moduleName unary_!) moduleInstances.synchronized
		{
			if (moduleInstances containsKey moduleName unary_!) (
				getModule(relativeModulePathname)
					newInstance(
						LUnit.EMPTY_UNIT_ARRAY,
						(unit:LUnit) => moduleInstances += moduleName -> unit
					)
			)
		}

		moduleInstances(moduleName)
	}

	private def getModule(relativeModulePathname:String):LModule =
	{
		val moduleName = getModuleName(relativeModulePathname)

		if (modules containsKey moduleName unary_!) modules.synchronized
		{
			if (modules containsKey moduleName unary_!)
				modules += moduleName -> createModule(relativeModulePathname)
		}

		modules(moduleName)
	}

	private def createModule(relativeModulePathnameWithoutExtension:String) =
	{
		val moduleName = getModuleName(relativeModulePathnameWithoutExtension)
		val generator = generatorFactory(moduleName)

		generate(generator, relativeModulePathnameWithoutExtension)

		(generator.classLoader getClass moduleName)
			.getConstructors
			.head
			.newInstance()
			.asInstanceOf[LModule]
	}

	private def generate(generator:BytecodeGenerator, relativeModulePathname:String)()
	{
		val antlrModuleInputStream =
			new ANTLRInputStream(
				new ByteArrayInputStream(
					Preprocessor(
						FileUtil readText getModuleFilePathname(relativeModulePathname)
					)
						getBytes StandardCharsets.UTF_8
				)
			)

		val lexer = new LokiLexer(antlrModuleInputStream)
		val commonTokenStream = new CommonTokenStream(lexer)
		val parser = new LokiParser(commonTokenStream)
		val moduleContext = parser.module()
		val parseTreeWalker = new ParseTreeWalker

		parseTreeWalker.walk(generator, moduleContext)
	}

	private def getModuleName(relativeModulePathname:String) = (
		FileUtil
			getFilePathnameWithoutExtension relativeModulePathname
			replace ("/", "$")
	)

	private def getModuleFilePathname(relativeModulePathname:String):String = (
		(
			modulePaths
			find (modulePath => new File(s"$modulePath$relativeModulePathname").exists)
			getOrElse(
				throw new IllegalArgumentException(s"""Module file "$relativeModulePathname" not found""")
			)
		)
			concat relativeModulePathname
	)
}