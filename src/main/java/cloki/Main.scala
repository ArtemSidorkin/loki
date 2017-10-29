package cloki

import java.io.File

import cloki.execution.Execution
import cloki.execution.Execution.{ExecutionTargetBytecode, ExecutionTargetJava}
import cloki.system.SystemSettings
import cloki.test.Tester
import cloki.util.ConsoleCommander

object Main extends App
{
	private val JAVA_KEY = "--java"
	private val TEST_KEY = "--test"

	{
		SystemSettings.EXECUTION_TARGET = ExecutionTargetBytecode

		ConsoleCommander(
			args,
			arguments =>
			{
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

