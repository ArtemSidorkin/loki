package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationWhile
import cloki.language.parsing.LokiParser.WhileContext
import org.objectweb.asm.tree.LabelNode

class GenerationRuleBytecodeWhile(generationContext:CGenerationContextBytecode, ruleContext:WhileContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationWhile
{
	override def __enter()
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
