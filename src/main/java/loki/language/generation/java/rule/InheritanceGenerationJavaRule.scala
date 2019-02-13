package loki.language.generation.java.rule

import loki.language.generation.constant.LanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.InheritanceGenerationRuleMixin
import loki.language.parsing.LokiParser.InheritanceContext

class InheritanceGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:InheritanceContext)
	extends GenerationJavaRule(generationContext, ruleContext) with InheritanceGenerationRuleMixin
{
	override protected def enterAction() =
	{
		(addCode _ compose tabulateIfLastCharacterIsNewLine)(s"""$UNIT__METHOD__CALL_MEMBER("addParent", new loki.runtime.datatype.unit.LUnit[]{""")

		for (i <- 0 until parentCount - 2) generationContext.addPostExitRuleTask(
			getParentExpression(i), () => addCode(s", ")
		)

		generationContext
			.addPostExitRuleTask(
				getParentExpression(parentCount - 2),
				() =>
				{
					addComa()
					addSpace()
				}
			)
	}

	override protected def exitAction():Unit = addCode("}, unitContext);\n")
}

object InheritanceGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:InheritanceContext):Unit =
		new InheritanceGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:InheritanceContext):Unit =
		new InheritanceGenerationJavaRule(generationContext, ruleContext).exit()
}