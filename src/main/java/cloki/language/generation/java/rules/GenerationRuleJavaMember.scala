package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.MemberGenerationRuleMixin
import cloki.language.parsing.LokiParser.MemberContext

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