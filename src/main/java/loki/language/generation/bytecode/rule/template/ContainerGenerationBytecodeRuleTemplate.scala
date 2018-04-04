package loki.language.generation.bytecode.rule.template

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.constant.BytecodeContainerMethodDescriptors
import loki.language.generation.bytecode.rule.BytecodeGenerationRule
import loki.language.generation.bytecode.template.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.rule.mixin.template.ContainerGenerationRuleMixinTemplate
import org.antlr.v4.runtime.RuleContext

abstract class ContainerGenerationBytecodeRuleTemplate[RULE_CONTEXT <: RuleContext](
	bytecodeGenerationContext:BytecodeGenerationContext, ruleContext:RULE_CONTEXT
)
	extends BytecodeGenerationRule(bytecodeGenerationContext, ruleContext) with ContainerGenerationRuleMixinTemplate
{
	override protected def enterAction()
	{
		generateContainer()
		generateContainerItems()

		def generateContainer()
		{
			(
				topMethodCall
					`new` containerClass
					dup ()
					incrementObjectCounter ()
			)

			if (containerItemCount != 0) (
				topMethodCall
					ldc containerItemCount
					anewarrayUnit ()
			)
			else topMethodCall aconstnull ()
		}

		def generateContainerItems():Unit =
			for (i <- 0 until containerItemCount)
			{
				bytecodeGenerationContext.addPreEnterRuleTask(
					containerItemExpressionContexts(i),
					() =>
						topMethodCall
							dup ()
							ldc i
							decrementObjectCounter ()
				)

				bytecodeGenerationContext
					.addPostExitRuleTask(containerItemExpressionContexts(i), () => topMethodCall aastore ())
			}
	}

	override protected def exitAction():Unit =
		topMethodCall invokeinit (containerClass, BytecodeContainerMethodDescriptors.INIT)
}
