package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser

private[generation] trait StringGenerationRuleMixin extends GenerationRuleMixin[LokiParser.StringContext]
{
	protected val string:String = ruleContext.getText substring 1

	protected def isAcuteString:Boolean = ruleContext.getText startsWith "`"
}
