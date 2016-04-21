package cloki

import java.io.File
import cloki.execution.CExecution
import cloki.execution.CExecution.{CExecutionTargetBytecode, CExecutionTargetJava}
import cloki.system.CSystemSettings
import cloki.test.{CTester, CTestSuit}
import cloki.utils.CConsoleCommander

object CMain extends App
{
	{
		CSystemSettings.EXECUTION_TARGET = CExecutionTargetBytecode

		CConsoleCommander(
			parameters = args,
			keylessParameterCountOrRange = None,
			keylessParameterTip = None,
			keyParameterCountOrRange = Map
			(
				"-java" -> Some(Left(0)),
				"-test" -> Some(Left(0)),
				"-help" -> Some(Left(0))
			),
			keyParameterTips = Map
			(
				"-java" -> """"java" has no parameters""",
				"-test" -> """"test" has no parameters""",
				"-help" -> """"help" has no parameters"""
			),
			controller = (keyPrmtrs) =>
			{
				if (keyPrmtrs contains "-java") CSystemSettings.EXECUTION_TARGET = CExecutionTargetJava

				if (keyPrmtrs contains "")
				{
					CExecution.executor.init(Array(new File(".").getAbsolutePath))
					CExecution.executor.instance.getModuleInstance(keyPrmtrs("").head)
				}
				else if (keyPrmtrs contains "-test") CTester()
				else if (keyPrmtrs contains "-help") println("Not implemented yet.")
				else println("""print "-help" for info""")
			}
		)
	}
}

