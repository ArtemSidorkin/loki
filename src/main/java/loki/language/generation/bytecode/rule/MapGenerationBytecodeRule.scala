package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.rule.template.ContainerGenerationBytecodeRuleTemplate
import loki.language.generation.rule.mixin.MapGenerationRuleMixin
import loki.language.parsing.LokiParser.MapContext

class MapGenerationBytecodeRule(bytecodeGenerationContext:BytecodeGenerationContext, mapContext:MapContext)
	extends ContainerGenerationBytecodeRuleTemplate(bytecodeGenerationContext, mapContext) with MapGenerationRuleMixin