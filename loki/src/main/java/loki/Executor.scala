package loki

import java.io.{ByteArrayInputStream, File}
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

import scala.jdk.CollectionConverters._
import scala.language.postfixOps

object Executor
{
	private val modules:collection.mutable.Map[String, LModule] = new ConcurrentHashMap[String, LModule]().asScala

	private var rootModulePathName:Option[String] = None
	private var rootModuleAbsolutePathName:Option[String] = None
	private var rootModuleName:Option[String] = None

	def getModule(moduleFilePathName:String):LModule =
	{
		if (rootModulePathName.isEmpty) this.synchronized
		{
			if (rootModulePathName.isEmpty)
			{
				rootModulePathName = Some(moduleFilePathName)
				rootModuleAbsolutePathName = Some(new File(rootModulePathName.get).getAbsolutePath)
				rootModuleName = Some(FileUtil
				convertFileToClassName (
					FileUtil.getAbsoluteFilePathname(rootModulePathName.get), FileUtil.workingDirectoryAbsolutePathname
				))
			}
		}

		val absoluteModuleFilePathName = FileUtil.getAbsoluteFilePathname(moduleFilePathName)

		val moduleName =
			if (absoluteModuleFilePathName == rootModuleAbsolutePathName.get) rootModuleName.get
			else FileUtil convertFileToClassName (absoluteModuleFilePathName, rootModuleAbsolutePathName.get)

		if (modules contains moduleName unary_!) modules.synchronized
		{
			if (modules contains moduleName unary_!)
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
		val generator = new BytecodeGenerator(moduleName)

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
