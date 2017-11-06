package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationHostMember
import cloki.language.parsing.LokiParser.HostMemberContext

class GenerationRuleJavaHostMember(generationContext:CGenerationContextJava, ruleContext:HostMemberContext)
	extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationHostMember
{
	override def __enter() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"""$UNIT__METHOD__CALL__PARAMETER__HOST.$UNIT__METHOD__GET_MEMBER("$hostMemberName")"""
	)
}

object GenerationRuleJavaHostMember
{
	def enter(generationContext:CGenerationContextJava, ruleContext:HostMemberContext):Unit =
		new GenerationRuleJavaHostMember(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:HostMemberContext):Unit =
		new GenerationRuleJavaHostMember(generationContext, ruleContext).exit()
}