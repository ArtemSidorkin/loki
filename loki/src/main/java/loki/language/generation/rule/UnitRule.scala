package loki.language.generation.rule

import assembler.builder.MethodBuilder
import assembler.constant.PUBLIC
import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.TypeBytecodeTemplate.TypeBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitContextBytecodeTemplate.UnitContextBytecodeTemplate
import loki.language.generation.constant.DynamicallyUnresolvableMethodDescriptors.SUBUNIT_INIT_METHOD_DESCRIPTOR
import loki.language.parsing.LokiParser.{InstructionContext, UnitContext}
import loki.system.SystemSettings

private[generation] class UnitRule(unitContext:UnitContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(unitContext)
{
	private def unitName:String =
		extractText(unitContext.name)
			.orElse(extractText(unitContext.UNDERSCORE()))
			.orElse(extractText(unitContext.BACKSLASH()))
			.get

	override protected def enterAction():Unit =
	{
		def createUnitConstructor():Unit =
		{
			topClassFrame
				.addInitMethod(PUBLIC, SUBUNIT_INIT_METHOD_DESCRIPTOR)
				.callSuperConstructor()
				.setUnitType()
				.`return`()
		}

		def createAndSaveUnitClassInstance():Unit =
		{
			preTopMethodCall
				.prepareUnitSavingTarget()
				.createUnitInstance()
				.saveUnitCallParameterNames()
				.saveUnitClassInstance()
		}

		def createUnitCallPrelude():Unit =
		{
			topMethodCall
				.createUnitContextVariableOfUnitCallMethod()
				.createUnitBody()
				.saveDefaultUnitParameters()
				.saveEmbeddedUnitMembers()
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

	private implicit class UnitConstructorBuilder(val methodBuilder:MethodBuilder)
	{
		def callSuperConstructor():methodBuilder.type =
		{
			methodBuilder
				.aloadthis()
				.aloadUnitContextParameterOfSubunitInitMethod()
				.invokeInitUnit()

			methodBuilder
		}

		def setUnitType():methodBuilder.type =
		{
			methodBuilder
				.aloadthis()
				.createUnitType()
				.invokeVirtualUnitSetTypeMethod()

			methodBuilder
		}

		def createUnitType():methodBuilder.type =
		{
			methodBuilder
				.newType()
				.dup()
				.ldc(unitName)
				.aloadthis()
				.invokeVirtualJavaObjectGetClassMethod()
				.invokeInitType()

			methodBuilder
		}
	}

	private implicit class UnitClassInstanceBuilder(val methodBuilder:MethodBuilder)
	{
		def prepareUnitSavingTarget():methodBuilder.type =
		{
			if (!isAnonymous)
				if (isUnitModuleMember || isUnitUnitMember) methodBuilder.aloadHostParameterOfUnitCallMethod()
				else methodBuilder.aloadUnitContextVariableOfUnitCallMethod()

			methodBuilder
		}

		def createUnitInstance():methodBuilder.type =
		{
			methodBuilder
				.`new`(topClassFrame.internalName)
				.dup()
				.aloadUnitContextVariableOfUnitCallMethod()
				.aloadParametersParameterOfUnitCallMethod()
				.invokeInitSubunit(topClassFrame.internalName)

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

				methodBuilder.invokeVirtualUnitSetParameterNamesMethod()
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
				else methodBuilder.invokeVirtualUnitContextSetVariableMethod()
			}

			methodBuilder
		}
	}

	private implicit class UnitCallPreludeBuilder(val methodBuilder:MethodBuilder)
	{
		def createUnitContextVariableOfUnitCallMethod():methodBuilder.type =
		{
			methodBuilder
				.newUnitContext()
				.dup()
				.aloadthis()
				.aloadHostParameterOfUnitCallMethod()
				.aloadParametersParameterOfUnitCallMethod()
				.invokeInitUnitContext()
				.astoreUnitContextVariableOfUnitCallMethod()

			methodBuilder
		}

		def createUnitBody():methodBuilder.type =
		{
			if (unitContext.unitBody() == null) methodBuilder.void()

			methodBuilder
		}

		def saveDefaultUnitParameters():methodBuilder.type =
		{
			for (i <- 0 until unitContext.unitParameter().size)
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
							() => methodBuilder.invokeVirtualUnitSetParameterDefaultValueMethod()
						)
				}

			methodBuilder
		}

		def saveEmbeddedUnitMembers():methodBuilder.type =
		{
			unitParameters
				.map(_.unitDefaultParameterValue)
				.flatMap(Option(_))
				.lastOption
				.map(unitDefaultParameterValue =>
					generationContext
						.addPostExitRuleTask(
							unitDefaultParameterValue.expression, () => methodBuilder._saveEmbeddedUnitMembers()
						)
				)
				.getOrElse(methodBuilder._saveEmbeddedUnitMembers())

			methodBuilder
		}

		def _saveEmbeddedUnitMembers():methodBuilder.type =
		{
			unitParameters
				.filter(_.DOLLAR != null)
				.map(_.IDENTIFIER.getText)
				.foreach(identifier =>
				{
					methodBuilder
						.aloadHostParameterOfUnitCallMethod()
						.ldc(identifier)
						.aloadUnitContextVariableOfUnitCallMethod()
						.ldc(identifier)
						.invokeVirtualUnitContextGetVariableMethod()
						.invokeVirtualUnitSetMemberMethod()
				})

			methodBuilder
		}
	}
}