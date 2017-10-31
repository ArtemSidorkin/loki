package cloki.test

import cloki.util.FileUtil

private[test] object TestSuit
{
	val testCases = (
		FileUtil
		readText ("/test/test.registry", classPath = true)
		split "\n"
		map (_ split "," map (_ trim ()))
		map (testCase => TestCase(testCase(0), testCase(1) split ";" map (_ trim ()), testCase(2)))
	)
}