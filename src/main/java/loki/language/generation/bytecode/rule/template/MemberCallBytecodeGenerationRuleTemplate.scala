package loki.language.generation.bytecode.rule.template

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.rule.BytecodeGenerationRule
import loki.language.generation.bytecode.template.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import org.antlr.v4.runtime.RuleContext

abstract class MemberCallBytecodeGenerationRuleTemplate[RULE_CONTEXT <: RuleContext](
	bytecodeGenerationContext:BytecodeGenerationContext, ruleContext:RULE_CONTEXT
)
	extends BytecodeGenerationRule(bytecodeGenerationContext, ruleContext) with MemberCallGenerationRuleMixinTemplate
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