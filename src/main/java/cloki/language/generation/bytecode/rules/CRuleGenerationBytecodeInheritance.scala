package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationInheritance
import cloki.language.parsing.CLokiParser.InheritanceContext

private[bytecode] object CRuleGenerationBytecodeInheritance extends CRuleGenerationBytecode[InheritanceContext]
{
	protected class CCoreBytecodeInheritance
	(
		generationContext:CGenerationContextBytecode, ruleContext:InheritanceContext
	) extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationInheritance
	{
		override def enter() =
		{
			for (i <- 0 until parentCount) generationContext.addPostExitRuleTask(getParentExpression(i), () => (
				topMethodCall
				invokeVirtualUnitMethodAddParent ()
				decrementObjectCounter ()
			))

			generationContext.deferRule(ruleContext)
		}
	}

	override def getCore(generationContext:CGenerationContextBytecode, ruleContext:InheritanceContext) =
		new CCoreBytecodeInheritance(generationContext, ruleContext)
}
