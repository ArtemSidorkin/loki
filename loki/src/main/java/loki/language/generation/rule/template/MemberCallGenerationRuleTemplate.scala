package loki.language.generation.rule.template

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.generation.rule.GenerationRule
import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import org.antlr.v4.runtime.RuleContext

private[generation] abstract class MemberCallGenerationRuleTemplate
	[RULE_CONTEXT <: RuleContext](ruleContext:RULE_CONTEXT)(implicit generationContext:GenerationContext)
	extends GenerationRule(ruleContext) with MemberCallGenerationRuleMixinTemplate
{
	override protected def enterAction()
	{
		loadMemberNameAndCreateCallParameterArrayAfterExitHostExpressionContext()
		storeCallParameters()

		def loadMemberNameAndCreateCallParameterArrayAfterExitHostExpressionContext():Unit =
			generationContext
				.addPostExitRuleTask(
					hostExpressionContext,
					() =>
					{
						topMethodCall ldc memberName
						if (callParameterExpressionContexts.nonEmpty)
							topMethodCall anewarrayUnit callParameterExpressionContexts.size
						else topMethodCall.emptyUnitArray()
					}
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
						() =>
							topMethodCall
								.dup()
								.ldc(callParameterIndex)
					)

			def storeCallParameterAfterExitCallParameterExpressionContext(callParameterIndex:Int):Unit =
				generationContext
					.addPostExitRuleTask(
						callParameterExpressionContexts(callParameterIndex),
						() =>
							topMethodCall
								.aastore()
								.decrementObjectCounter()
					)
		}
	}

	override protected def exitAction():Unit = topMethodCall.invokeVirtualUnitMethodCallMember()
}