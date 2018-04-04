package loki.language.generation.rule.mixin

import loki.language.parsing.LokiParser.{ExpressionContext, ObjectContext}
import loki.runtime.datatype.{LObject, LUnit}

import scala.collection.JavaConverters._

private[generation] trait ObjectGenerationRuleMixin extends GenerationRuleMixin[ObjectContext]
{
	protected val objectClass:Class[_ <: LUnit] = classOf[LObject]
	protected val objectMemberNameValueItemCount:Int = ruleContext.expression.size
	protected val objectKeyValueItemExpressionContexts:Seq[ExpressionContext] = ruleContext.expression.asScala
}
