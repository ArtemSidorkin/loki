package loki.language.generation.rule.mixin

import loki.language.generation.rule.mixin.template.ContainerGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser.{ArrayContext, ExpressionContext}
import loki.runtime.unit.data.LArray
import loki.runtime.unit.unit.LUnit

import scala.jdk.CollectionConverters._

private[generation] trait ArrayGenerationRuleMixin
	extends GenerationRuleMixin[ArrayContext] with ContainerGenerationRuleMixinTemplate
{
	override protected val containerClass:Class[_ <: LUnit] = classOf[LArray]

	override protected val containerItemExpressionContexts:collection.Seq[ExpressionContext] =
		ruleContext.expression.asScala
}
