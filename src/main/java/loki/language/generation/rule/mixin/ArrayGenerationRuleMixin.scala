package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.{ArrayContext, ExpressionContext}
import loki.runtime.datatype.{LArray, LUnit}

import scala.collection.JavaConverters._

private[generation] trait ArrayGenerationRuleMixin extends GenerationRuleMixin[ArrayContext]
{
	protected val arrayClass:Class[_ <: LUnit] = classOf[LArray]
	protected val arrayItemCount:Int = ruleContext.expression.size
	protected val arrayItemExpressionContexts:Seq[ExpressionContext] = ruleContext.expression.asScala
}
