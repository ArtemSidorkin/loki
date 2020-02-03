package loki.language.generation.rule.mixin

import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser
import loki.language.parsing.LokiParser.IndexContext
import loki.runtime.constant.LUnitMember

import scala.collection.JavaConverters._

private[generation] trait IndexGenerationRuleMixin
	extends GenerationRuleMixin[IndexContext] with MemberCallGenerationRuleMixinTemplate
{
	override protected val memberName:String = LUnitMember.GET_INDEXED_ITEM.name

	override protected val hostExpressionContext:LokiParser.ExpressionContext = ruleContext.expression.asScala.head

	override protected val callParameterExpressionContexts:Seq[LokiParser.ExpressionContext] =
		ruleContext.expression.asScala.tail
}
