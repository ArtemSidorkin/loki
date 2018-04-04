package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.rule.template.ContainerGenerationBytecodeRuleTemplate
import loki.language.generation.rule.mixin.MapGenerationRuleMixin
import loki.language.parsing.LokiParser.MapContext
import loki.runtime.datatype.LMap

class MapGenerationBytecodeRule(bytecodeGenerationContext:BytecodeGenerationContext, mapContext:MapContext)
	extends BytecodeGenerationRule(bytecodeGenerationContext, mapContext) with MapGenerationRuleMixin
{
	override protected def enterAction():Unit =
		new ContainerGenerationBytecodeRuleTemplate(bytecodeGenerationContext, mapContext)
			.enter(mapClass, mapKeyValueItemCount, mapKeyValueItemExpressionContexts)

	override protected def exitAction():Unit =
		new ContainerGenerationBytecodeRuleTemplate(bytecodeGenerationContext, mapContext)
			.exit(mapClass)
}