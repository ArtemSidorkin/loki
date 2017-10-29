package cloki.system

import cloki.execution.Execution.{ExecutionTarget, ExecutionTargetBytecode}

object SystemSettings
{
	@volatile var TRACE_BYTECODE = false

	@volatile var EXECUTION_TARGET:ExecutionTarget = ExecutionTargetBytecode
}
