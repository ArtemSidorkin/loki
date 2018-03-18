package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecode.template.ObjectBytecodeTemplate.TemplateObject
import loki.language.generation.rule.mixin.ObjectGenerationRuleMixin
import loki.language.parsing.LokiParser.ObjectContext

class ObjectBytecodeGenerationRule(bytecodeGenerationContext:BytecodeGenerationContext, objectContext:ObjectContext)
	extends BytecodeGenerationRule(bytecodeGenerationContext, objectContext) with ObjectGenerationRuleMixin
{
	override protected def enterAction()
	{
		generateObject()
		generateObjectMembers()

		def generateObject()
		{
			(
				topMethodCall
					newObject ()
					dup ()
					incrementObjectCounter ()
			)

			if (memberNameValueCount != 0) (
				topMethodCall
					ldc memberNameValueCount
					anewarrayUnit ()
			)
			else topMethodCall aconstnull ()
		}

		def generateObjectMembers():Unit =
			for (i <- 0 until memberNameValueCount)
			{
				bytecodeGenerationContext
					.addPreEnterRuleTask(
						getMemberNameValueExpression(i),
						() =>
							topMethodCall
								dup ()
								ldc i
					)

				bytecodeGenerationContext
					.addPostExitRuleTask(getMemberNameValueExpression(i), () => topMethodCall aastore ())
			}
	}

	override protected def exitAction():Unit = (
		topMethodCall
			invokeInitObject ()
			decreaseObjectCounter memberNameValueCount
	)
}