package loki.language.generation.rule.mixin

import loki.language.generation.constant.LanguageMembers
import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser.{AssignIndexContext, ExpressionContext}

import scala.collection.JavaConverters._

private[generation] trait AssignIndexGenerationRuleMixin
	extends GenerationRuleMixin[AssignIndexContext] with MemberCallGenerationRuleMixinTemplate
{
	override protected val memberName:String = LanguageMembers.UNIT__METHOD__SET_INDEXED_ITEM

	override protected val hostExpressionContext:ExpressionContext = ruleContext.expression.asScala.head

	override protected val callParameterExpressionContexts:collection.Seq[ExpressionContext] = ruleContext.expression.asScala.tail
}
