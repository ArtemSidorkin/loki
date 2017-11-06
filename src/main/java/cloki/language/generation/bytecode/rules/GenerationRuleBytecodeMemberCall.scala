package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationMemberCall
import cloki.language.parsing.LokiParser.MemberCallContext

class GenerationRuleBytecodeMemberCall(generationContext:CGenerationContextBytecode, ruleContext:MemberCallContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationMemberCall
{
	override def __enter()
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

	override def __exit() =
	(
		topMethodCall
		aloadUnitMethodCallVariableUnitContext ()
		invokeVirtualUnitMethodCallMember ()
	)
}

object GenerationRuleBytecodeMemberCall
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:MemberCallContext):Unit =
		new GenerationRuleBytecodeMemberCall(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:MemberCallContext):Unit =
		new GenerationRuleBytecodeMemberCall(generationContext, ruleContext).exit()
}