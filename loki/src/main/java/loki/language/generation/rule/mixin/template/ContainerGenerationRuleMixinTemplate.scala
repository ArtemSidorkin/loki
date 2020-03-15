package loki.language.generation.rule.mixin.template

import loki.language.parsing.LokiParser.ExpressionContext
import loki.runtime.unit.unit.LUnit

private[generation] trait ContainerGenerationRuleMixinTemplate
{
	protected val containerClass:Class[_ <: LUnit]

	protected val containerItemExpressionContexts:Seq[ExpressionContext]
}
