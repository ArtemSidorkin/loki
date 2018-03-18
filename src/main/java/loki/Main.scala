package loki

import java.io.File

import loki.execution.Execution
import loki.execution.Execution.{ExecutionTargetBytecode, ExecutionTargetJava}
import loki.system.SystemSettings
import loki.test.Tester
import loki.util.ConsoleCommander

object Main extends App
{
	private val JAVA_KEY = "--java"
	private val TEST_KEY = "--test"
	private val TRACE_PREPROCESSED_CODE = "--trace-preprocessed-code"


	{
		SystemSettings.EXECUTION_TARGET = ExecutionTargetBytecode

		ConsoleCommander(
			args,
			arguments =>
			{
				if (arguments.parameterlessKeys contains TRACE_PREPROCESSED_CODE)
					SystemSettings.TRACE_PREPROCESSED_CODE = true

				if (arguments.parameterlessKeys contains TEST_KEY) Tester()

				if (arguments.parameterlessKeys contains JAVA_KEY) SystemSettings.EXECUTION_TARGET = ExecutionTargetJava

				if (arguments.keylessArguments.nonEmpty)
				{
					Execution.init(Array(new File(".").getAbsolutePath))
					Execution.executor.getModuleInstance(arguments.keylessArguments.head)
				}
			}
		)
	}
}

