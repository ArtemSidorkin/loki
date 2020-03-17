package loki.language.generation.rule.mixin

import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser
import loki.language.parsing.LokiParser.MemberCallContext

import scala.collection.JavaConverters._

private[generation] trait MemberCallGenerationRuleMixin
	extends GenerationRuleMixin[MemberCallContext] with MemberCallGenerationRuleMixinTemplate
{
	override protected val memberName:String = ruleContext.IDENTIFIER.getText

	override protected val hostExpressionContext:LokiParser.ExpressionContext = ruleContext expression 0

	override protected val callParameterExpressionContexts:collection.Seq[LokiParser.ExpressionContext] =
		ruleContext.expression.asScala.tail
}