package loki.language.generation.java.rules

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.generation.rules.mixins.MemberGenerationRuleMixin
import loki.language.parsing.LokiParser.MemberContext

class GenerationRuleJavaMember(generationContext:CGenerationContextJava, ruleContext:MemberContext)
	extends GenerationRuleJava(generationContext, ruleContext) with MemberGenerationRuleMixin
{
	override protected def enterAction() = generationContext.addPostExitRuleTask(
		ruleContext.expression, () => addCode(s""".$UNIT__METHOD__GET_MEMBER("$memberName")""")
	)
}

object GenerationRuleJavaMember
{
	def enter(generationContext:CGenerationContextJava, ruleContext:MemberContext):Unit =
		new GenerationRuleJavaMember(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:MemberContext):Unit =
		new GenerationRuleJavaMember(generationContext, ruleContext).exit()
}