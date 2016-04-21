package cloki.system

import cloki.execution.CExecution.{CExecutionTarget, CExecutionTargetBytecode}

object CSystemSettings
{
	@volatile var TRACE_BYTECODE = false

	@volatile var EXECUTION_TARGET:CExecutionTarget = CExecutionTargetBytecode
}
