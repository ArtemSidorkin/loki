package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationMemberCall
import cloki.language.parsing.LokiParser.MemberCallContext

private[bytecode] object CRuleGenerationBytecodeMemberCall extends CRuleGenerationBytecode[MemberCallContext]
{
	protected class CCoreBytecodeMemberCall(generationContext:CGenerationContextBytecode, ruleContext:MemberCallContext)
		extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationMemberCall
	{
		override def enter()
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

		override def exit() =
		(
			topMethodCall
			aloadUnitMethodCallVariableUnitContext ()
			invokeVirtualUnitMethodCallMember ()
		)
	}

	override def getCore(generationContext:CGenerationContextBytecode, ruleContext:MemberCallContext) =
		new CCoreBytecodeMemberCall(generationContext, ruleContext)
}
