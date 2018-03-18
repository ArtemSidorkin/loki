package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.template.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecode.template.StringBytecodeTemplate.CTemplateNumber
import loki.language.generation.rule.mixin.StringGenerationRuleMixin
import loki.language.parsing.LokiParser

class StringBytecodeGenerationRule(
	bytecodeGenerationContext:BytecodeGenerationContext, stringContext:LokiParser.StringContext
) extends BytecodeGenerationRule(bytecodeGenerationContext, stringContext) with StringGenerationRuleMixin
{
	override protected def enterAction()
	{
		val preparedString =
			if (isAcuteString) string else string split "\n" map (string => s"""${string.init}""") mkString "\n"

		(
			topMethodCall
			newString ()
			dup ()
			ldc preparedString
			invokeInitString ()
			incrementObjectCounter ()
		)
	}

}