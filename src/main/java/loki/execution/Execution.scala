package loki.execution

import java.io.PrintStream

import loki.language.generation.bytecode.BytecodeGenerator
import loki.language.generation.java.JavaGenerator
import loki.system.SystemSettings

object Execution
{
	sealed class ExecutionTarget
	object ExecutionTargetJava extends ExecutionTarget
	object ExecutionTargetBytecode extends ExecutionTarget

	@volatile
	private var _executor:Executor = null.asInstanceOf[Executor]

	def executor:Executor = _executor

	def init(
		modulePaths:Seq[String],
		force:Boolean = false,
		outputPrintStream:PrintStream = System.out,
		errorPrintStream:PrintStream = System.err
	):Unit =
		if (_executor == null || force) this.synchronized
		{
			if (_executor == null || force)
				_executor = new Executor(
					modulePaths,
					outputPrintStream,
					errorPrintStream,
					SystemSettings.EXECUTION_TARGET match
					{
						case _:ExecutionTargetBytecode.type => new BytecodeGenerator(_)
						case _:ExecutionTargetJava.type => new JavaGenerator(_)
						case executor => throw new IllegalArgumentException(s"""Unknown executor "$executor"!""")
					}
				)
		}
}