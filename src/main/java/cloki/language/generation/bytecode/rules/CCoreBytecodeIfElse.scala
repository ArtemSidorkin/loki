package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationIfElse
import cloki.language.parsing.LokiParser.IfElseContext
import org.objectweb.asm.tree.LabelNode

class CCoreBytecodeIfElse(generationContext:CGenerationContextBytecode, ruleContext:IfElseContext)
	extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationIfElse
{
	override def enter()
	{
		val ifLblNd = new LabelNode
		val elsLblNd = new LabelNode

		generationContext.addPostExitRuleTask(logicalExpression, () =>
		{
			(
				topMethodCall
//					incrementObjectCounter ()
				invokeVirtualUnitMethodToBoolean ()
				ifeq (elsLblNd)
//					pushFrame ()
			)
		})

		generationContext.addPostExitRuleTask(lastIfExpression, () =>
		{
			(
				topMethodCall
				goto ifLblNd
			)

			if (!isElsePresent)
			(
				topMethodCall
				goto ifLblNd
				label elsLblNd
				void ()
				label ifLblNd
			)
		})

		generationContext.addPreExitRuleTask(lastIfInstruction, () => topMethodCall.decrementObjectCounter())

		if (isElsePresent)
		{
			generationContext.addPreEnterRuleTask(firstElseExpression, () =>
			(
				topMethodCall
				label elsLblNd
			))

			generationContext.addPostExitRuleTask(lastElseExpression, () =>
			(
				topMethodCall
				label ifLblNd
			))

			generationContext.addPreExitRuleTask(lastElseInstruction, () => topMethodCall.decrementObjectCounter())
		}
	}
}
