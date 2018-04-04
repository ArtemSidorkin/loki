package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.rule.template.ContainerGenerationBytecodeRuleTemplate
import loki.language.generation.rule.mixin.ArrayGenerationRuleMixin
import loki.language.parsing.LokiParser.ArrayContext

class ArrayGenerationBytecodeRule(bytecodeGenerationContext:BytecodeGenerationContext, arrayContext:ArrayContext)
	extends BytecodeGenerationRule(bytecodeGenerationContext, arrayContext) with ArrayGenerationRuleMixin
{
	override protected def enterAction():Unit =
		new ContainerGenerationBytecodeRuleTemplate(bytecodeGenerationContext, arrayContext)
			.enter(arrayClass, arrayItemCount, arrayItemExpressionContexts)

	override protected def exitAction():Unit =
		new ContainerGenerationBytecodeRuleTemplate(bytecodeGenerationContext, arrayContext)
			.exit(arrayClass)
}