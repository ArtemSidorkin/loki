package loki.language.generation.java.rule

import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.java.rule.template.ContainerGenerationJavaRuleTemplate
import loki.language.generation.rule.mixin.MapGenerationRuleMixin
import loki.language.parsing.LokiParser.MapContext

class MapGenerationJavaRule(javaGenerationContext:JavaGenerationContext, mapContext:MapContext)
	extends ContainerGenerationJavaRuleTemplate(javaGenerationContext, mapContext) with MapGenerationRuleMixin