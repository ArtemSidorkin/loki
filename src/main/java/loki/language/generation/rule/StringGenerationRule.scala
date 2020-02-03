package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.StringBytecodeTemplate.StringBytecodeTemplate
import loki.language.parsing.LokiParser

private[generation] class StringGenerationRule
	(stringContext:LokiParser.StringContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(stringContext)
{
	private def rawString:String = stringContext.getText
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
	def enter(stringContext:LokiParser.StringContext)(implicit bytecodeGenerationContext:GenerationContext):Unit =
		new StringGenerationRule(stringContext).enter()

	def exit(stringContext:LokiParser.StringContext)(implicit bytecodeGenerationContext:GenerationContext):Unit =
		new StringGenerationRule(stringContext).exit()
}