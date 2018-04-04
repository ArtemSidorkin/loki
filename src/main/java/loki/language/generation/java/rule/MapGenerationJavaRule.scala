package loki.language.generation.java.rule

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.java.rule.template.ContainerGenerationJavaRuleTemplate
import loki.language.generation.rule.mixin.MapGenerationRuleMixin
import loki.language.parsing.LokiParser.MapContext

class MapGenerationJavaRule(javaGenerationContext:JavaGenerationContext, mapContext:MapContext)
	extends GenerationJavaRule(javaGenerationContext, mapContext) with MapGenerationRuleMixin
{
	override protected def enterAction():Unit =
		new ContainerGenerationJavaRuleTemplate(javaGenerationContext, mapContext)
			.enter(mapClass.getName, mapKeyValueItemCount, mapKeyValueItemExpressionContexts)


	override protected def exitAction():Unit =
		new ContainerGenerationJavaRuleTemplate(javaGenerationContext, mapContext).exit(mapKeyValueItemCount)
}
