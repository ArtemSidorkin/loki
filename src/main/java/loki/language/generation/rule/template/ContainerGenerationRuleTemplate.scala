package loki.language.generation.rule.template

import loki.language.generation.GenerationContext
import loki.language.generation.rule.GenerationRule
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.ContainerBytecodeTemplate.Template
import loki.language.generation.rule.mixin.template.ContainerGenerationRuleMixinTemplate
import org.antlr.v4.runtime.RuleContext

abstract class ContainerGenerationRuleTemplate[RULE_CONTEXT <: RuleContext](
																					   bytecodeGenerationContext:GenerationContext, ruleContext:RULE_CONTEXT
)
	extends GenerationRule(bytecodeGenerationContext, ruleContext) with ContainerGenerationRuleMixinTemplate
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

	override protected def exitAction():Unit = topMethodCall invokeInitContainer containerClass
}
