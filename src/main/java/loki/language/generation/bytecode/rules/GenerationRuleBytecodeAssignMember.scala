package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.AssignMemberGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignMemberContext

class GenerationRuleBytecodeAssignMember
(
	generationContext:CGenerationContextBytecode, ruleContext:AssignMemberContext
) extends GenerationRuleBytecode(generationContext, ruleContext) with AssignMemberGenerationRuleMixin
{
	override protected def enterAction() =
		generationContext.addPostExitRuleTask(expressionToAssign, () => topMethodCall ldc memberName)

	override protected def exitAction() =
	(
		topMethodCall invokeVirtualUnitMethodSetMember ()
		decrementObjectCounter ()
	)
}

object GenerationRuleBytecodeAssignMember
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:AssignMemberContext):Unit =
		new GenerationRuleBytecodeAssignMember(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:AssignMemberContext):Unit =
		new GenerationRuleBytecodeAssignMember(generationContext, ruleContext).exit()
}