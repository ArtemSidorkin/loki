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

	private def unitParameters = for (i <- 0 until unitContext.unitParameter.size) yield unitContext.unitParameter(i)

	override protected def enterAction():Unit =
	{
		pushUnitFrame()

		createUnitConstructor()
		createAndSaveUnitClassInstance()
		createUnitCallPrelude()

		decrementObjectCounterForLastUnitInstruction()

		def createUnitConstructor():Unit =
		{
			topClassFrame
				.addMethodInit(PUBLIC, DynamicallyUnresolvableMethodDescriptors.SUBUNIT_CONSTRUCTOR(None))
				.callSuperConstructor()
				.setUnitType()
				.`return`()

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
						.ldc(unitName.getOrElse(LType.ANONYMOUS_TYPE_NAME))
						.aloadthis()
						.invokeVirtualJavaObjectMethodGetClass()
						.invokeInitType()

					methodBuilder
				}
			}
		}

		def createAndSaveUnitClassInstance():Unit =
		{
			preTopMethodCall
				.createUnitSavingTarget()
				.createUnitClassInstance()
				.saveUnitCallParameterNames()
				.saveUnitClassInstance()

			implicit class MethodBuilderExtension(val methodBuilder:MethodBuilder)
			{
				def createUnitSavingTarget():methodBuilder.type =
				{
					unitName.foreach(_ =>
						if (isUnitModuleMember || isUnitUnitMember) methodBuilder.aloadUnitMethodCallParameterHost()
						else methodBuilder.aloadUnitMethodCallVariableUnitContext()
					)

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
					unitName.foreach(unitName =>
					{
						methodBuilder
							.ldc(unitName)
							.swap()

						if (isUnitUnitMember || isUnitModuleMember) methodBuilder.invokeVirtualUnitMethodSetMember()
						else methodBuilder.invokeVirtualUnitContextMethodSetVariable()
					})

					methodBuilder
				}
			}
		}

		def createUnitCallPrelude():Unit =
		{
			topMethodCall
				.createUnitCallMethodUnitContext()
				.createUnitBody()
				.createDefaultUnitParameters()
				.createEmbeddedUnitMembers()

			implicit class MethodBuilderExtension(val methodBuilder:MethodBuilder)
			{
				def createUnitCallMethodUnitContext():methodBuilder.type =
				{
					methodBuilder
						.newUnitContext()
						.dup()
						.aloadthis()
						.aloadUnitMethodCallParameterHost()
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
									unitDefaultParameterValue.expression, methodBuilder.getAndSaveEmbeddedUnitMember
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
								.aloadUnitMethodCallParameterHost()
								.ldc(identifier)
								.aloadUnitMethodCallVariableUnitContext()
								.ldc(identifier)
								.invokeVirtualUnitContextMethodGetVariable()
								.invokeVirtualUnitMethodSetMember()
								.pop()
						})

					methodBuilder
				}
			}
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