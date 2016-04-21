package cloki.execution.executors

import java.io.PrintStream

import cloki.language.generation.java.CGeneratorJava

private[execution] class CExecutorJava private
(
	_modulePaths:Seq[String], outputPrintStream:PrintStream, errorPrintStream:PrintStream
) extends CExecutor(_modulePaths, outputPrintStream, errorPrintStream)
{
	override protected val generatorCreator = new CGeneratorJava(_)
}

private[execution] object CExecutorJava extends CExecutor$$[CExecutorJava]
{
	override protected val executorCreator = new CExecutorJava(_, _, _)
}
