package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.InheritanceGenerationRuleMixin
import cloki.language.parsing.LokiParser.InheritanceContext

class GenerationRuleBytecodeInheritance
(
	generationContext:CGenerationContextBytecode, ruleContext:InheritanceContext
) extends GenerationRuleBytecode(generationContext, ruleContext) with InheritanceGenerationRuleMixin
{
	override protected def enterAction() =
	{
		for (i <- 0 until parentCount)
		{
			generationContext.addPreEnterRuleTask(getParentExpression(i), () => topMethodCall.aloadthis())

			generationContext.addPostExitRuleTask(
				getParentExpression(i),
				() => (
					topMethodCall
						invokeVirtualUnitMethodAddParent()
						decrementObjectCounter()
				)
			)
		}
	}
}

object GenerationRuleBytecodeInheritance
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:InheritanceContext):Unit =
		new GenerationRuleBytecodeInheritance(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:InheritanceContext):Unit =
		new GenerationRuleBytecodeInheritance(generationContext, ruleContext).exit()
}