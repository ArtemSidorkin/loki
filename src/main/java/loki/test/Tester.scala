package loki.test

import java.io.File

import loki.execution.Execution
import loki.execution.Execution.{ExecutionTargetBytecode, ExecutionTargetJava}
import loki.system.SystemSettings
import loki.util.FileUtil

object Tester
{
	def apply()
	{
		println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
		println("Starting bytecode testing...")
		println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")

		SystemSettings.EXECUTION_TARGET = ExecutionTargetBytecode
		val succeededToAllTestsByteCodeCounter = startTesting()
		println("-----------------------------------------------------------------------------------------------------")

		println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
		println("Starting java testing...")
		println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")

		SystemSettings.EXECUTION_TARGET = ExecutionTargetJava
		val succeededToAllTestsJavaCodeCounter = startTesting()

		println("-----------------------------------------------------------------------------------------------------")
		println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
		println("-----------------------------------------------------------------------------------------------------")
		println()

		println(
			s"${succeededToAllTestsByteCodeCounter._1} " +
			s"of ${succeededToAllTestsByteCodeCounter._2} " +
			s"bytecode tests succeed."
		)
		println(
			s"${succeededToAllTestsJavaCodeCounter._1} " +
			s"of ${succeededToAllTestsJavaCodeCounter._2} " +
			s"java tests succeed."
		)

	}

	private def startTesting():(Int, Int) =
		TestSuit
			.testCases
			.foldLeft((0, 0))((succeededToAllTestsCounterCollector, testCase) =>
				if (executeTestCase(testCase))
					(succeededToAllTestsCounterCollector._1 + 1, succeededToAllTestsCounterCollector._2 + 1)
				else (succeededToAllTestsCounterCollector._1, succeededToAllTestsCounterCollector._2 + 1)
			)

	private def executeTestCase(testCase:TestCase):Boolean =
	{
		println("-----------------------------------------------------------------------------------------------------")
		println(s"testing ${testCase.name}:")
		try
		{
			(
				testCase.sourceFilePathnames
					foreach (sourceFilePathname =>
						FileUtil
							.writeText(
								new File(sourceFilePathname).getName, FileUtil readText (sourceFilePathname, true)
							)
					)
			)

			Execution.init(modulePaths = new File(".").getAbsolutePath :: Nil, force = true)
			Execution.executor.getModuleInstance(new File(testCase.sourceFilePathnames.head).getName)

			true
		}
		catch
		{
			case exception:Exception =>
				println(s"test ${testCase.name} failed:")
				exception.printStackTrace(Execution.executor.outputPrintStream)
				false
		}
		finally
		{
			(
				testCase.sourceFilePathnames
					foreach (sourceFilePathname =>
					{
						val sourceFile = new File(sourceFilePathname)
						new File(sourceFile.getName).delete()
						FileUtil.deleteFolder(FileUtil.getFilePathnameWithoutExtension(sourceFile.getName))
					})
			)
		}
	}
}
