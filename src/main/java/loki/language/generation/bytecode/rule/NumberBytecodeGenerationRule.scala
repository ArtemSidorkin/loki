package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecode.template.NumberBytecodeTemplate.CTemplateNumber
import loki.language.generation.rule.mixin.NumberGenerationRuleMixin
import loki.language.parsing.LokiParser.NumberContext

class NumberBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:NumberContext)
	extends BytecodeGenerationRule(generationContext, ruleContext) with NumberGenerationRuleMixin
{
	override protected def enterAction() =
	(
		topMethodCall
		newNumber ()
		dup ()
		ldc number
		invokeInitNumber ()
		incrementObjectCounter ()
	)
}

object NumberBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:NumberContext):Unit =
		new NumberBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:NumberContext):Unit =
		new NumberBytecodeGenerationRule(generationContext, ruleContext).exit()
}