package loki.language.generation.java.rule

import loki.language.generation.constant.LanguageMembers._
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.rule.mixin.UnitGenerationRuleMixin
import loki.language.parsing.LokiParser.{InstructionContext, UnitContext}
import loki.runtime.context.LUnitContext
import loki.runtime.datatype.{LType, LUnit}
import loki.util.extension.StringExtension.StringExtension

class UnitGenerationJavaRule(generationContext:JavaGenerationContext, ruleContext:UnitContext)
	extends GenerationJavaRule(generationContext, ruleContext) with UnitGenerationRuleMixin
{
	override protected def enterAction()
	{
		pushFrame()
		addReturnToUnitMethodCall(generationContext, unitLastInstruction)

		(
			(
				addCode _ compose
				(if (isLastCharacterNewLine) tabulateLessOneLevel else tabulateLessOneLevelContinueLastCode)
			)
			(
				(if (unitName.nonEmpty)
					s"""
						$generateUnitSaving("${unitName.get}", new ${classOf[LUnit].getName}(new ${classOf[LType].getName}("${unitName.get}"), ${if (isPreTopFrameModule) UNIT__METHOD__CALL__PARAMETER__CONTEXT else UNIT__METHOD__CALL__PARAMETER__CONTEXT})
						{
							public ${classOf[LUnit].getName} $UNIT__METHOD__CALL(final ${classOf[LUnit].getName} $UNIT__METHOD__CALL__PARAMETER__HOST, final ${classOf[LUnit].getName}[] $UNIT__METHOD__CALL__PARAMETER__PARAMETERS, ${classOf[LUnitContext].getName} $UNIT__METHOD__CALL__PARAMETER__CONTEXT)
							{
								$UNIT__METHOD__CALL__PARAMETER__CONTEXT = new ${classOf[LUnitContext].getName}(this, $UNIT__METHOD__CALL__PARAMETER__HOST, this.$UNIT__FIELD__UNIT_CONTEXT, $UNIT__METHOD__CALL__PARAMETER__PARAMETERS);
					"""
				else
					s"""
						new ${classOf[LUnit].getName}(${classOf[LType].getName}.$TYPE__METHOD__CREATE_ANONYMOUS(), ${if (isPreTopFrameModule) UNIT__METHOD__CALL__PARAMETER__CONTEXT else UNIT__METHOD__CALL__PARAMETER__CONTEXT})
						{
							public ${classOf[LUnit].getName} $UNIT__METHOD__CALL(final ${classOf[LUnit].getName} $UNIT__METHOD__CALL__PARAMETER__HOST, final ${classOf[LUnit].getName}[] $UNIT__METHOD__CALL__PARAMETER__PARAMETERS, ${classOf[LUnitContext].getName} $UNIT__METHOD__CALL__PARAMETER__CONTEXT)
							{
								$UNIT__METHOD__CALL__PARAMETER__CONTEXT = new ${classOf[LUnitContext].getName}(this, $UNIT__METHOD__CALL__PARAMETER__HOST, this.$UNIT__FIELD__UNIT_CONTEXT, $UNIT__METHOD__CALL__PARAMETER__PARAMETERS);
					"""
				).withoutSideLines
			)
		)

		def generateUnitSaving =
			if (isUnitModuleMember || isUnitUnitMember) s"$UNIT__METHOD__CALL__PARAMETER__HOST.$UNIT__METHOD__SET_MEMBER"
			else s"$UNIT__METHOD__CALL__PARAMETER__CONTEXT.$UNIT_CONTEXT__METHOD__SET_VARIABLE"

		def addReturnToUnitMethodCall
		(
			generationContext:JavaGenerationContext, ruleContext:InstructionContext
		):Unit = if (ruleContext.expression != null) generationContext.addPreEnterRuleTask(
			ruleContext.expression, () => (addCode _ compose tabulateIfLastCharacterIsNewLine) ("return ")
		)
	}

	override protected def exitAction()
	{
		val parameterNamesSaving =
			if (unitParameterNames.nonEmpty)
				s".$UNIT__METHOD__SET_PARAMETER_NAMES(new String[]{${unitParameterNames map (prmtrNm => s""""$prmtrNm"""") mkString ", "}})"
			else ""

		(addCode _ compose tabulateLessOneLevelBackward) (
			(if (unitName.nonEmpty)
				s"""
						}
					}$parameterNamesSaving)
				"""
			else
				s"""
						}
					}$parameterNamesSaving
				"""
			).withoutSideLines
		)

		popFrame()
	}
}

object UnitGenerationJavaRule
{
	def enter(generationContext:JavaGenerationContext, ruleContext:UnitContext):Unit =
		new UnitGenerationJavaRule(generationContext, ruleContext).enter()

	def exit(generationContext:JavaGenerationContext, ruleContext:UnitContext):Unit =
		new UnitGenerationJavaRule(generationContext, ruleContext).exit()
}
