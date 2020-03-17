package loki

import java.io.{ByteArrayInputStream, File}
import java.nio.charset.StandardCharsets
import java.nio.file.Paths
import java.util.concurrent.ConcurrentHashMap

import loki.language.generation.BytecodeGenerator
import loki.language.parsing.{LokiLexer, LokiParser}
import loki.language.preprocessing.Preprocessor
import loki.runtime.unit.LModule
import loki.runtime.unit.unit.LUnit
import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.apache.commons.io.FileUtils

import scala.jdk.CollectionConverters._
import scala.language.postfixOps

object Executor
{
	private val modules:collection.mutable.Map[String, LModule] = new ConcurrentHashMap[String, LModule]().asScala

	private var rootModulePathName:Option[String] = None
	private var rootModuleAbsolutePathName:Option[String] = None
	private var rootModuleName:Option[String] = None

	private lazy val workingDirectoryAbsolutePathname:String = new File(".").getAbsolutePath

	def getModule(moduleFilePathName:String):LModule =
	{
		if (rootModulePathName.isEmpty) this.synchronized
		{
			if (rootModulePathName.isEmpty)
			{
				rootModulePathName = Some(moduleFilePathName)
				rootModuleAbsolutePathName = Some(new File(rootModulePathName.get).getAbsolutePath)
				rootModuleName = Some(
				convertFileToClassName (
					getAbsoluteFilePathname(rootModulePathName.get), workingDirectoryAbsolutePathname
				))
			}
		}

		val absoluteModuleFilePathName = getAbsoluteFilePathname(moduleFilePathName)

		val moduleName =
			if (absoluteModuleFilePathName == rootModuleAbsolutePathName.get) rootModuleName.get
			else convertFileToClassName (absoluteModuleFilePathName, rootModuleAbsolutePathName.get)

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
					Preprocessor(FileUtils.readFileToString(new File(moduleFilePathname), StandardCharsets.UTF_8)) getBytes StandardCharsets.UTF_8
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

	private def convertFileToClassName(file:String, rootFile:String):String =
	{
		val relativeFilePathName = (
			Paths
				get new File(rootFile).getAbsolutePath
				relativize (Paths get new File(file).getAbsolutePath)
				toString
			)

		relativeFilePathName replace(".", "") replace (s"..${File.separator}", "$") replace (File.separator, "$")
	}

	private def getAbsoluteFilePathname(filePathname:String):String = new File(filePathname).getAbsolutePath
}
