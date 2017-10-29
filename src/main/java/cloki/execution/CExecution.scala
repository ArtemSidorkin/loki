package cloki.execution

import cloki.execution.executors.{CExecutor, CExecutor$$, CExecutorBytecode, CExecutorJava}
import cloki.system.CSystemSettings

object CExecution
{
	sealed class CExecutionTarget
	object CExecutionTargetJava extends CExecutionTarget
	object CExecutionTargetBytecode extends CExecutionTarget

	def executor:CExecutor$$[_ <: CExecutor[_]] = CSystemSettings.EXECUTION_TARGET match
	{
		case _:CExecutionTargetBytecode.type => CExecutorBytecode
		case _:CExecutionTargetJava.type => CExecutorJava
		case exctr => throw new IllegalArgumentException(s"""Unknown executor "$exctr"!""")
	}
}
