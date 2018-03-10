package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import loki.language.generation.bytecode.templates.CTemplateBytecodeMap.CTemplateMap
import loki.language.generation.rules.mixins.MapGenerationRuleMixin
import loki.language.parsing.LokiParser.MapContext

class MapBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:MapContext)
	extends BytecodeGenerationRule(generationContext, ruleContext) with MapGenerationRuleMixin
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


object MapBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:MapContext):Unit =
		new MapBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:MapContext):Unit =
		new MapBytecodeGenerationRule(generationContext, ruleContext).exit()
}