package cloki.test

import java.io.File

import cloki.execution.Execution
import cloki.execution.Execution.{ExecutionTargetBytecode, ExecutionTargetJava}
import cloki.system.{SystemConfiguration, SystemSettings}
import cloki.util.FileUtil

object Tester
{
	def apply()
	{
		println("Starting bytecode testing...")
		SystemSettings.EXECUTION_TARGET = ExecutionTargetBytecode
		val succeededToAllByteCodeCounter = startTesting()
		println()

		println("Starting java testing...")
		SystemSettings.EXECUTION_TARGET = ExecutionTargetJava
		val succeededToAllJavaCodeCounter = startTesting()
		println()

		println(s"${succeededToAllByteCodeCounter._1} of ${succeededToAllByteCodeCounter._2} bytecode tests succeed.")
		println(s"${succeededToAllJavaCodeCounter._1} of ${succeededToAllJavaCodeCounter._2} java tests succeed.")

	}

	private def startTesting():(Int, Int) =
		TestSuit
			.testCases
			.foldLeft((0, 0))((succeededToAllTestCounterCollector, testCase) =>
			{
				if (executeTestCase(testCase))
					(succeededToAllTestCounterCollector._1 + 1, succeededToAllTestCounterCollector._2 + 1)
				else (succeededToAllTestCounterCollector._1 + 1, succeededToAllTestCounterCollector._2 + 1)
			})

	private def executeTestCase(testCase:TestCase):Boolean =
	{
		(
			testCase.sourceFilePathnames
				foreach (sourceFilePathname =>
				{
					val sourceFile = new File(sourceFilePathname)

					FileUtil
						.writeText(
							s"${sourceFile.getName}.${SystemConfiguration.SOURCE_FILE_EXTENSION}",
							FileUtil
								readText (s"$sourceFilePathname.${SystemConfiguration.SOURCE_FILE_EXTENSION}", true)
						)
				})
		)

		val testOutputStream = new TestOutputStream
		initTestOutputStream(testOutputStream)
		val startSourceFile = new File(testCase.sourceFilePathnames.head)
		Execution.executor.getModuleInstance(startSourceFile.getName)
		val expected = FileUtil readText (testCase.expectedOutputFilePathname, true)

		(
			testCase.sourceFilePathnames
				foreach (srcFlPthnm =>
				{
					val srcFl = new File(srcFlPthnm)
					new File(s"${srcFl.getName}.${SystemConfiguration.SOURCE_FILE_EXTENSION}").delete()

					if (SystemSettings.EXECUTION_TARGET == ExecutionTargetJava)
					{
						val cmpldFldr = new File(srcFl.getName)
						cmpldFldr.listFiles foreach (_.delete())
						cmpldFldr.delete()
					}
				})
		)

		if (testOutputStream.content == expected)
		{
			println(s"""Test case "${testCase.name}" succeeded.""")
			true
		}
		else
		{
			println(
				s"""Test case "${testCase.name}" failed.
				   | Got: \n"${testOutputStream.content}", expected: \n"$expected" """
					.stripMargin
			)
			false
		}
	}

	private def initTestOutputStream(testOutputStream:TestOutputStream):Unit =
		Execution
			.init(
				modulePaths = new File(".").getAbsolutePath :: Nil,
				force = true,
				outputPrintStream = testOutputStream,
				errorPrintStream = testOutputStream
			)
}
