package loki.util

import java.io._
import java.nio.file.Paths

import scala.annotation.tailrec
import scala.language.postfixOps

object FileUtil
{
	def workingDirectoryAbsolutePathname:String = new File(".").getAbsolutePath

	def getAbsoluteFilePathname(filePathname:String):String = new File(filePathname).getAbsolutePath

	def convertFileToClassName(file:String, rootFile:String):String =
	{
		val relativeFilePathName = (
			Paths
				get new File(rootFile).getAbsolutePath
				relativize (Paths get new File(file).getAbsolutePath)
				toString
		)

		relativeFilePathName replace(".", "") replace (s"..${File.separator}", "$") replace (File.separator, "$")
	}


	def getFilePathnameWithoutExtension(filePathname:String):String = (
		filePathname
			substring (0, {val index = filePathname lastIndexOf "."; if (index != -1) index else filePathname.length})
	)

	def writeText(filePathname:String, text:String):Unit =
	{
		val bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePathname)))
		try {bufferedWriter.write(text)}
		finally {bufferedWriter.close()}
	}

	def writeText(filePathname:String, textLines:Seq[String]):Unit =
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

	def deleteFolder(folderPathname:String):Unit =
	{
		val folderFile = new File(folderPathname)
		if (!folderFile.exists) return

		(
			folderFile.listFiles
				foreach(file =>
					if (file.isDirectory) deleteFolder(file.getAbsolutePath)
					else file.delete()
				)
		)

		folderFile.delete()
	}
}
