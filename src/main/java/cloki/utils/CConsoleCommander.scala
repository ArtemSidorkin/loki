package cloki.utils

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object CConsoleCommander
{
	def apply
	(
		parameters:Array[String],
		keylessParameterCountOrRange:Option[Either[Int, (Int, Int)]],
		keylessParameterTip:Option[String],
		keyParameterCountOrRange:collection.Map[String, Option[Either[Int, (Int, Int)]]],
		keyParameterTips:collection.Map[String, String],
		controller:(collection.Map[String, Seq[String]])=>Unit
	):Unit =
	{
		val keyPrmtrs = mutable.HashMap[String, mutable.Buffer[String]]()

		if (parameters.headOption exists (_ startsWith "-" unary_!))
			keyPrmtrs += "" -> (parameters takeWhile (_ startsWith "-" unary_!) toBuffer)

		val keylsPrmtrCnt = keyPrmtrs getOrElse ("", mutable.ArrayBuffer()) size

		var lastKey:String = ""

		(parameters view (keylsPrmtrCnt, parameters.length)).foldLeft(0)((i, arg) =>
		{
			if (arg startsWith "-")
			{
				lastKey = arg
				keyPrmtrs += arg -> ArrayBuffer()
			}
			else keyPrmtrs(lastKey) += arg

			i + 1
		})

		keylessParameterCountOrRange foreach (keylsPrmtrCntOrRng =>
		{
			keylsPrmtrCntOrRng fold (cnt =>
			{
				if (keyPrmtrs("").size != cnt)
				{
					println(keylessParameterTip getOrElse "Wrong count of started parameters")
					return
				}
			}, rng =>
			{
				if (keyPrmtrs("").size < rng._1 || keyPrmtrs("").size > rng._2)
				{
					println(keylessParameterTip getOrElse "Wrong count of started parameters")
					return
				}
			})
		})

		keyPrmtrs.view filter(_._1 != "") foreach (keyPrmtr =>
			if (keyParameterCountOrRange contains keyPrmtr._1 unary_!)
			{
				println(s"""Unknown parameter "${keyPrmtr._1}"""")
				return
			} else
			{
				keyParameterCountOrRange(keyPrmtr._1) foreach (_ fold (cnt =>
				{
					if (keyPrmtr._2.size != cnt)
					{
						println(keyParameterTips getOrElse (keyPrmtr._1, s"""Wrong count for "${keyPrmtr._1}" parameter""""))
						return
					}
				}, rng =>
				{
					if (keyPrmtr._2.size < rng._1 || keyPrmtr._2.size > rng._2)
					{
						println(keyParameterTips getOrElse (keyPrmtr._1, s"""Wrong count for "${keyPrmtr._1}" parameter""""))
						return
					}
				}))
			}
		)

		controller(keyPrmtrs)
	}
}
