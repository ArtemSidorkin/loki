package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.AssignHostMemberGenerationRuleMixin
import cloki.language.parsing.LokiParser.AssignHostMemberContext

class GenerationRuleBytecodeAssignHostMember
(
	generationContext:CGenerationContextBytecode, ruleContext:AssignHostMemberContext
) extends GenerationRuleBytecode(generationContext, ruleContext) with AssignHostMemberGenerationRuleMixin
{
	override protected def enterAction() =
	(
		topMethodCall aloadUnitMethodCallParameterHost ()
		ldc hostMemberName
	)

	override protected def exitAction() = topMethodCall invokeVirtualUnitMethodSetMember ()
}


object GenerationRuleBytecodeAssignHostMember
{
	def enter(generationContext:CGenerationContextBytecode, ruleContext:AssignHostMemberContext):Unit =
		new GenerationRuleBytecodeAssignHostMember(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextBytecode, ruleContext:AssignHostMemberContext):Unit =
		new GenerationRuleBytecodeAssignHostMember(generationContext, ruleContext).exit()
}