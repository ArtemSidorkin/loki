package cloki.language.generation.rules.mixins

import cloki.language.parsing.LokiLexer
import cloki.language.parsing.LokiParser.UnitContext

private[language] trait CMixinRuleGenerationUnit extends CMixinRuleGeneration[UnitContext]
{
	protected val isInheritancePresent = ruleContext.inheritance != null

	protected val unitName = ruleContext.head.getType match
	{
		case LokiLexer.IDENTIFIER => Some(getUnitParameterIdentifier(0).getText)
		case LokiLexer.BACKSLASH => None
	}

	protected val unitParameterNames:Seq[String] =
		for (i <- unitName.foldLeft(0)((_, _) => 1) until ruleContext.IDENTIFIER.size)
			yield getUnitParameterIdentifier(i).getText

	protected val unitLastInstruction = ruleContext instruction ruleContext.instruction.size - 1

	protected def isUnitModuleMember = generationContext.frameStack.size <= 2 && ruleContext.DOLLAR != null
	protected def isUnitUnitMember = generationContext.frameStack.size > 2 && ruleContext.DOLLAR != null

	protected def getUnitParameterIdentifier(parameterIndex:Int) = ruleContext IDENTIFIER parameterIndex
	protected def handleInheritance() = if (isInheritancePresent) checkDeferredRules(ruleContext)

	protected def lastUnitInstruction() = ruleContext instruction ruleContext.instruction.size
}
