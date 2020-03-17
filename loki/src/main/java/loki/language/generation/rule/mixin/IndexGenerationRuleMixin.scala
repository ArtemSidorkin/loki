package loki.language.generation.rule.mixin

import loki.language.generation.constant.LanguageMembers
import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser
import loki.language.parsing.LokiParser.IndexContext

import scala.collection.JavaConverters._

private[generation] trait IndexGenerationRuleMixin
	extends GenerationRuleMixin[IndexContext] with MemberCallGenerationRuleMixinTemplate
{
	override protected val memberName:String = LanguageMembers.UNIT__METHOD__GET_INDEXED_ITEM

	override protected val hostExpressionContext:LokiParser.ExpressionContext = ruleContext.expression.asScala.head

	override protected val callParameterExpressionContexts:collection.Seq[LokiParser.ExpressionContext] =
		ruleContext.expression.asScala.tail
}
