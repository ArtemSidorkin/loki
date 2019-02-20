package loki.language.generation.rule.template

import loki.language.generation.GenerationContext
import loki.language.generation.rule.GenerationRule
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import org.antlr.v4.runtime.RuleContext

private[generation] abstract class MemberCallGenerationRuleTemplate[RULE_CONTEXT <: RuleContext](
	generationContext:GenerationContext, ruleContext:RULE_CONTEXT
)
	extends GenerationRule(generationContext, ruleContext) with MemberCallGenerationRuleMixinTemplate
{
	override protected def enterAction()
	{
		LoadMemberNameAndCreateCallParameterArrayAfterExitHostExpressionContext()
		StoreCallParameters()

		object LoadMemberNameAndCreateCallParameterArrayAfterExitHostExpressionContext
		{
			def apply():Unit =
				generationContext.addPostExitRuleTask(hostExpressionContext, loadMemberNameAndCreateCallParameterArray)

			private def loadMemberNameAndCreateCallParameterArray():Unit = (
				topMethodCall
					ldc memberName
					anewarrayUnit callParameterExpressionContexts.size
			)
		}

		object StoreCallParameters
		{
			def apply()
			{
				callParameterExpressionContexts
					.indices
					.foreach(callParameterIndex =>
					{
						DuplicateCallParameterArrayAndLoadCallParameterIndexBeforeEnterCallParameterExpressionContext(
							callParameterIndex
						)
						StoreCallParameterAfterExitCallParameterExpressionContext(callParameterIndex)
					})

				object DuplicateCallParameterArrayAndLoadCallParameterIndexBeforeEnterCallParameterExpressionContext
				{
					def apply(callParameterIndex:Int):Unit =
						generationContext.
							addPreEnterRuleTask(
								callParameterExpressionContexts(callParameterIndex),
								() => duplicateCallParameterArrayAndLoadCallParameterIndex(callParameterIndex)
							)

					private def duplicateCallParameterArrayAndLoadCallParameterIndex(callParameterIndex:Int):Unit = (
						topMethodCall
							dup ()
							ldc callParameterIndex
					)
				}

				object StoreCallParameterAfterExitCallParameterExpressionContext
				{
					def apply(callParameterIndex:Int):Unit =
						generationContext
							.addPostExitRuleTask(
								callParameterExpressionContexts(callParameterIndex), storeCallParameter
							)

					private def storeCallParameter():Unit = (
						topMethodCall
							aastore ()
							decrementObjectCounter()
					)
				}
			}
		}
	}

	override protected def exitAction()
	{
		LoadUnitContextAndInvokeCallMember()

		object LoadUnitContextAndInvokeCallMember
		{
			def apply():Unit = (
				topMethodCall
					aloadUnitMethodCallVariableUnitContext ()
					invokeVirtualUnitMethodCallMember ()
			)
		}
	}
}