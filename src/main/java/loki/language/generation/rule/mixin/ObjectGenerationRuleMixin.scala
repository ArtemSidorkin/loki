package loki.language.generation.rule.mixin

import loki.language.generation.rule.mixin.template.ContainerGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser.{ExpressionContext, ObjectContext}
import loki.runtime.unit.LObject
import loki.runtime.unit.unit.LUnit

import scala.collection.JavaConverters._

private[generation] trait ObjectGenerationRuleMixin
	extends GenerationRuleMixin[ObjectContext] with ContainerGenerationRuleMixinTemplate
{
	protected val containerClass:Class[_ <: LUnit] = classOf[LObject]

	protected val containerItemExpressionContexts:Seq[ExpressionContext] = ruleContext.expression.asScala
}
