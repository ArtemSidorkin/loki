package loki.language.generation.java.rule

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.java.rule.template.ContainerGenerationJavaRuleTemplate
import loki.language.generation.rule.mixin.ObjectGenerationRuleMixin
import loki.language.parsing.LokiParser.ObjectContext

class ObjectGenerationJavaRule(javaGenerationContext:JavaGenerationContext, objectContext:ObjectContext)
	extends GenerationJavaRule(javaGenerationContext, objectContext) with ObjectGenerationRuleMixin
{
	override protected def enterAction():Unit =
		new ContainerGenerationJavaRuleTemplate(generationContext, ruleContext)
			.enter(objectClass.getName, objectMemberNameValueItemCount, objectKeyValueItemExpressionContexts)

	override protected def exitAction():Unit =
		new ContainerGenerationJavaRuleTemplate(generationContext, ruleContext).exit(objectMemberNameValueItemCount)
}