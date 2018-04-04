package loki.language.generation.bytecode.rule.template

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.constant.BytecodeContainerMethodDescriptors
import loki.language.generation.bytecode.rule.BytecodeGenerationRule
import loki.language.generation.bytecode.template.CommonBytecodeTemplate.CTemplateCommon
import loki.language.parsing.LokiParser.ExpressionContext
import loki.runtime.datatype.LUnit
import org.antlr.v4.runtime.RuleContext

class ContainerGenerationBytecodeRuleTemplate(
	bytecodeGenerationContext:BytecodeGenerationContext, ruleContext:RuleContext
)
	extends BytecodeGenerationRule(bytecodeGenerationContext, ruleContext)
{
	def enter(
		containerClass:Class[_ <: LUnit], containerItemCount:Int, containerItemExpressionContexts:Seq[ExpressionContext]
	 )
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

	def exit(containerClass:Class[_ <: LUnit]):Unit =
		topMethodCall invokeinit (containerClass, BytecodeContainerMethodDescriptors.INIT)
}
