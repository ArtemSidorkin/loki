package cloki.execution.executors

import java.io.PrintStream

import cloki.language.generation.bytecode.CGeneratorBytecode

private[execution] class ExecutorBytecode private
(
	_modulePaths:Seq[String], outputPrintStream:PrintStream, errorPrintStream:PrintStream
) extends Executor(_modulePaths, outputPrintStream, errorPrintStream)
{
	override protected val generatorCreator = new CGeneratorBytecode(_)
}

private[execution] object ExecutorBytecode extends ExecutorContainer[ExecutorBytecode]
{
	override protected val executorCreator = new ExecutorBytecode(_, _, _)
}
