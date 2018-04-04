package loki.language.generation.java.rule

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.java.rule.template.ContainerGenerationJavaRuleTemplate
import loki.language.generation.rule.mixin.ObjectGenerationRuleMixin
import loki.language.parsing.LokiParser.ObjectContext

class ObjectGenerationJavaRule(javaGenerationContext:JavaGenerationContext, objectContext:ObjectContext)
	extends ContainerGenerationJavaRuleTemplate(javaGenerationContext, objectContext) with ObjectGenerationRuleMixin