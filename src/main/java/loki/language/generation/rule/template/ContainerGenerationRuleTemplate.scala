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
		CreateAndDuplicateContainerClass()
		CreateContainerClassParameterArray()
		StoreContainerItems()

		object CreateAndDuplicateContainerClass
		{
			def apply():Unit = (
				topMethodCall
					`new` containerClass
					dup ()
					incrementObjectCounter ()
			)
		}

		object CreateContainerClassParameterArray
		{
			def apply():Unit =
				if (containerItemExpressionContexts.nonEmpty)
					topMethodCall anewarrayUnit containerItemExpressionContexts.size
				else topMethodCall aconstnull ()
		}

		object StoreContainerItems
		{
			def apply():Unit =
			{
				containerItemExpressionContexts
					.indices
					.foreach(containerItemExpressionContextIndex =>
					{
						DuplicateItemArrayAndLoadItemIndexBeforeEnterItemExpression(containerItemExpressionContextIndex)
						StoreContainerItemAfterExist(containerItemExpressionContextIndex)
					})

				object DuplicateItemArrayAndLoadItemIndexBeforeEnterItemExpression
				{
					def apply(itemIndex:Int):Unit =
						bytecodeGenerationContext
							.addPreEnterRuleTask(
								containerItemExpressionContexts(itemIndex),
								() => duplicateItemArrayAndLoadItemIndex(itemIndex)
							)

					private def duplicateItemArrayAndLoadItemIndex(itemIndex:Int):Unit = (
						topMethodCall
							dup ()
							ldc itemIndex
					)
				}

				object StoreContainerItemAfterExist
				{
					def apply(containerItemIndex:Int):Unit =
						bytecodeGenerationContext
							.addPostExitRuleTask(
								containerItemExpressionContexts(containerItemIndex), storeContainerItem
							)

					private def storeContainerItem():Unit = (
						topMethodCall
							aastore ()
							decrementObjectCounter ()
					)
				}
			}
		}
	}

	override protected def exitAction()
	{
		InvokeContainerInit()

		object InvokeContainerInit
		{
			def apply():Unit = topMethodCall invokeInitContainer containerClass
		}
	}
}
