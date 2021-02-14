package loki.language.generation.rule.template

import assembler.builder.MethodBuilder
import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.ContainerBytecodeTemplate.ContainerBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.generation.rule.GenerationRule
import loki.language.generation.rule.mixin.template.ContainerGenerationRuleMixinTemplate
import org.antlr.v4.runtime.RuleContext

private[generation] abstract class ContainerGenerationRuleTemplate
	[RULE_CONTEXT <: RuleContext](ruleContext:RULE_CONTEXT)(implicit generationContext:GenerationContext)
	extends GenerationRule(ruleContext) with ContainerGenerationRuleMixinTemplate
{
	override protected def enterAction():Unit =
		topMethodCall
			.createContainerInstance()
			.createContainerItems()

	override protected def exitAction():Unit = topMethodCall.initContainer()

	private implicit class ContainerBuilder(val methodBuilder:MethodBuilder)
	{
		def createContainerInstance():methodBuilder.type =
		{
			methodBuilder
				.`new`(containerClass)
				.dup()

			methodBuilder
		}

		def createContainerItems():methodBuilder.type =
		{
			methodBuilder.createContainerParameterArray()

			containerItemExpressionContexts
				.indices
				.foreach(containerItemExpressionContextIndex =>
					topMethodCall
						.loadContainerItemIndex(containerItemExpressionContextIndex)
						.storeContainerItem(containerItemExpressionContextIndex)
				)

			methodBuilder
		}

		def createContainerParameterArray():methodBuilder.type =
		{
			if (containerItemExpressionContexts.nonEmpty)
				methodBuilder.anewarrayUnit(containerItemExpressionContexts.size)
			else methodBuilder.emptyUnitArray()

			methodBuilder
		}

		def loadContainerItemIndex(itemIndex:Int):methodBuilder.type =
		{
			generationContext
				.addPreEnterRuleTask(
					containerItemExpressionContexts(itemIndex),
					() =>
						methodBuilder
							.dup()
							.ldc(itemIndex)
				)

			methodBuilder
		}

		def storeContainerItem(containerItemIndex:Int):methodBuilder.type =
		{
			generationContext
				.addPostExitRuleTask(containerItemExpressionContexts(containerItemIndex), () => methodBuilder.aastore())

			methodBuilder
		}

		def initContainer():methodBuilder.type =
		{
			topMethodCall.invokeInitContainer(containerClass)

			methodBuilder
		}
	}
}
