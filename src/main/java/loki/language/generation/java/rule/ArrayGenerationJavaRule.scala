package loki.language.generation.java.rule

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.java.rule.template.ContainerGenerationJavaRuleTemplate
import loki.language.generation.rule.mixin.ArrayGenerationRuleMixin
import loki.language.parsing.LokiParser.ArrayContext

class ArrayGenerationJavaRule(javaGenerationContext:JavaGenerationContext, arrayContext:ArrayContext)
	extends ContainerGenerationJavaRuleTemplate(javaGenerationContext, arrayContext) with ArrayGenerationRuleMixin