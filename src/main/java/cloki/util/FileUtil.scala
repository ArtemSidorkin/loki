package cloki.util

import java.io._

import scala.annotation.tailrec

object FileUtil
{
	def getFilePathnameWithoutExtension(filePathname:String) = (
		filePathname
			substring (0, {val index = filePathname lastIndexOf "."; if (index != -1) index else filePathname.length})
	)

	def writeText(filePathname:String, text:String)
	{
		val bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePathname)))
		try {bufferedWriter.write(text)}
		finally {bufferedWriter.close()}
	}

	def writeText(filePathname:String, textLines:Seq[String])
	{
		val bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePathname)))

		try
		{
			(
				textLines
					foreach (string =>
					{
						bufferedWriter.write(string)
						bufferedWriter.newLine()
					})
			)
		}
		finally {bufferedWriter.close()}
	}

	def readBytes(filePathname:String):Array[Byte] =
	{
		val fileInputStream = new FileInputStream(filePathname)

		try
		{
			val bytes = new Array[Byte](fileInputStream.available)
			fileInputStream.read(bytes)
			bytes
		}
		finally {fileInputStream.close()}
	}

	def readText(filePathname:String, classPath:Boolean = false):String =
	{
		val bufferedReader =
			new BufferedReader(
				new InputStreamReader(
					if (!classPath) new FileInputStream(filePathname) else getClass.getResourceAsStream(filePathname)
				)
			)

		try
		{
			val stringBuilder = new StringBuilder
			readAndAddLine(bufferedReader.readLine())

			@tailrec
			def readAndAddLine(line:String):Unit =
				if (line != null)
				{
					if (stringBuilder.nonEmpty) stringBuilder += '\n'

					stringBuilder ++= line
					readAndAddLine(bufferedReader.readLine())
				}

			stringBuilder.toString
		}
		finally {bufferedReader.close()}
	}
}
