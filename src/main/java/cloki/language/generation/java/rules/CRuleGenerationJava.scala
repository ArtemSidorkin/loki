package cloki.language.generation.java.rules

import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.CRuleGeneration
import cloki.util.extension.StringExtensions.StringExtensions
import org.antlr.v4.runtime.RuleContext

private[java] trait CRuleGenerationJava[RULE_CONTEXT <: RuleContext] extends CRuleGeneration[RULE_CONTEXT]
{
	type GENERATION_CONTEXT = CGenerationContextJava

	protected class CCoreJava(generationContext:CGenerationContextJava, ruleContext:RULE_CONTEXT)
		extends CCore(generationContext, ruleContext)
	{
		def isLastCharacterNewLine = generationContext.code.lastOption contains '\n'

		def pushFrame() = generationContext.frameStack.push()
		def addCode(code:String) = generationContext.code ++= code

		def tabulateIfLastCharacterIsNewLine(code:String) =
			if (isLastCharacterNewLine) (code tabulate frameStackSize * 2)
			else code

		def tabulateIfLastCharacterIsNewLineLessHalfLevel(code:String) =
			if (isLastCharacterNewLine) (code tabulate frameStackSize * 2 - 1)
			else code

		def tabulateLessOneLevel(code:String) = code tabulate (frameStackSize - 1) * 2

		def tabulateLessOneLevelContinueLastCode(code:String) =
			code tabulate ((frameStackSize - 1) * 2, firstLineAsContinuation = true)

		def tabulateLessOneLevelBackward(code:String) = code tabulate ((frameStackSize - 1) * 2, forward = false)
		def removeTabulation(code:String) = code tabulate 0
		def removeTabulationBackward(code:String) = code tabulate (0, forward = false)

		def addColon():Unit = addCode(",")
		def addSemicolon():Unit = addCode(";")
		def addRightParenthesis():Unit = addCode(")")
		def addRightCurlyBrace():Unit = addCode("}")
		def addNewLine():Unit = addCode("\n")
		def addSpace():Unit = addCode(" ")

		def removeLastNewLineIfPresent():Unit = if (isLastCharacterNewLine)
			generationContext.code.deleteCharAt(generationContext.code.size - 1)
	}
}


