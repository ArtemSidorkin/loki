package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeArray.CTemplateArray
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.rules.mixins.CMixinRuleGenerationArray
import cloki.language.parsing.LokiParser.ArrayContext

private[bytecode] object CRuleGenerationBytecodeArray extends CRuleGenerationBytecode[ArrayContext]
{
	protected class CCoreBytecodeArray(generationContext:CGenerationContextBytecode, ruleContext:ArrayContext)
		extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationArray
	{
		override def enter()
		{
			generateArray()
			generateArrayItems()

			def generateArray()
			{
				(
					topMethodCall
					newArray ()
					dup ()
					incrementObjectCounter ()
				)

				if (arrayItemCount != 0) (
					topMethodCall
					ldc arrayItemCount
					anewarrayUnit ()
				) else topMethodCall aconstnull ()
			}

			def generateArrayItems():Unit = for (i <- 0 until arrayItemCount)
			{
				generationContext.addPreEnterRuleTask(getArrayItemExpression(i), () =>
					topMethodCall
					dup ()
					ldc i
					decrementObjectCounter ()
				)
				generationContext.addPostExitRuleTask(getArrayItemExpression(i), () => topMethodCall aastore ())
			}
		}

		override def exit() = topMethodCall invokeInitArray ()
	}

	override protected def getCore(generationContext:CGenerationContextBytecode, ruleContext:ArrayContext) =
		new CCoreBytecodeArray(generationContext, ruleContext)
}
