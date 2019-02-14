package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.SuperHostMemberContext

class SuperHostMemberGenerationRule
(
	generationContext:GenerationContext, ruleContext:SuperHostMemberContext
) extends GenerationRule(generationContext, ruleContext)
{
	private val superMemberName:String = ruleContext.IDENTIFIER.getText

	override protected def enterAction() =
	(
		topMethodCall
		aloadUnitMethodCallParameterHost ()
		ldc superMemberName
		invokeVirtualUnitMethodGetSuperMember ()
		incrementObjectCounter ()
	)
}

object SuperHostMemberGenerationRule
{
	def enter(generationContext:GenerationContext, ruleContext:SuperHostMemberContext):Unit =
		new SuperHostMemberGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:GenerationContext, ruleContext:SuperHostMemberContext):Unit =
		new SuperHostMemberGenerationRule(generationContext, ruleContext).exit()
}