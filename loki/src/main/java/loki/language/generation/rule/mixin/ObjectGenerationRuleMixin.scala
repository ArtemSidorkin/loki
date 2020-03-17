package loki.language.generation.rule.mixin

import loki.language.generation.rule.mixin.template.ContainerGenerationRuleMixinTemplate
import loki.language.parsing.LokiParser.{ExpressionContext, ObjectContext}
import loki.runtime.unit.data.LObject
import loki.runtime.unit.unit.LUnit

import scala.jdk.CollectionConverters._

private[generation] trait ObjectGenerationRuleMixin
	extends GenerationRuleMixin[ObjectContext] with ContainerGenerationRuleMixinTemplate
{
	protected val containerClass:Class[_ <: LUnit] = classOf[LObject]

	protected val containerItemExpressionContexts:collection.Seq[ExpressionContext] = ruleContext.expression.asScala
}
