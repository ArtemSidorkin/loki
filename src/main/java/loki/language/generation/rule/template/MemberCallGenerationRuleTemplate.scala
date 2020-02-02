package loki.language.generation.rule.template

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.GenerationRule
import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import org.antlr.v4.runtime.RuleContext

private[generation] abstract class MemberCallGenerationRuleTemplate[RULE_CONTEXT <: RuleContext](
	generationContext:GenerationContext, ruleContext:RULE_CONTEXT
)
	extends GenerationRule(generationContext, ruleContext) with MemberCallGenerationRuleMixinTemplate
{
	override protected def enterAction()
	{
		loadMemberNameAndCreateCallParameterArrayAfterExitHostExpressionContext()
		storeCallParameters()

		def loadMemberNameAndCreateCallParameterArrayAfterExitHostExpressionContext():Unit =
			generationContext
				.addPostExitRuleTask(
					hostExpressionContext,
					() => (
						topMethodCall
							ldc memberName
							anewarrayUnit callParameterExpressionContexts.size
					)
				)

		def storeCallParameters()
		{
			callParameterExpressionContexts
				.indices
				.foreach(callParameterIndex =>
				{
					duplicateCallParameterArrayAndLoadCallParameterIndexBeforeEnterCallParameterExpressionContext(
						callParameterIndex
					)

					storeCallParameterAfterExitCallParameterExpressionContext(callParameterIndex)
				})

			def duplicateCallParameterArrayAndLoadCallParameterIndexBeforeEnterCallParameterExpressionContext(
				callParameterIndex:Int
			):Unit =
				generationContext.
					addPreEnterRuleTask(
						callParameterExpressionContexts(callParameterIndex),
						() => (
							topMethodCall
								dup ()
								ldc callParameterIndex
						)
					)

			def storeCallParameterAfterExitCallParameterExpressionContext(callParameterIndex:Int):Unit =
				generationContext
					.addPostExitRuleTask(
						callParameterExpressionContexts(callParameterIndex),
						() => (
							topMethodCall
								aastore ()
								decrementObjectCounter()
						)
					)
		}
	}

	override protected def exitAction():Unit = topMethodCall invokeVirtualUnitMethodCallMember ()
}