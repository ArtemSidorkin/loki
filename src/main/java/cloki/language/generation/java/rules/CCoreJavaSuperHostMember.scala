package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationSuperHostMember
import cloki.language.parsing.LokiParser.SuperHostMemberContext

class CCoreJavaSuperHostMember
(
	generationContext:CGenerationContextJava, ruleContext:SuperHostMemberContext
) extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationSuperHostMember
{
	override def enter() = (addCode _ compose tabulateIfLastCharacterIsNewLine) (
		s"""$UNIT__METHOD__CALL__PARAMETER__HOST.$UNIT__METHOD__GET_SUPER_MEMBER("$superMemberName")"""
	)
}