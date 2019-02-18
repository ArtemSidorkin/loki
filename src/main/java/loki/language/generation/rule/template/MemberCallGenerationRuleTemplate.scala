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
		LoadMemberNameAndCreateCallParameterArrayAfterExitHostExpression()
		StoreCallParameters()

		object LoadMemberNameAndCreateCallParameterArrayAfterExitHostExpression
		{
			def apply():Unit =
				bytecodeGenerationContext
					.addPostExitRuleTask(hostExpressionContext, loadMemberNameAndCreateCallParameterArray)

			private def loadMemberNameAndCreateCallParameterArray():Unit = (
				topMethodCall
					ldc memberName
					ldc callParameterExpressionContexts.size
					anewarrayUnit()
			)
		}

		object StoreCallParameters
		{
			def apply():Unit =
			{
				callParameterExpressionContexts
					.indices
					.foreach(callParameterIndex =>
					{
						DuplicateParameterArrayAndLoadCallParameterIndexBeforeEnterCallParameterExpression(
							callParameterIndex
						)
						StoreCallParameterAfterExitCallParameterExpression(callParameterIndex)
					})

				object DuplicateParameterArrayAndLoadCallParameterIndexBeforeEnterCallParameterExpression
				{
					def apply(callParameterIndex:Int):Unit =
						bytecodeGenerationContext.
							addPreEnterRuleTask(
								callParameterExpressionContexts(callParameterIndex),
								() => duplicateParameterArrayAndLoadCallParameterIndex(callParameterIndex)
							)

					private def duplicateParameterArrayAndLoadCallParameterIndex(callParameterIndex:Int):Unit = (
						topMethodCall
							dup ()
							ldc callParameterIndex
					)
				}

				object StoreCallParameterAfterExitCallParameterExpression
				{
					def apply(callParameterIndex:Int):Unit =
						bytecodeGenerationContext
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

	override protected def exitAction():Unit =
	{
		LoadContextAndInvokeCallMember()

		object LoadContextAndInvokeCallMember
		{
			def apply():Unit = (
				topMethodCall
					aloadUnitMethodCallVariableUnitContext ()
					invokeVirtualUnitMethodCallMember ()
			)
		}
	}
}