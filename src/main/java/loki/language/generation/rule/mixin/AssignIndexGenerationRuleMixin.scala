package loki.language.generation.rule.mixin

import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser.{AssignIndexContext, ExpressionContext}
import loki.runtime.constant.LUnitMember

import scala.collection.JavaConverters._

private[generation] trait AssignIndexGenerationRuleMixin
	extends GenerationRuleMixin[AssignIndexContext] with MemberCallGenerationRuleMixinTemplate
{
	override protected val memberName:String = LUnitMember.SET_INDEX_ITEM.name
	override protected val memberExpressionContext:ExpressionContext = ruleContext.expression.asScala.head
	override protected val parameterExpressionContexts: Seq[ExpressionContext] = ruleContext.expression.asScala.tail
}
