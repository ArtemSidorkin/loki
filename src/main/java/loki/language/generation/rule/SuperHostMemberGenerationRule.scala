package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.CTemplateUnit
import loki.language.parsing.LokiParser.SuperHostMemberContext

private[generation] class SuperHostMemberGenerationRule(
	generationContext:GenerationContext, superHostMemberContext:SuperHostMemberContext
)
	extends GenerationRule(generationContext, superHostMemberContext)
{
	private val superMemberName:String = superHostMemberContext.IDENTIFIER.getText

	override protected def enterAction():Unit = (
		topMethodCall
			aloadUnitMethodCallParameterHost ()
			ldc superMemberName
			invokeVirtualUnitMethodGetSuperMember ()
			incrementObjectCounter ()
	)
}

private[generation] object SuperHostMemberGenerationRule
{
	def enter(generationContext:GenerationContext, superHostMemberContext:SuperHostMemberContext):Unit =
		new SuperHostMemberGenerationRule(generationContext, superHostMemberContext).enter()

	def exit(generationContext:GenerationContext, superHostMemberContext:SuperHostMemberContext):Unit =
		new SuperHostMemberGenerationRule(generationContext, superHostMemberContext).exit()
}