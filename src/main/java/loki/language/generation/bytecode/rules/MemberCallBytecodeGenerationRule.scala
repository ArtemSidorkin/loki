package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.MemberCallGenerationRuleMixin
import loki.language.parsing.LokiParser.MemberCallContext

class MemberCallBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:MemberCallContext)
	extends BytecodeGenerationRule(generationContext, ruleContext) with MemberCallGenerationRuleMixin
{
	override protected def enterAction()
	{
		generateCallHostAndCallParameterArray()
		generateCallParameters()

		def generateCallHostAndCallParameterArray():Unit =
			generationContext.addPostExitRuleTask(memberExpression, () =>
			(
				topMethodCall
				ldc memberName
				ldc callParameterCount
				anewarrayUnit ()
			))

		def generateCallParameters():Unit = for (i <- 1 to callParameterCount)
		{
			generationContext.addPreEnterRuleTask(getCallParameterExpression(i), () =>
				topMethodCall
				dup ()
				ldc i - 1
				decrementObjectCounter ()
			)
			generationContext.addPostExitRuleTask(getCallParameterExpression(i), () => topMethodCall aastore ())
		}
	}

	override protected def exitAction() =
	(
		topMethodCall
		aloadUnitMethodCallVariableUnitContext ()
		invokeVirtualUnitMethodCallMember ()
	)
}

object MemberCallBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:MemberCallContext):Unit =
		new MemberCallBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:MemberCallContext):Unit =
		new MemberCallBytecodeGenerationRule(generationContext, ruleContext).exit()
}