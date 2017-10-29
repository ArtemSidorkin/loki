package cloki.execution.executor

import java.io.{ByteArrayInputStream, File, PrintStream}
import java.nio.charset.StandardCharsets
import java.util.concurrent.ConcurrentHashMap
import java.util.function.Consumer

import cloki.language.generation.CGenerator
import cloki.language.parsing.{CLokiLexer, CLokiParser}
import cloki.language.preprocessing.CPreprocessor
import cloki.runtime.datatype.LUnit
import cloki.runtime.context.LUnitContext
import cloki.util.FileUtil
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{ANTLRInputStream, CommonTokenStream}

import collection.JavaConversions._

private[execution] abstract class Executor[GENERATOR <: CGenerator[_]]
(
	_modulePaths:Seq[String],
	val outputPrintStream:PrintStream = System.out,
	val errorPrintStream:PrintStream = System.err
)
{
	protected val generatorCreator:(String=>CGenerator[_])

	private val modules:collection.mutable.Map[String, LUnit] = new ConcurrentHashMap[String, LUnit]()
	private val moduleInstances = new ConcurrentHashMap[String, LUnit]()
	private val modulePaths =
	(
		_modulePaths.view
		map (_ replace ('\\' , '/'))
		map (mdlPth => if (mdlPth endsWith "/" unary_!) mdlPth + "/" else mdlPth)
	)

	def getModule(relativeModulePathnameWithoutExtension:String, unitContext:Option[LUnitContext] = None) =
	{
		val mdlNm = getModuleName(relativeModulePathnameWithoutExtension)

		if (modules containsKey mdlNm unary_!) modules.synchronized
		{
			if (modules containsKey mdlNm unary_!)
				modules += mdlNm -> createModule(relativeModulePathnameWithoutExtension, unitContext)
		}

		modules(mdlNm)
	}

	def getModuleInstance(relativeModulePathnameWithoutExtension:String, parameters:Option[Array[LUnit]] = None) =
	{
		val mdlNm = getModuleName(relativeModulePathnameWithoutExtension)

		if (moduleInstances containsKey mdlNm unary_!) moduleInstances.synchronized
		{
			if (moduleInstances containsKey mdlNm unary_!)
			(
				getModule(relativeModulePathnameWithoutExtension).
				instantiate
				(
					parameters getOrElse null.asInstanceOf[Array[LUnit]],
					null.asInstanceOf[LUnitContext],
					new Consumer[LUnit]
					{
						override def accept(unit:LUnit) = moduleInstances += mdlNm -> unit
					}
				)
			)
		}

		moduleInstances(mdlNm)
	}

	private def getModuleName(relativeModulePathnameWithoutExtension:String) =
		relativeModulePathnameWithoutExtension replace ("/", "$")

	private def getModuleFilePathname(relativeModulePathnameWithoutExtension:String) =
	(
		modulePaths
		find (mdlPth => new File(s"$mdlPth$relativeModulePathnameWithoutExtension.cloki").exists())
		getOrElse
		(
			throw new IllegalArgumentException(s"""Module "$relativeModulePathnameWithoutExtension" not found""")
		)
	) + relativeModulePathnameWithoutExtension + ".cloki"

	private def createModule(relativeModulePathnameWithoutExtension:String, unitContext:Option[LUnitContext]) =
	{
		val mdlNm = getModuleName(relativeModulePathnameWithoutExtension)
		val gnrtr = generatorCreator(mdlNm)

		generate(gnrtr, relativeModulePathnameWithoutExtension)

		(gnrtr.classLoader getClass mdlNm).getConstructors.head.newInstance(
			unitContext getOrElse null.asInstanceOf[LUnitContext]
		).asInstanceOf[LUnit]
	}

	private def generate(generator:CGenerator[_], relativeModulePathnameWithoutExtension:String)()
	{
		val antlrInptStrm = new ANTLRInputStream(
			new ByteArrayInputStream
			(
				CPreprocessor
				(
					FileUtil readText getModuleFilePathname(relativeModulePathnameWithoutExtension)
				) getBytes StandardCharsets.UTF_8
			)
		)

		val lxr = new CLokiLexer(antlrInptStrm)
		val cmnTknStrm = new CommonTokenStream(lxr)
		val prsr = new CLokiParser(cmnTknStrm)
		val mdlCntxt = prsr.module()
		val prsTreeWlkr = new ParseTreeWalker

		prsTreeWlkr.walk(generator, mdlCntxt)
	}
}

private[execution] trait ExecutorContainer[EXECUTOR <: Executor[_]]
{
	protected val executorCreator:(Seq[String], PrintStream, PrintStream)=>EXECUTOR

	@volatile
	private var _instance:EXECUTOR = null.asInstanceOf[EXECUTOR]

	def instance = _instance

	def init
	(
		modulePaths:Seq[String],
		force:Boolean = false,
		outputPrintStream:PrintStream = System.out,
		errorPrintStream:PrintStream = System.err
	):Unit = if (_instance == null || force) this.synchronized
	{
		if (_instance == null || force) _instance = executorCreator(modulePaths, outputPrintStream, errorPrintStream)
	}
}