package cloki.language.generation.java.rules

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationMember
import cloki.language.parsing.LokiParser.MemberContext

class CCoreJavaMember(generationContext:CGenerationContextJava, ruleContext:MemberContext)
	extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationMember
{
	override def enter() = generationContext.addPostExitRuleTask(
		ruleContext.expression, () => addCode(s""".$UNIT__METHOD__GET_MEMBER("$memberName")""")
	)
}
