package cloki.test

import java.io.File

import cloki.execution.Execution
import cloki.execution.Execution.{ExecutionTarget, ExecutionTargetJava, ExecutionTargetBytecode}
import cloki.system.{SystemSettings, CSystem}
import cloki.utils.CFile

object Tester
{
	def apply()
	{
		println("Starting bytecode testing...")
		SystemSettings.EXECUTION_TARGET = ExecutionTargetBytecode
		val scdToAllBtcdTstCntr = startTesting()
		println()

		println("Starting java testing...")
		SystemSettings.EXECUTION_TARGET = ExecutionTargetJava
		val scdToAllJavaTstCntr = startTesting()
		println()

		println(s"${scdToAllBtcdTstCntr._1} of ${scdToAllBtcdTstCntr._2} bytecode tests succeed.")
		println(s"${scdToAllJavaTstCntr._1} of ${scdToAllJavaTstCntr._2} java tests succeed.")

	}

	private def startTesting():(Int, Int) = CTestSuit.TEST_CASES.foldLeft((0, 0))((scdToAllTstCntrClctr, tstCs) =>
	{
		if (executeTestCase(tstCs)) (scdToAllTstCntrClctr._1 + 1, scdToAllTstCntrClctr._2 + 1)
		else (scdToAllTstCntrClctr._1 + 1, scdToAllTstCntrClctr._2 + 1)
	})

	private def executeTestCase(testCase:CTestCase):Boolean =
	{
		testCase.sourceFilePathnames foreach (srcFlPthnm =>
		{
			val srcFl = new File(srcFlPthnm)
			CFile.writeText(
				s"${srcFl.getName}.${CSystem.SOURCE_FILE_EXTENSION}",
				CFile readText (s"$srcFlPthnm.${CSystem.SOURCE_FILE_EXTENSION}", true)
			)
		})

		val tstOtptStrm = new CTestOutputStream
		initTestOutputStream(tstOtptStrm)
		val startSourceFile = new File(testCase.sourceFilePathnames.head)
		Execution.executor.instance.getModuleInstance(startSourceFile.getName)
		val expctd = CFile readText (testCase.expectedOutputFilePathname, true)

		testCase.sourceFilePathnames foreach (srcFlPthnm =>
		{
			val srcFl = new File(srcFlPthnm)
			new File(s"${srcFl.getName}.${CSystem.SOURCE_FILE_EXTENSION}").delete()

			if (SystemSettings.EXECUTION_TARGET == ExecutionTargetJava)
			{
				val cmpldFldr = new File(srcFl.getName)
				cmpldFldr.listFiles foreach (_.delete())
				cmpldFldr.delete()
			}
		})

		if (tstOtptStrm.content == expctd)
		{
			println(s"""Test case "${testCase.name}" succeed.""")
			true
		}
		else
		{
			println(s"""Test case "${testCase.name}" failed. Got: \n"${tstOtptStrm.content}", expected: \n"$expctd" """)
			false
		}
	}

	private def initTestOutputStream(testOutputStream:CTestOutputStream):Unit =
		Execution.executor.init(
			modulePaths = new File(".").getAbsolutePath :: Nil,
			force = true,
			outputPrintStream = testOutputStream,
			errorPrintStream = testOutputStream
		)
}
