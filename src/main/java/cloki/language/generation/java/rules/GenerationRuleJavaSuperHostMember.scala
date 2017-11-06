package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationSuperHostMember
import cloki.language.parsing.LokiParser.SuperHostMemberContext

class GenerationRuleJavaSuperHostMember
(
	generationContext:CGenerationContextJava, ruleContext:SuperHostMemberContext
) extends GenerationRuleJava(generationContext, ruleContext) with CMixinRuleGenerationSuperHostMember
{
	override protected def enterAction() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"""$UNIT__METHOD__CALL__PARAMETER__HOST.$UNIT__METHOD__GET_SUPER_MEMBER("$superMemberName")"""
	)
}

object GenerationRuleJavaSuperHostMember
{
	def enter(generationContext:CGenerationContextJava, ruleContext:SuperHostMemberContext):Unit =
		new GenerationRuleJavaSuperHostMember(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:SuperHostMemberContext):Unit =
		new GenerationRuleJavaSuperHostMember(generationContext, ruleContext).exit()
}