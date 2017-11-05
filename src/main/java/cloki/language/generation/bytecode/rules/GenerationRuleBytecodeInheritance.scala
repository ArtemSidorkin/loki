package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationInheritance
import cloki.language.parsing.LokiParser.InheritanceContext

class GenerationRuleBytecodeInheritance
(
	generationContext:CGenerationContextBytecode, ruleContext:InheritanceContext
) extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationInheritance
{
	override def __enter() =
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
