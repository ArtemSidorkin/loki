package loki.language.generation.java.rule

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.java.rule.template.ContainerGenerationJavaRuleTemplate
import loki.language.generation.rule.mixin.ArrayGenerationRuleMixin
import loki.language.parsing.LokiParser.ArrayContext

class ArrayGenerationJavaRule(javaGenerationContext:JavaGenerationContext, arrayContext:ArrayContext)
	extends GenerationJavaRule(javaGenerationContext, arrayContext) with ArrayGenerationRuleMixin
{
	override protected def enterAction():Unit =
		new ContainerGenerationJavaRuleTemplate(javaGenerationContext, arrayContext)
			.enter(arrayClass.getName, arrayItemCount, arrayItemExpressionContexts)


	override protected def exitAction():Unit =
		new ContainerGenerationJavaRuleTemplate(javaGenerationContext, arrayContext).exit(arrayItemCount)
}
