package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.StringBytecodeTemplate.StringBytecodeTemplate
import loki.language.parsing.LokiParser


private[generation] class StringGenerationRule(
	bytecodeGenerationContext:GenerationContext, stringContext:LokiParser.StringContext
)
	extends GenerationRule(bytecodeGenerationContext, stringContext)
{
	private def rawString:String = ruleContext.getText
	private def isAcuteString:Boolean = rawString startsWith "`"

	override protected def enterAction()
	{
		(
			topMethodCall
			newString ()
			dup ()
			ldc preparedString
			invokeInitString ()
			incrementObjectCounter ()
		)

		def preparedString = (if (isAcuteString) rawString else rawString split "\n" map (_ init) mkString "\n") tail
	}
}

private[generation] object StringGenerationRule
{
	def enter(bytecodeGenerationContext:GenerationContext, stringContext:LokiParser.StringContext):Unit =
		new StringGenerationRule(bytecodeGenerationContext, stringContext).enter()

	def exit(bytecodeGenerationContext:GenerationContext, stringContext:LokiParser.StringContext):Unit =
		new StringGenerationRule(bytecodeGenerationContext, stringContext).exit()
}