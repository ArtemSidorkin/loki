package loki

import java.io.File

import loki.execution.Execution
import loki.system.SystemSettings
import loki.test.Tester
import loki.util.ConsoleCommander

object Main extends App
{
	private val TEST_KEY = "--test"
	private val TRACE_PREPROCESSED_CODE = "--trace-preprocessed-code"


	{
		ConsoleCommander(
			args,
			arguments =>
			{
				if (arguments.parameterlessKeys contains TRACE_PREPROCESSED_CODE)
					SystemSettings.TRACE_PREPROCESSED_CODE = true

				if (arguments.parameterlessKeys contains TEST_KEY) Tester()

				if (arguments.keylessArguments.nonEmpty)
				{
					Execution.init(Array(new File(".").getAbsolutePath))
					Execution.executor.getModule(arguments.keylessArguments.head)
				}
			}
		)
	}
}

