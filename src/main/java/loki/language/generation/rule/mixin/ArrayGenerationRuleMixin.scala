package loki.language.generation.rule.mixin

import loki.language.generation.rule.mixin.template.ContainerGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser.{ArrayContext, ExpressionContext}
import loki.runtime.datatype.LArray
import loki.runtime.datatype.unit.LUnit

import scala.collection.JavaConverters._

private[generation] trait ArrayGenerationRuleMixin
	extends GenerationRuleMixin[ArrayContext] with ContainerGenerationRuleMixinTemplate
{
	override protected val containerClass:Class[_ <: LUnit] = classOf[LArray]
	override protected val containerItemExpressionContexts:Seq[ExpressionContext] = ruleContext.expression.asScala
}
