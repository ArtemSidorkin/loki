package loki.language.generation.rule

import assembler.builder.MethodBuilder
import assembler.constant.{FINAL, PUBLIC, SYNTHETIC}
import loki.language.generation.GenerationContext
import loki.language.generation.bytecodetemplate.CommonBytecodeTemplate.CommonBytecodeTemplate
import loki.language.generation.bytecodetemplate.ContextBytecodeTemplate.ContextBytecodeTemplate
import loki.language.generation.bytecodetemplate.TypeBytecodeTemplate.TypeBytecodeTemplate
import loki.language.generation.bytecodetemplate.UnitBytecodeTemplate.UnitBytecodeTemplate
import loki.language.generation.constant.BytecodeMethodDescriptors
import loki.language.parsing.LokiParser.{InstructionContext, UnitContext}
import loki.language.parsing.{LokiLexer, LokiParser}
import loki.runtime.datatype.unit.LUnit
import loki.system.SystemSettings

//TODO: check & refactor
private[generation] class UnitGenerationRule
	(unitContext:UnitContext)(implicit generationContext:GenerationContext)
	extends GenerationRule(unitContext)
{
	private val unitName:Option[String] =
		unitContext.head.getType match
		{
			case LokiLexer.IDENTIFIER => Some(getUnitParameterIdentifier(0).getText)
			case LokiLexer.BACKSLASH => None
		}

	private val unitParameterNames:Seq[String] =
		for (i <- unitName.foldLeft(0)((_, _) => 1) until unitContext.IDENTIFIER.size)
			yield getUnitParameterIdentifier(i).getText

	private val unitLastInstruction:InstructionContext = unitContext instruction unitContext.instruction.size - 1

	override protected def enterAction()
	{
		pushUnitFrame()

		(
			generateUnitMethodInit _
			compose addAndGenerateParametersUnitFieldIfOuterClassIsUnitInMethodInit
		) (addUnitMethodInit())

		generateContainerForUnitSavingIfUnitIsNotAnonymousInPretopMethodCall()
		generateUnitCreationAndInitInPreTopMethodCall()
		generateUnitCallParameterNamesSavingIfNeeded()
		generateUnitSavingInPretopMethodCall()

		generateUnitMethodCall()

		addReturnToUnitMethodCall(generationContext, unitLastInstruction)

		generationContext.addPreExitRuleTask(unitLastInstruction, () => topMethodCall decrementObjectCounter ())

		def addUnitMethodInit() =
			if (isPreTopFrameModule) topClassFrame.addMethodInit(
				PUBLIC, BytecodeMethodDescriptors UNIT_HEIR__METHOD__INIT_1
			)
			else topClassFrame.addMethodInit(
				PUBLIC, BytecodeMethodDescriptors UNIT_HEIR__METHOD__INIT_2
			)

		def addAndGenerateParametersUnitFieldIfOuterClassIsUnitInMethodInit(methodInit:MethodBuilder) =
		{
			if (isPreTopFrameUnit)
			{
				topClassFrame.addField(FINAL & SYNTHETIC, topParametersFieldName, classOf[Array[LUnit]])

				(
					methodInit
					aloadthis ()
					aloadUnitHeirMethodInitParameterParameters ()
					putfield (topClassFrame.internalName, topParametersFieldName, classOf[Array[LUnit]])
				)
			}
			methodInit
		}

		def generateUnitMethodInit(methodInit:MethodBuilder) =
		(
			methodInit
			aloadthis ()
			aloadUnitHeirMethodInitParameterType ()
			aloadUnitHeirMethodInitParameterUnitContext ()
			invokeInitUnit ()
			`return` ()
		)

		def generateContainerForUnitSavingIfUnitIsNotAnonymousInPretopMethodCall():Unit = unitName foreach (untNm =>
		{
			if (isUnitModuleMember || isUnitUnitMember) preTopMethodCall aloadUnitMethodCallParameterHost ()
			else preTopMethodCall aloadUnitMethodCallVariableUnitContext ()
			preTopMethodCall ldc untNm
		})

		def generateUnitCreationAndInitInPreTopMethodCall()
		{
			generateUnitCreation()
			generateUnitType()
			generateUnitContext()
			generateUnitInit()

			def generateUnitCreation():Unit =
			(
				preTopMethodCall
				`new` topClassFrame.internalName
				dup ()
			)

			def generateUnitType():Unit = unitName map (untNm =>
			(
				preTopMethodCall
				newType ()
				dup ()
				ldc untNm
				invokeInitType ()
			)) getOrElse
			(
				preTopMethodCall
				invokestaticTypeMethodCreateAnonymous ()
			)

			def generateUnitContext():Unit =
			(
				preTopMethodCall
				aloadUnitMethodCallVariableUnitContext ()
			)

			def generateUnitInit():Unit = (if (isPreTopFrameModule)
			(
				preTopMethodCall
				invokeInit1UnitHeir (topClassFrame.internalName)
			) else
			(
				preTopMethodCall
				aloadUnitMethodCallParameterParameters ()
				invokeInit2UnitHeir (topClassFrame.internalName)
			))
		}

		def generateUnitSavingInPretopMethodCall():Unit = unitName foreach (_ =>
			if (isUnitUnitMember || isUnitModuleMember) preTopMethodCall invokeVirtualUnitMethodSetMember ()
			else preTopMethodCall invokeVirtualUnitContextMethodSetVariable ()
		)

		def generateUnitMethodCall() =
		(
			topMethodCall
			newUnitContext ()
			dup ()
			aloadthis ()
			aloadUnitMethodCallParameterHost ()
			aloadthis ()
			invokeVirtualUnitMethodGetCapturedOnCreationUnitContext topClassFrame.internalName
			aloadUnitMethodCallParameterParameters ()
			invokeInitUnitContext ()
			astoreUnitMethodCallVariableUnitContext ()
		)


		def generateUnitCallParameterNamesSavingIfNeeded():Unit = if (unitParameterNames.nonEmpty)
		{
			(
				preTopMethodCall
				ldc unitParameterNames.size
				anewarrayJavaString ()
			)

			for (i <- unitParameterNames.indices)
			(
				preTopMethodCall
				dup ()
				ldc i
				ldc unitParameterNames(i)
				aastore ()
			)

			(
				preTopMethodCall
				invokeVirtualUnitMethodSetParameterNames ()
			)
		}

		def addReturnToUnitMethodCall(
			generationContext:GenerationContext, unitContext:LokiParser.InstructionContext
		):Unit =
			if (unitContext.expression != null)
				generationContext.addPostExitRuleTask(unitContext.expression, () => topMethodCall aReturn ())
	}

	override protected def exitAction()
	{
		classLoader.setClassCode(
			topClassFrame.internalName,
			topClassFrame toBytecode (if (SystemSettings.TRACE_BYTECODE) Some(System.out) else None)
		)

		popFrame()
	}

	private def isUnitModuleMember:Boolean = generationContext.frameStack.size <= 2 && unitContext.DOLLAR != null
	private def isUnitUnitMember:Boolean = generationContext.frameStack.size > 2 && unitContext.DOLLAR != null

	private def getUnitParameterIdentifier(parameterIndex:Int) = unitContext IDENTIFIER parameterIndex
}

private[generation] object UnitGenerationRule
{
	def enter(unitContext:UnitContext)(implicit generationContext:GenerationContext):Unit =
		new UnitGenerationRule(unitContext).enter()

	def exit(unitContext:UnitContext)(implicit generationContext:GenerationContext):Unit =
		new UnitGenerationRule(unitContext).exit()
}