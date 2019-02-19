package loki.language.generation.rule.mixin

import loki.language.generation.rule.mixin.template.ContainerGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser.{ExpressionContext, MapContext}
import loki.runtime.datatype.LMap
import loki.runtime.datatype.unit.LUnit

import scala.collection.JavaConverters._

private[generation] trait MapGenerationRuleMixin
	extends GenerationRuleMixin[MapContext] with ContainerGenerationRuleMixinTemplate
{
	override protected val containerClass:Class[_ <: LUnit] = classOf[LMap]

	override protected val containerItemExpressionContexts:Seq[ExpressionContext] = ruleContext.expression.asScala
}
