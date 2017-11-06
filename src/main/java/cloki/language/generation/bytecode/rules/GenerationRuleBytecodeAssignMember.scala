package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignMember
import cloki.language.parsing.LokiParser.AssignMemberContext

class GenerationRuleBytecodeAssignMember
(
	generationContext:CGenerationContextBytecode, ruleContext:AssignMemberContext
) extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationAssignMember
{
	override def __enter() =
		generationContext.addPostExitRuleTask(expressionToAssign, () => topMethodCall ldc memberName)

	override def __exit() =
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