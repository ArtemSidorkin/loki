package loki.language.generation.rule.template

import loki.language.generation.GenerationContext
import loki.language.generation.rule.GenerationRule
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import org.antlr.v4.runtime.RuleContext

abstract class MemberCallGenerationRuleTemplate[RULE_CONTEXT <: RuleContext](
																						bytecodeGenerationContext:GenerationContext, ruleContext:RULE_CONTEXT
)
	extends GenerationRule(bytecodeGenerationContext, ruleContext) with MemberCallGenerationRuleMixinTemplate
{
	override protected def enterAction()
	{
		generateCallHostAndCallParameterArray()
		generateCallParameters()

		def generateCallHostAndCallParameterArray():Unit =
			bytecodeGenerationContext.addPostExitRuleTask(memberExpressionContext, () =>
			(
				topMethodCall
				ldc memberName
				ldc parameterExpressionContexts.size
				anewarrayUnit()
			))

		def generateCallParameters():Unit = for (i <- parameterExpressionContexts.indices)
		{
			bytecodeGenerationContext.
				addPreEnterRuleTask(
					parameterExpressionContexts(i),
					() =>
						topMethodCall
						dup ()
						ldc i
						decrementObjectCounter ()
				)

			bytecodeGenerationContext
				.addPostExitRuleTask(parameterExpressionContexts(i), () => topMethodCall aastore ())
		}
	}

	override protected def exitAction():Unit =
	(
		topMethodCall
		aloadUnitMethodCallVariableUnitContext ()
		invokeVirtualUnitMethodCallMember ()
	)
}