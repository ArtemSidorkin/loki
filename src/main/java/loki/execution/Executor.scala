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
	val rootModulePathName:String,
	val outputPrintStream:PrintStream = System.out,
	val errorPrintStream:PrintStream = System.err,
	protected val generatorFactory: String=>BytecodeGenerator
)
{
	private val modules:collection.mutable.Map[String, LModule] = new ConcurrentHashMap[String, LModule]()

	private val rootModuleAbsolutePathName = new File(rootModulePathName).getAbsolutePath

	private val rootModuleName = (
		FileUtil
			convertFileToClassName (
				FileUtil.getAbsoluteFilePathname(rootModulePathName), FileUtil.workingDirectoryAbsolutePathname
			)
	)

	def getModule(moduleFilePathName:String):LModule =
	{
		val absoluteModuleFilePathName = FileUtil.getAbsoluteFilePathname(moduleFilePathName)

		val moduleName =
			if (absoluteModuleFilePathName == rootModuleAbsolutePathName) rootModuleName
			else FileUtil convertFileToClassName (absoluteModuleFilePathName, rootModuleAbsolutePathName)

		if (modules containsKey moduleName unary_!) modules.synchronized
		{
			if (modules containsKey moduleName unary_!)
			{
				val module = createModule(moduleName, moduleFilePathName)
				module.call(module, LUnit.EMPTY_UNIT_ARRAY)
				modules += moduleName -> module
			}
		}

		modules(moduleName)
	}

	private def createModule(moduleName:String, moduleFilePathname:String) =
	{
		val generator = generatorFactory(moduleName)

		val antlrModuleInputStream =
			new ANTLRInputStream(
				new ByteArrayInputStream(
					Preprocessor(FileUtil readText moduleFilePathname) getBytes StandardCharsets.UTF_8
				)
			)

		val lexer = new LokiLexer(antlrModuleInputStream)
		val commonTokenStream = new CommonTokenStream(lexer)
		val parser = new LokiParser(commonTokenStream)
		val moduleContext = parser.module()
		val parseTreeWalker = new ParseTreeWalker

		parseTreeWalker.walk(generator, moduleContext)

		(generator.classLoader getClass moduleName)
			.getConstructors
			.head
			.newInstance()
			.asInstanceOf[LModule]
	}
}

