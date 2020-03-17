package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.SuperHostMemberContext

private[generation] class SuperHostMemberGenerationRule
	(superHostMemberContext:SuperHostMemberContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(superHostMemberContext)
{
	private def superMemberName:String = superHostMemberContext.IDENTIFIER.getText

	override protected def enterAction():Unit = (
		topMethodCall
			.aloadUnitMethodCallParameterHost()
			.ldc(superMemberName)
			.invokeVirtualUnitMethodGetSuperMember()
			.incrementObjectCounter()
	)
}

private[generation] object SuperHostMemberGenerationRule
{
	def enter(superHostMemberContext:SuperHostMemberContext)(implicit generationContext:GenerationContext):Unit =
		new SuperHostMemberGenerationRule(superHostMemberContext).enter()

	def exit(superHostMemberContext:SuperHostMemberContext)(implicit generationContext:GenerationContext):Unit =
		new SuperHostMemberGenerationRule(superHostMemberContext).exit()
}