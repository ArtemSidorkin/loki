package loki.language.generation.bytecode.rules

import loki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import loki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import loki.language.generation.rules.mixins.AssignHostMemberGenerationRuleMixin
import loki.language.parsing.LokiParser.AssignHostMemberContext

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