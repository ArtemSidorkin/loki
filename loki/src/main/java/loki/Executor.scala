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

	def apply(moduleFilePathname:String):LModule =
	{
		createRootModuleDescriptorIfNotExists(moduleFilePathname)
		getOrCreateModule(getModuleClassName(moduleFilePathname), moduleFilePathname)
	}

	private def createRootModuleDescriptorIfNotExists(moduleFilePathname:String):Unit =
		if (rootModuleDescriptor == null) modules.synchronized
		{
			if (rootModuleDescriptor == null) rootModuleDescriptor = new RootModuleDescriptor(moduleFilePathname)
		}

	private def getOrCreateModule(moduleClassName:String, moduleFilePathname:String):LModule =
	{
		if (!modules.contains(moduleClassName)) modules.synchronized
		{
			if (!modules.contains(moduleClassName))
			{
				val module = createModule(moduleClassName, moduleFilePathname)
				modules += moduleClassName -> module
				module.call(module)
			}
		}

		modules(moduleClassName)
	}

	private def createModule(moduleClassName:String, moduleFilePathname:String) =
	{
		val bytecodeGenerator = new BytecodeGenerator(moduleClassName)

		val moduleInputStream =
			new ANTLRInputStream(
				new ByteArrayInputStream(
					Preprocessor(FileUtils.readFileToString(new File(moduleFilePathname), StandardCharsets.UTF_8))
						.getBytes(StandardCharsets.UTF_8)
				)
			)

		val lexer = new LokiLexer(moduleInputStream)
		val commonTokenStream = new CommonTokenStream(lexer)
		val parser = new LokiParser(commonTokenStream)
		val moduleContext = parser.module()
		val parseTreeWalker = new ParseTreeWalker

		parseTreeWalker.walk(bytecodeGenerator, moduleContext)

		bytecodeGenerator
			.classLoader
			.getClass(moduleClassName)
			.getConstructors
			.head
			.newInstance()
			.asInstanceOf[LModule]
	}

	private def getModuleClassName(moduleFilePathname:String):String =
		if (getAbsoluteFilePathname(moduleFilePathname) == rootModuleDescriptor.absoluteFilePathname)
			rootModuleDescriptor.className
		else getRegularModuleClassName(moduleFilePathname, rootModuleDescriptor.absoluteFilePathname)

	private def getRootModuleClassName(moduleFilePathname:String):String =
		new File(moduleFilePathname).getName.replace(".", "$$")

	private def getRegularModuleClassName(moduleFilePathName:String, rootFilePathname:String):String =
			Paths
				.get(getAbsoluteFilePathname(rootFilePathname))
				.relativize(Paths.get(getAbsoluteFilePathname(moduleFilePathName)))
				.toString
				.replace(s"../", "$")
				.replace(".", "$$")
				.tail
				.replace("/", "$")

	private def getAbsoluteFilePathname(filePathname:String):String = new File(filePathname).getAbsolutePath

	private class RootModuleDescriptor(filePathname:String)
	{
		val className:String = getRootModuleClassName(filePathname)
		val absoluteFilePathname:String = getAbsoluteFilePathname(filePathname)
	}
}