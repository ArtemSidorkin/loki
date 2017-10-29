package cloki.execution.executors

import java.io.PrintStream

import cloki.language.generation.bytecode.CGeneratorBytecode

private[execution] class CExecutorBytecode private
(
	_modulePaths:Seq[String], outputPrintStream:PrintStream, errorPrintStream:PrintStream
) extends CExecutor(_modulePaths, outputPrintStream, errorPrintStream)
{
	override protected val generatorCreator = new CGeneratorBytecode(_)
}

private[execution] object CExecutorBytecode extends CExecutor$$[CExecutorBytecode]
{
	override protected val executorCreator = new CExecutorBytecode(_, _, _)
}
