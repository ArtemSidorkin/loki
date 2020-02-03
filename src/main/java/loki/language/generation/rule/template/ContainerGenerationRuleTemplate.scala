package loki.language.generation.rule.template

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.ContainerBytecodeTemplate.ContainerBytecodeTemplate
import loki.language.generation.rule.GenerationRule
import loki.language.generation.rule.mixin.template.ContainerGenerationRuleMixinTemplate
import org.antlr.v4.runtime.RuleContext

private[generation] abstract class ContainerGenerationRuleTemplate
	[RULE_CONTEXT <: RuleContext](ruleContext:RULE_CONTEXT)(implicit generationContext:GenerationContext)
	extends GenerationRule(ruleContext) with ContainerGenerationRuleMixinTemplate
{
	override protected def enterAction()
	{
		CreateAndDuplicateContainerClass()
		CreateContainerClassConstructorParameter()
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

		object CreateContainerClassConstructorParameter
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
						DuplicateContainerItemArrayAndLoadContainerItemIndexBeforeEnterContainerItemExpressionContext(
							containerItemExpressionContextIndex
						)
						StoreContainerItemAfterExitContainerItemExpressionContext(containerItemExpressionContextIndex)
					})

				object DuplicateContainerItemArrayAndLoadContainerItemIndexBeforeEnterContainerItemExpressionContext
				{
					def apply(itemIndex:Int):Unit =
						generationContext
							.addPreEnterRuleTask(
								containerItemExpressionContexts(itemIndex),
								() => duplicateContainerItemArrayAndLoadContainerItemIndex(itemIndex)
							)

					private def duplicateContainerItemArrayAndLoadContainerItemIndex(itemIndex:Int):Unit = (
						topMethodCall
							dup ()
							ldc itemIndex
					)
				}

				object StoreContainerItemAfterExitContainerItemExpressionContext
				{
					def apply(containerItemIndex:Int):Unit =
						generationContext
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
		InvokeInitContainer()

		object InvokeInitContainer
		{
			def apply():Unit = topMethodCall invokeInitContainer containerClass
		}
	}
}
