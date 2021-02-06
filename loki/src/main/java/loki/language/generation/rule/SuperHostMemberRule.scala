package loki.language.generation.rule

import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.parsing.LokiParser.SuperHostMemberContext

private[generation] class SuperHostMemberRule(
	superHostMemberContext:SuperHostMemberContext
)(
	implicit generationContext:GenerationContext
)
	extends GenerationRule(superHostMemberContext)
{
	private val superMemberName:String = superHostMemberContext.IDENTIFIER.getText

	override protected def enterAction():Unit =
		topMethodCall
			.aloadHostParameterOfUnitCallMethod()
			.ldc(superMemberName)
			.invokeVirtualUnitGetSuperMemberMethod()
			.incrementObjectStackCounter()
}