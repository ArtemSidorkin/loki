package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.IfElseGenerationRuleMixin
import loki.language.parsing.LokiParser.IfElseContext
import org.objectweb.asm.tree.LabelNode

class GenerationRuleBytecodeIfElse(generationContext:CGenerationContextBytecode, ruleContext:IfElseContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with IfElseGenerationRuleMixin
{
	override protected def enterAction()
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

object GenerationRuleBytecodeIfElse
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:IfElseContext):Unit =
		new GenerationRuleBytecodeIfElse(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:IfElseContext):Unit =
		new GenerationRuleBytecodeIfElse(generationContext, ruleContext).exit()
}