package loki.language.generation.rules.mixins

import loki.language.parsing.LokiLexer
import loki.language.parsing.LokiParser.{InstructionContext, UnitContext}

private[generation] trait UnitGenerationRuleMixin extends GenerationRuleMixin[UnitContext]
{
	protected val isInheritancePresent:Boolean = ruleContext.inheritance != null

	protected val unitName:Option[String] =
		ruleContext.head.getType match
		{
			case LokiLexer.IDENTIFIER => Some(getUnitParameterIdentifier(0).getText)
			case LokiLexer.BACKSLASH => None
		}

	protected val unitParameterNames:Seq[String] =
		for (i <- unitName.foldLeft(0)((_, _) => 1) until ruleContext.IDENTIFIER.size)
			yield getUnitParameterIdentifier(i).getText

	protected val unitLastInstruction:InstructionContext = ruleContext instruction ruleContext.instruction.size - 1

	protected def isUnitModuleMember:Boolean = generationContext.frameStack.size <= 2 && ruleContext.DOLLAR != null
	protected def isUnitUnitMember:Boolean = generationContext.frameStack.size > 2 && ruleContext.DOLLAR != null

	private def getUnitParameterIdentifier(parameterIndex:Int) = ruleContext IDENTIFIER parameterIndex
}
