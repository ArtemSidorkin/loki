package cloki.execution

import java.io.{ByteArrayInputStream, File, PrintStream}
import java.nio.charset.StandardCharsets
import java.util.concurrent.ConcurrentHashMap
import java.util.function.Consumer

import cloki.language.generation.Generator
import cloki.language.parsing.{LokiLexer, LokiParser}
import cloki.language.preprocessing.Preprocessor
import cloki.runtime.context.LUnitContext
import cloki.runtime.datatype.{LModule, LUnit}
import cloki.util.FileUtil
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime._

import scala.collection.JavaConversions._

private[execution] class Executor(
	_modulePaths:Seq[String],
	val outputPrintStream:PrintStream = System.out,
	val errorPrintStream:PrintStream = System.err,
	protected val generatorFactory:(String=>Generator[_])
)
{
	private val modules:collection.mutable.Map[String, LModule] = new ConcurrentHashMap[String, LModule]()
	private val moduleInstances:collection.mutable.Map[String, LUnit] = new ConcurrentHashMap[String, LUnit]()
	private val modulePaths = (
		_modulePaths.view
		map (_ replace ('\\' , '/'))
		map (modulePath => if (modulePath endsWith "/" unary_!) modulePath + "/" else modulePath)
	)

	def getModule(relativeModulePathname:String, unitContext:Option[LUnitContext] = None):LModule =
	{
		val moduleName = getModuleName(relativeModulePathname)

		if (modules containsKey moduleName unary_!) modules.synchronized
		{
			if (modules containsKey moduleName unary_!)
				modules += moduleName -> createModule(relativeModulePathname, unitContext)
		}

		modules(moduleName)
	}

	def getModuleInstance(relativeModulePathname:String, parameters:Option[Array[LUnit]] = None):LUnit =
	{
		val moduleName = getModuleName(relativeModulePathname)

		if (moduleInstances containsKey moduleName unary_!) moduleInstances.synchronized
		{
			if (moduleInstances containsKey moduleName unary_!) (
				getModule(relativeModulePathname)
					instantiate(
						parameters getOrElse null.asInstanceOf[Array[LUnit]],
						null.asInstanceOf[LUnitContext],
						new Consumer[LUnit]
						{
							override def accept(unit:LUnit):Unit =
								moduleInstances += moduleName -> unit
						}
					)
			)
		}

		moduleInstances(moduleName)
	}

	private def createModule(relativeModulePathnameWithoutExtension:String, unitContext:Option[LUnitContext]) =
	{
		val moduleName = getModuleName(relativeModulePathnameWithoutExtension)
		val generator = generatorFactory(moduleName)

		generate(generator, relativeModulePathnameWithoutExtension)

		(generator.classLoader getClass moduleName)
			.getConstructors
			.head
			.newInstance(unitContext.orNull)
			.asInstanceOf[LModule]
	}

	private def generate(generator:Generator[_], relativeModulePathname:String)()
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