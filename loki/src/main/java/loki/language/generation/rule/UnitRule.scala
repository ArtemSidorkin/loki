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
import loki.system.SystemSettings

private[generation] class UnitRule(unitContext:UnitContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(unitContext)
{
	private val unitName:String =
		Option(unitContext.name)
			.map(_.getText)
			.orElse(
				Option(unitContext.UNDERSCORE()).map(_.getText).orElse(Option(unitContext.BACKSLASH()).map(_.getText))
			)
			.get

	override protected def enterAction():Unit =
	{
		def createUnitConstructor():Unit =
		{
			implicit class MethodBuilderExtension(val methodBuilder:MethodBuilder)
			{
				def callSuperConstructor():methodBuilder.type =
				{
					methodBuilder
						.aloadthis()
						.aloadUnitHeirMethodInitParameterUnitContext()
						.invokeInitUnit()

					methodBuilder
				}

				def setUnitType():methodBuilder.type =
				{
					methodBuilder
						.aloadthis()
						.createUnitType()
						.invokeVirtualUnitMethodSetType()

					methodBuilder
				}

				def createUnitType():methodBuilder.type =
				{
					methodBuilder
						.newType()
						.dup()
						.ldc(unitName)
						.aloadthis()
						.invokeVirtualJavaObjectMethodGetClass()
						.invokeInitType()

					methodBuilder
				}
			}

			topClassFrame
				.addMethodInit(PUBLIC, DynamicallyUnresolvableMethodDescriptors.SUBUNIT_CONSTRUCTOR(None))
				.callSuperConstructor()
				.setUnitType()
				.`return`()
		}

		def createAndSaveUnitClassInstance():Unit =
		{
			implicit class MethodBuilderExtension(val methodBuilder:MethodBuilder)
			{
				def createUnitSavingTarget():methodBuilder.type =
				{
					if (!isAnonymous)
						if (isUnitModuleMember || isUnitUnitMember) methodBuilder.aloadHostParameterOfUnitCallMethod()
						else methodBuilder.aloadUnitMethodCallVariableUnitContext()

					methodBuilder
				}

				def createUnitClassInstance():methodBuilder.type =
				{
					methodBuilder
						.`new`(topClassFrame.internalName)
						.dup()
						.aloadUnitMethodCallVariableUnitContext()
						.aloadUnitMethodCallParameterParameters()
						.invokeInit2UnitHeir(topClassFrame.internalName)

					methodBuilder
				}

				def saveUnitCallParameterNames():methodBuilder.type =
				{
					val unitParameterNames:Seq[String] =
						for (i <- 0 until unitContext.unitParameter().size)
							yield unitContext.unitParameter(i).IDENTIFIER().getText

					if (unitParameterNames.nonEmpty)
					{
						methodBuilder
							.ldc(unitParameterNames.size)
							.anewarrayJavaString()

						for (i <- unitParameterNames.indices)
							methodBuilder
								.dup()
								.ldc(i)
								.ldc(unitParameterNames(i))
								.aastore()

						methodBuilder.invokeVirtualUnitMethodSetParameterNames()
					}

					methodBuilder
				}

				def saveUnitClassInstance():methodBuilder.type =
				{
					if (!isAnonymous)
					{
						methodBuilder
							.ldc(unitName)
							.swap()

						if (isUnitUnitMember || isUnitModuleMember) methodBuilder.invokeVirtualUnitSetMemberMethod()
						else methodBuilder.invokeVirtualUnitContextMethodSetVariable()
					}


					methodBuilder
				}
			}

			preTopMethodCall
				.createUnitSavingTarget()
				.createUnitClassInstance()
				.saveUnitCallParameterNames()
				.saveUnitClassInstance()
		}

		def createUnitCallPrelude():Unit =
		{
			implicit class MethodBuilderExtension(val methodBuilder:MethodBuilder)
			{
				def createUnitCallMethodUnitContext():methodBuilder.type =
				{
					methodBuilder
						.newUnitContext()
						.dup()
						.aloadthis()
						.aloadHostParameterOfUnitCallMethod()
						.aloadUnitMethodCallParameterParameters()
						.invokeInitUnitContext()
						.astoreUnitMethodCallVariableUnitContext()

					methodBuilder
				}

				def createUnitBody():methodBuilder.type =
				{
					if (unitContext.unitBody() == null) methodBuilder.void()

					methodBuilder
				}

				def createDefaultUnitParameters():methodBuilder.type =
				{
					for (i <- 0 until unitContext.unitParameter().size)
					{
						if (unitContext.unitParameter(i).unitDefaultParameterValue != null)
						{
							generationContext
								.addPreEnterRuleTask(
									unitContext.unitParameter(i).unitDefaultParameterValue.expression,
									() =>
									{
										methodBuilder
											.aloadthis()
											.ldc(i)
									}
								)

							generationContext
								.addPostExitRuleTask(
									unitContext.unitParameter(i).unitDefaultParameterValue.expression,
									() =>
									{
										methodBuilder
											.invokeVirtualUnitMethodSetParameterDefaultValue()
											.decrementObjectStackCounter()
									}
								)
						}
					}

					methodBuilder
				}

				def createEmbeddedUnitMembers():methodBuilder.type =
				{
					unitParameters
						.map(_.unitDefaultParameterValue)
						.flatMap(Option(_))
						.lastOption
						.map(unitDefaultParameterValue =>
							generationContext
								.addPostExitRuleTask(
									unitDefaultParameterValue.expression,
									() => methodBuilder.getAndSaveEmbeddedUnitMember()
								)
						)
						.getOrElse(methodBuilder.getAndSaveEmbeddedUnitMember())

					methodBuilder
				}

				def getAndSaveEmbeddedUnitMember():methodBuilder.type =
				{
					unitParameters
						.filter(_.DOLLAR != null)
						.map(_.IDENTIFIER.getText)
						.foreach(identifier =>
						{
							methodBuilder
								.aloadHostParameterOfUnitCallMethod()
								.ldc(identifier)
								.aloadUnitMethodCallVariableUnitContext()
								.ldc(identifier)
								.invokeVirtualUnitContextMethodGetVariable()
								.invokeVirtualUnitSetMemberMethod()
								.pop()
						})

					methodBuilder
				}
			}

			topMethodCall
				.createUnitCallMethodUnitContext()
				.createUnitBody()
				.createDefaultUnitParameters()
				.createEmbeddedUnitMembers()
		}

		def decrementObjectCounterForLastUnitInstruction():Unit =
			if (unitContext.unitBody() != null)
			{
				val unitLastInstruction:InstructionContext =
					unitContext.unitBody().instruction(unitContext.unitBody().instruction().size - 1)

				generationContext
					.addPreExitRuleTask(unitLastInstruction, () => topMethodCall.decrementObjectStackCounter())
			}

		pushUnitFrame()

		createUnitConstructor()
		createAndSaveUnitClassInstance()
		createUnitCallPrelude()

		decrementObjectCounterForLastUnitInstruction()
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

	private def isUnitModuleMember:Boolean = generationContext.frameStack.size <= 2 && unitContext.member != null
	private def isUnitUnitMember:Boolean = generationContext.frameStack.size > 2 && unitContext.member != null
	private def isAnonymous:Boolean = unitContext.UNDERSCORE != null || unitContext.BACKSLASH != null
	private def unitParameters = for (i <- 0 until unitContext.unitParameter.size) yield unitContext.unitParameter(i)
}