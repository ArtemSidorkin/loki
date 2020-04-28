package loki.language.generation.rule

import assembler.builder.MethodBuilder
import assembler.constant.PUBLIC
import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitContextBytecodeTemplate.UnitContextBytecodeTemplate
import loki.language.generation.bytecodetemplate.TypeBytecodeTemplate.TypeBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.generation.constant.DynamicallyUnresolvableMethodDescriptors
import loki.language.parsing.LokiParser.{InstructionContext, UnitContext}
import loki.runtime.LType
import loki.system.SystemSettings

private[generation] class UnitGenerationRule(unitContext:UnitContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(unitContext)
{
	private def isUnitModuleMember:Boolean = generationContext.frameStack.size <= 2 && unitContext.member != null
	private def isUnitUnitMember:Boolean = generationContext.frameStack.size > 2 && unitContext.member != null

	private def unitName:Option[String] = Option(unitContext.name).map(_.getText)

	override protected def enterAction():Unit =
	{
		pushUnitFrame()

		generateUnitMethodInit()
		generateUnit()
		generateUnitCallMethodUnitContext()
		generateUnitBody()
		generateDefaultUnitParameters()
		generateEmbeddedMembers()
		decrementObjectCounterForLastUnitInstruction()

		def generateUnitMethodInit():Unit =
		{
			topClassFrame
				.addMethodInit(PUBLIC, DynamicallyUnresolvableMethodDescriptors.SUBUNIT_CONSTRUCTOR(None))
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
						for (i <- 0 until unitContext.unitParameter().size)
							yield unitContext.unitParameter(i).IDENTIFIER().getText

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

		def generateUnitBody():Unit = if (unitContext.unitBody() == null) topMethodCall.void()

		def generateDefaultUnitParameters():Unit =
			for (i <- 0 until unitContext.unitParameter().size)
			{
				if (unitContext.unitParameter(i).unitDefaultParameterValue != null)
				{
					generationContext
						.addPreEnterRuleTask(
							unitContext.unitParameter(i).unitDefaultParameterValue.expression,
							() =>
							{
								topMethodCall
									.aloadthis()
									.ldc(i)
							}
						)

					generationContext
						.addPostExitRuleTask(
							unitContext.unitParameter(i).unitDefaultParameterValue.expression,
							() =>
							{
								topMethodCall
									.invokeVirtualUnitMethodSetParameterDefaultValue()
									.decrementObjectStackCounter()
							}
						)
				}
			}

		def generateEmbeddedMembers():Unit =
		{
			for (i <- unitContext.unitParameter().size - 1 to 0 by -1)
			{
				if (unitContext.unitParameter(i).unitDefaultParameterValue != null)
				{
					generationContext
						.addPostExitRuleTask(
							unitContext.unitParameter(i).unitDefaultParameterValue.expression,
							() =>
							{
								for (i <- 0 until unitContext.unitParameter().size if unitContext.unitParameter(i).DOLLAR != null)
									topMethodCall
										.aloadUnitMethodCallParameterHost()
										.ldc(unitContext.unitParameter(i).IDENTIFIER().getText)
										.aloadUnitMethodCallVariableUnitContext()
										.ldc(unitContext.unitParameter(i).IDENTIFIER().getText)
										.invokeVirtualUnitContextMethodGetVariable()
										.invokeVirtualUnitMethodSetMember()
										.pop()
							}
						)
					return
				}
			}

			for (i <- 0 until unitContext.unitParameter().size if unitContext.unitParameter(i).DOLLAR != null)
				topMethodCall
					.aloadUnitMethodCallParameterHost()
					.ldc(unitContext.unitParameter(i).IDENTIFIER().getText)
					.aloadUnitMethodCallVariableUnitContext()
					.ldc(unitContext.unitParameter(i).IDENTIFIER().getText)
					.invokeVirtualUnitContextMethodGetVariable()
					.invokeVirtualUnitMethodSetMember()
					.pop()
		}


		def decrementObjectCounterForLastUnitInstruction():Unit =
			if (unitContext.unitBody() != null)
			{
				val unitLastInstruction:InstructionContext =
					unitContext.unitBody().instruction(unitContext.unitBody().instruction().size - 1)

				generationContext
					.addPreExitRuleTask(unitLastInstruction, () => topMethodCall.decrementObjectStackCounter())
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
}

private[generation] object UnitGenerationRule
{
	def enter(unitContext:UnitContext)(implicit generationContext:GenerationContext):Unit =
		new UnitGenerationRule(unitContext).enter()

	def exit(unitContext:UnitContext)(implicit generationContext:GenerationContext):Unit =
		new UnitGenerationRule(unitContext).exit()
}