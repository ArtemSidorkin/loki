package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationInheritance
import cloki.language.parsing.LokiParser.InheritanceContext

class CCoreBytecodeInheritance
(
	generationContext:CGenerationContextBytecode, ruleContext:InheritanceContext
) extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationInheritance
{
	override def enter() =
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