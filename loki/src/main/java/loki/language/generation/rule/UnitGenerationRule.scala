package loki.language.generation.rule

import assembler.builder.MethodBuilder
import assembler.constant.PUBLIC
import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.ContextBytecodeTemplate.ContextBytecodeTemplate
import loki.language.generation.bytecodetemplate.TypeBytecodeTemplate.TypeBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.generation.constant.BytecodeMethodDescriptors
import loki.language.parsing.LokiParser.{InstructionContext, UnitContext}
import loki.language.parsing.LokiLexer
import loki.runtime.LType
import loki.system.SystemSettings

private[generation] class UnitGenerationRule(unitContext:UnitContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(unitContext)
{
	private def isUnitModuleMember:Boolean = generationContext.frameStack.size <= 2 && unitContext.DOLLAR != null
	private def isUnitUnitMember:Boolean = generationContext.frameStack.size > 2 && unitContext.DOLLAR != null

	private def unitName:Option[String] =
		unitContext.head.getType match
		{
			case LokiLexer.IDENTIFIER => Some(getIdentifierName(0))
			case LokiLexer.BACKSLASH => None
		}

	override protected def enterAction():Unit =
	{
		pushUnitFrame()

		generateUnitMethodInit()
		generateUnit()
		generateUnitCallMethodUnitContext()

		decrementObjectCounterForLastUnitInstruction()

		def generateUnitMethodInit():Unit =
		{
			topClassFrame
				.addMethodInit(PUBLIC, BytecodeMethodDescriptors.UNIT_HEIR__METHOD__INIT_2)
				.generateSuperConstructorCall()
				.generateSettingType()
				.`return`()

			implicit class GenerateUnitMethodInit(val methodBuilder:MethodBuilder)
			{
				def generateSuperConstructorCall():methodBuilder.type =
				{
					methodBuilder
						.aloadthis()
						.aloadUnitHeirMethodInitParameterUnitContext()
						.invokeInitUnit()

					methodBuilder
				}

				def generateSettingType():methodBuilder.type =
				{
					methodBuilder
						.aloadthis()
						.generateUnitTypeCreation()
						.invokeVirtualUnitMethodSetType()

					methodBuilder
				}

				def generateUnitTypeCreation():methodBuilder.type =
				{
					methodBuilder
						.newType()
						.dup()
						.ldc(unitName.getOrElse(LType.ANONYMOUS_TYPE_NAME))
						.aloadthis()
						.invokeVirtualJavaObjectMethodGetClass()
						.invokeInitType()

					methodBuilder
				}
			}
		}

		def generateUnit():Unit =
		{
			preTopMethodCall
				.generateUnitSavingTarget()
				.generateUnitCreation()
				.generateUnitCallParameterNamesSaving()
				.generateUnitSaving()

			implicit class GenerateUnit(val methodBuilder:MethodBuilder)
			{
				def generateUnitSavingTarget():methodBuilder.type =
				{
					unitName.foreach(_ =>
						if (isUnitModuleMember || isUnitUnitMember) methodBuilder.aloadUnitMethodCallParameterHost()
						else methodBuilder.aloadUnitMethodCallVariableUnitContext()
					)

					methodBuilder
				}

				def generateUnitCreation():methodBuilder.type =
				{
					methodBuilder
						.`new`(topClassFrame.internalName)
						.dup()
						.aloadUnitMethodCallVariableUnitContext()
						.aloadUnitMethodCallParameterParameters()
						.invokeInit2UnitHeir(topClassFrame.internalName)

					methodBuilder
				}

				def generateUnitCallParameterNamesSaving():methodBuilder.type =
				{
					val unitParameterNames:Seq[String] =
						for (i <- unitName.map(_ => 1).getOrElse(0) until unitContext.IDENTIFIER.size)
							yield getIdentifierName(i)

					if (unitParameterNames.nonEmpty)
					{
						preTopMethodCall
							.ldc(unitParameterNames.size)
							.anewarrayJavaString()

						for (i <- unitParameterNames.indices)
							preTopMethodCall
								.dup()
								.ldc(i)
								.ldc(unitParameterNames(i))
								.aastore()

						preTopMethodCall.invokeVirtualUnitMethodSetParameterNames()
					}

					methodBuilder
				}

				def generateUnitSaving():Unit =
					unitName.foreach(unitName =>
					{
						preTopMethodCall
							.ldc(unitName)
							.swap()

						if (isUnitUnitMember || isUnitModuleMember) preTopMethodCall.invokeVirtualUnitMethodSetMember()
						else preTopMethodCall.invokeVirtualUnitContextMethodSetVariable()
					})
			}
		}

		def generateUnitCallMethodUnitContext():Unit =
			topMethodCall
				.newUnitContext()
				.dup()
				.aloadthis()
				.aloadUnitMethodCallParameterHost()
				.aloadUnitMethodCallParameterParameters()
				.invokeInitUnitContext()
				.astoreUnitMethodCallVariableUnitContext()

		def decrementObjectCounterForLastUnitInstruction():Unit =
		{
			val unitLastInstruction:InstructionContext = unitContext.instruction(unitContext.instruction.size - 1)

			generationContext.addPreExitRuleTask(unitLastInstruction, () => topMethodCall.decrementObjectStackCounter())
		}
	}

	override protected def exitAction():Unit =
	{
		topMethodCall.aReturn()

		classLoader
			.setClassCode(
				topClassFrame.internalName,
				topClassFrame toBytecode (if (SystemSettings.TRACE_BYTECODE) Some(System.out) else None)
			)

		popFrame()
	}

	private def getIdentifierName(identifierIndex:Int) = unitContext.IDENTIFIER(identifierIndex).getText
}

private[generation] object UnitGenerationRule
{
	def enter(unitContext:UnitContext)(implicit generationContext:GenerationContext):Unit =
		new UnitGenerationRule(unitContext).enter()

	def exit(unitContext:UnitContext)(implicit generationContext:GenerationContext):Unit =
		new UnitGenerationRule(unitContext).exit()
}