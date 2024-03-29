package loki.language.generation.rule.mixin

import loki.language.generation.rule.mixin.template.ContainerGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser.{ExpressionContext, MapContext}
import loki.runtime.unit.data.LMap
import loki.runtime.unit.unit.LUnit

import scala.jdk.CollectionConverters._

private[generation] trait MapGenerationRuleMixin
	extends GenerationRuleMixin[MapContext] with ContainerGenerationRuleMixinTemplate
{
	override protected val containerClass:Class[_ <: LUnit] = classOf[LMap]

	override protected val containerItemExpressionContexts:collection.Seq[ExpressionContext] = ruleContext.expression.asScala
}
