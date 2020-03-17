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

	@volatile private var rootModuleDescriptor:RootModuleDescriptor = _

	def getModule(moduleFilePathname:String):LModule =
	{
		createRootModuleDescriptorIfNotExists(moduleFilePathname)

		val moduleClassName = getModuleClassName(moduleFilePathname)

		createModuleIfNotExists(moduleClassName, moduleFilePathname)

		modules(moduleClassName)
	}

	private def createRootModuleDescriptorIfNotExists(moduleFilePathname:String):Unit =
		if (rootModuleDescriptor == null) modules.synchronized
		{
			if (rootModuleDescriptor == null) rootModuleDescriptor = new RootModuleDescriptor(moduleFilePathname)
		}

	private def createModuleIfNotExists(moduleName:String, moduleFilePathname:String):Unit =
		if (modules contains moduleName unary_!) modules.synchronized
		{
			if (modules contains moduleName unary_!)
			{
				val module = createModule(moduleName, moduleFilePathname)
				modules += moduleName -> module
				module.call(module, LUnit.EMPTY_UNIT_ARRAY)
			}
		}

	private def createModule(moduleName:String, moduleFilePathname:String) =
	{
		val generator = new BytecodeGenerator(moduleName)

		val antlrModuleInputStream =
			new ANTLRInputStream(
				new ByteArrayInputStream(
					Preprocessor(FileUtils.readFileToString(new File(moduleFilePathname), StandardCharsets.UTF_8))
						.getBytes(StandardCharsets.UTF_8)
				)
			)

		val lexer = new LokiLexer(antlrModuleInputStream)
		val commonTokenStream = new CommonTokenStream(lexer)
		val parser = new LokiParser(commonTokenStream)
		val moduleContext = parser.module()
		val parseTreeWalker = new ParseTreeWalker

		parseTreeWalker.walk(generator, moduleContext)

		generator
			.classLoader
			.getClass(moduleName)
			.getConstructors
			.head
			.newInstance()
			.asInstanceOf[LModule]
	}

	private def getModuleClassName(moduleFilePathname:String):String =
		if (getAbsoluteFilePathname(moduleFilePathname) == rootModuleDescriptor.absoluteFilePathname)
			rootModuleDescriptor.className
		else getRegularModuleClassName(moduleFilePathname, rootModuleDescriptor.absoluteFilePathname)

	private def getRegularModuleClassName(moduleFilePathName:String, rootFilePathname:String):String =
			Paths
				.get(getAbsoluteFilePathname(rootFilePathname))
				.relativize(Paths.get(getAbsoluteFilePathname(moduleFilePathName)))
				.toString
				.replace(s"..${File.separator}", "$")
				.replace(".", "$$")
				.tail
				.replace(File.separator, "$")

	private def getAbsoluteFilePathname(filePathname:String):String = new File(filePathname).getAbsolutePath

	private class RootModuleDescriptor(filePathname:String)
	{
		val className:String = new File(filePathname).getName.replace(".", "$$")
		val absoluteFilePathname:String = getAbsoluteFilePathname(filePathname)
	}
}
