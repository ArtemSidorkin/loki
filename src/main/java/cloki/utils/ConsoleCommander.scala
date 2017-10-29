package cloki.utils

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object ConsoleCommander
{
	case class Arguments(
		keylessArguments:Seq[String],
		parameterlessKeys:Set[String],
		parameterizedKeys:collection.Map[String, Seq[String]]
	)

	def apply(arguments:Array[String], handler:(Arguments)=>Unit):Unit =
	{
		val keylessArguments = arguments takeWhile (_ startsWith "-" unary_!)
		val keysAndParameters = arguments drop keylessArguments.length
		val parameterlessKeys = keysAndParameters filter (_.startsWith("--"))
		val keysWithParameters = keysAndParameters filter (!_.startsWith("--"))

		val parameterizedKeys =
			keysWithParameters
				.foldLeft((keysWithParameters.headOption, mutable.HashMap[String, ArrayBuffer[String]]()))(
					(indexAndKeyParameterMap, argument) =>
					{
						val lastKeyParameter = indexAndKeyParameterMap._1.get
						indexAndKeyParameterMap._2.getOrElseUpdate(lastKeyParameter, ArrayBuffer())

						if (argument.startsWith("-")) (Some(argument), indexAndKeyParameterMap._2)
						else
						{
							indexAndKeyParameterMap._2(lastKeyParameter) += argument
							indexAndKeyParameterMap
						}
					}
				)
				._2

		handler(Arguments(keylessArguments, parameterlessKeys.toSet, parameterizedKeys))
	}
}
