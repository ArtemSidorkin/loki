package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.StringBytecodeTemplate.CTemplateNumber
import loki.language.parsing.LokiParser

class StringGenerationRule(
									  bytecodeGenerationContext:GenerationContext, stringContext:LokiParser.StringContext
) extends GenerationRule(bytecodeGenerationContext, stringContext)
{
	private val string:String = ruleContext.getText substring 1

	override protected def enterAction()
	{
		val preparedString =
			if (isAcuteString) string else string split "\n" map (string => s"""${string.init}""") mkString "\n"

		(
			topMethodCall
			newString ()
			dup ()
			ldc preparedString
			invokeInitString ()
			incrementObjectCounter ()
		)
	}

	private def isAcuteString:Boolean = ruleContext.getText startsWith "`"
}

object StringGenerationRule
{
	def enter(bytecodeGenerationContext:GenerationContext, stringContext:LokiParser.StringContext):Unit =
		new StringGenerationRule(bytecodeGenerationContext, stringContext).enter()

	def exit(bytecodeGenerationContext:GenerationContext, stringContext:LokiParser.StringContext):Unit =
		new StringGenerationRule(bytecodeGenerationContext, stringContext).exit()
}