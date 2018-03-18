package loki.system

import loki.execution.Execution.{ExecutionTarget, ExecutionTargetBytecode}

object SystemSettings
{
	@volatile var TRACE_BYTECODE = false
	@volatile var TRACE_PREPROCESSED_CODE = false
	@volatile var EXECUTION_TARGET:ExecutionTarget = ExecutionTargetBytecode
}
