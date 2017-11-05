package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationAssignHostMember
import cloki.language.parsing.LokiParser.AssignHostMemberContext

class GenerationRuleBytecodeAssignHostMember
(
	generationContext:CGenerationContextBytecode, ruleContext:AssignHostMemberContext
) extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationAssignHostMember
{
	override def __enter() =
	(
		topMethodCall aloadUnitMethodCallParameterHost ()
		ldc hostMemberName
	)

	override def __exit() = topMethodCall invokeVirtualUnitMethodSetMember ()
}
