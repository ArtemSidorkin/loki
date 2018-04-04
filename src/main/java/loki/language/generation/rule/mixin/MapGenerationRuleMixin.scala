package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.{ExpressionContext, MapContext}
import loki.runtime.datatype.{LMap, LUnit}

import scala.collection.JavaConverters._

private[generation] trait MapGenerationRuleMixin extends GenerationRuleMixin[MapContext]
{
	protected val mapClass:Class[_ <: LUnit] = classOf[LMap]
	protected val mapKeyValueItemCount:Int = ruleContext.expression.size
	protected val mapKeyValueItemExpressionContexts:Seq[ExpressionContext] = ruleContext.expression.asScala
}
