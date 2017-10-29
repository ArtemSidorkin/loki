package cloki.test

import cloki.util.FileUtil

private[test] object CTestSuit
{
	val TEST_CASES =
	(
		FileUtil
		readText ("/test/test.registry", classPath = true)
		split "\n"
		map (_ split "," map (_ trim ()))
		map (tstCs => CTestCase(tstCs(0), tstCs(1) split ";" map (_ trim ()), tstCs(2)))
	)
}
