package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeMap.CTemplateMap
import cloki.language.generation.rules.mixins.MapGenerationRuleMixin
import cloki.language.parsing.LokiParser.MapContext

class GenerationRuleBytecodeMap(generationContext:CGenerationContextBytecode, ruleContext:MapContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with MapGenerationRuleMixin
{
	override protected def enterAction()
	{
		generateMap()
		generateMapItems()

		def generateMap()
		{
			(
				topMethodCall
					newMap ()
					dup ()
					incrementObjectCounter ()
			)

			if (itemCount != 0) (
				topMethodCall
					ldc itemCount
					anewarrayUnit ()
			)
			else topMethodCall aconstnull ()
		}

		def generateMapItems():Unit =
			for (i <- 0 until itemCount)
			{
				generationContext
					.addPreEnterRuleTask(
						getItemExpression(i),
						() =>
							topMethodCall
								dup ()
								ldc i
					)

				generationContext.addPostExitRuleTask(getItemExpression(i), () => topMethodCall aastore ())
			}
	}

	override protected def exitAction():Unit = (
		topMethodCall
			invokeInitMap ()
			decreaseObjectCounter itemCount
	)
}


object GenerationRuleBytecodeMap
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:MapContext):Unit =
		new GenerationRuleBytecodeMap(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:MapContext):Unit =
		new GenerationRuleBytecodeMap(generationContext, ruleContext).exit()
}