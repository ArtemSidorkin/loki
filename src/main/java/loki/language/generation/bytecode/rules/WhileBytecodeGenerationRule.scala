package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.GenerationRuleMixinWhile
import loki.language.parsing.LokiParser.WhileContext
import org.objectweb.asm.tree.LabelNode

class WhileBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:WhileContext)
	extends BytecodeGenerationRule(generationContext, ruleContext) with GenerationRuleMixinWhile
{
	override protected def enterAction()
	{
		val lblNdWhlBgn = new LabelNode
		val lblNdWhlEnd = new LabelNode

		generationContext.addPreEnterRuleTask(logicalExpression, () =>
		{
			(
				topMethodCall
				label lblNdWhlBgn
			)
		})

		generationContext.addPostExitRuleTask(logicalExpression, () => {
			(
				topMethodCall
				invokeVirtualUnitMethodToBoolean()
				decrementObjectCounter ()
				ifeq (lblNdWhlEnd)
			)
		})

		generationContext.addPostExitRuleTask(lastInstruction, () =>
		{
			(
				topMethodCall
				goto lblNdWhlBgn
				label lblNdWhlEnd
				void ()
				incrementObjectCounter ()
			)
		})

	}
}

object WhileBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:WhileContext):Unit =
		new WhileBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:WhileContext):Unit =
		new WhileBytecodeGenerationRule(generationContext, ruleContext).exit()
}