package cloki.execution

import cloki.execution.executors.{Executor, ExecutorContainer, ExecutorBytecode, ExecutorJava}
import cloki.system.SystemSettings

object Execution
{
	sealed class ExecutionTarget
	object ExecutionTargetJava extends ExecutionTarget
	object ExecutionTargetBytecode extends ExecutionTarget

	def executor:ExecutorContainer[_ <: Executor[_]] = SystemSettings.EXECUTION_TARGET match
	{
		case _:ExecutionTargetBytecode.type => ExecutorBytecode
		case _:ExecutionTargetJava.type => ExecutorJava
		case executor => throw new IllegalArgumentException(s"""Unknown executor "$executor"!""")
	}
}
