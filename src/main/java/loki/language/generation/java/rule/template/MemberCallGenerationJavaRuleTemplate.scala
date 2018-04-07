package loki.language.generation.java.rule.template

import loki.language.generation.constant.LanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.java.rule.GenerationJavaRule
import loki.language.generation.rule.mixin.template.MemberCallGenerationRuleMixinTemplate
import loki.runtime.datatype.unit.LUnit
import org.antlr.v4.runtime.RuleContext

abstract class MemberCallGenerationJavaRuleTemplate[RULE_CONTEXT <: RuleContext](
	generationContext:JavaGenerationContext, ruleContext:RULE_CONTEXT
)
	extends GenerationJavaRule(generationContext, ruleContext) with MemberCallGenerationRuleMixinTemplate
{
	override protected def enterAction():Unit =
		generationContext
			.addPostExitRuleTask(
				memberExpressionContext,
				() =>
				{
					addCode(s""".$UNIT__METHOD__CALL_MEMBER("$memberName", new ${classOf[LUnit].getName}[]{""")
					parameterExpressionContexts.foreach(generationContext.addPostExitRuleTask(_, () => addCode(", ")))
				}
			)

	override protected def exitAction()
	{
		removeLastNewLineIfPresent()
		addCode(s"}, $UNIT__METHOD__CALL__PARAMETER__CONTEXT)")
	}
}