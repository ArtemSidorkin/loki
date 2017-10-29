package cloki.execution.executor

import java.io.PrintStream

import cloki.language.generation.java.CGeneratorJava

private[execution] class ExecutorJava private (
	_modulePaths:Seq[String], outputPrintStream:PrintStream, errorPrintStream:PrintStream
)
	extends Executor(_modulePaths, outputPrintStream, errorPrintStream)
{
	override protected val generatorCreator = new CGeneratorJava(_)
}

private[execution] object ExecutorJava extends ExecutorContainer[ExecutorJava]
{
	override protected val executorCreator = new ExecutorJava(_, _, _)
}
