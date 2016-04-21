package cloki.utils

import java.io._

import scala.annotation.tailrec

object CFile
{
	def writeText(filePathname:String, text:String)
	{
		val bfrdWrtr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePathname)))
		try {bfrdWrtr.write(text)}
		finally {bfrdWrtr.close()}
	}

	def writeText(filePathname:String, textLines:Seq[String])
	{
		val bfrdWrtr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePathname)))
		try
		{
			textLines foreach (strng =>
			{
				bfrdWrtr.write(strng)
				bfrdWrtr.newLine()
			})
		}
		finally {bfrdWrtr.close()}
	}

	def readBytes(filePathname:String) =
	{
		val flInptStrm = new FileInputStream(filePathname)
		try
		{
			val bfr = new Array[Byte](flInptStrm.available)
			flInptStrm.read(bfr)
			bfr
		}
		finally {flInptStrm.close()}
	}

	def readText(filePathname:String, classPath:Boolean = false) =
	{
		val bfrdRdr = new BufferedReader(
			new InputStreamReader
			(
				if (!classPath) new FileInputStream(filePathname) else getClass.getResourceAsStream(filePathname)
			)
		)
		try
		{
			val strngBldr = new StringBuilder
			readAndAddLine(bfrdRdr.readLine())

			@tailrec
			def readAndAddLine(line:String):Unit = if (line != null)
			{
				if (strngBldr.nonEmpty) strngBldr += '\n'
				strngBldr ++= line
				readAndAddLine(bfrdRdr.readLine())
			}

			strngBldr.toString
		}
		finally {bfrdRdr.close()}
	}
}
