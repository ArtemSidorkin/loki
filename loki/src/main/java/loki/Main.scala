package loki

import loki.system.SystemSettings
import loki.util.ConsoleCommander

object Main extends App
{
	private val TRACE_PREPROCESSED_CODE = "--trace-preprocessed-code"

	{
		ConsoleCommander(
			args,
			arguments =>
			{
				if (arguments.parameterlessKeys contains TRACE_PREPROCESSED_CODE)
					SystemSettings.TRACE_PREPROCESSED_CODE = true

				if (arguments.keylessArguments.nonEmpty)
					Executor.getModule(arguments.keylessArguments.head)
			}
		)
	}
}

