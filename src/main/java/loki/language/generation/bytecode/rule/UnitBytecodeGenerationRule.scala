package loki.language.generation.bytecode.rule

import assembler._
import assembler.builder.MethodBuilder
import assembler.const.{FINAL, PUBLIC, SYNTHETIC}
import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.constant.BytecodeMethodDescriptors
import loki.language.generation.bytecode.template.CommonBytecodeTemplate.CTemplateCommon
import loki.language.generation.bytecode.template.ContextBytecodeTemplate.CTemplateContext
import loki.language.generation.bytecode.template.TypeBytecodeTemplate.CTemplateType
import loki.language.generation.bytecode.template.UnitBytecodeTemplate.CTemplateUnit
import loki.language.generation.rule.mixin.UnitGenerationRuleMixin
import loki.language.parsing.LokiParser
import loki.language.parsing.LokiParser.UnitContext
import loki.runtime.datatype.LUnit
import loki.system.SystemSettings

class UnitBytecodeGenerationRule(generationContext:BytecodeGenerationContext, ruleContext:UnitContext)
	extends BytecodeGenerationRule(generationContext, ruleContext) with UnitGenerationRuleMixin
{
	override protected def enterAction()
	{
		pushUnitFrame()

		(
			generateUnitMethodInit _
			compose addAndGenerateUnitFieldOuterClassInMethodInit
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
				PUBLIC, BytecodeMethodDescriptors UNIT_HEIR__METHOD__INIT_1 preTopClassFrame.descriptor
			)
			else topClassFrame.addMethodInit(
				PUBLIC, BytecodeMethodDescriptors UNIT_HEIR__METHOD__INIT_2 preTopClassFrame.descriptor
			)

		def addAndGenerateUnitFieldOuterClassInMethodInit(methodInit:MethodBuilder) =
		{
			topClassFrame.addField(
				FINAL & SYNTHETIC, topOuterClassFieldName, Utils getClassDescriptor preTopClassFrame.internalName
			)
			(
				methodInit
				aloadthis ()
				aloadUnitMethodCallParameterHost ()
				putfield
				(
					topClassFrame.internalName, topOuterClassFieldName, preTopClassFrame.descriptor
				)
			)
		}

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
			generateOuterClassInstance()
			generateUnitType()
			generateUnitContext()
			generateUnitInit()

			def generateUnitCreation():Unit =
			(
				preTopMethodCall
				`new` topClassFrame.internalName
				dup ()
			)

			def generateOuterClassInstance():Unit = preTopMethodCall aloadthis ()

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
				invokestaticTypeMethodCreateAnonymous
			)

			def generateUnitContext():Unit =
			(
				preTopMethodCall
				aloadUnitMethodCallVariableUnitContext ()
			)

			def generateUnitInit():Unit = (if (isPreTopFrameModule)
			(
				preTopMethodCall
				invokeInit1UnitHeir (topClassFrame.internalName, preTopClassFrame.descriptor)
			) else
			(
				preTopMethodCall
				aloadUnitMethodCallParameterParameters ()
				invokeInit2UnitHeir (topClassFrame.internalName, preTopClassFrame.descriptor)
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
			getUnitFieldUnitContext topClassFrame.internalName
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
										 generationContext:BytecodeGenerationContext, ruleContext:LokiParser.InstructionContext
		):Unit = if (ruleContext.expression != null)
			generationContext.addPostExitRuleTask(ruleContext.expression, () => topMethodCall aReturn ())
	}

	override protected def exitAction()
	{
		classLoader.setClassCode(
			topClassFrame.internalName,
			topClassFrame toBytecode (if (SystemSettings.TRACE_BYTECODE) Some(System.out) else None)
		)

		popFrame()
	}
}

object UnitBytecodeGenerationRule
{
	def enter(generationContext:BytecodeGenerationContext, ruleContext:UnitContext):Unit =
		new UnitBytecodeGenerationRule(generationContext, ruleContext).enter()

	def exit(generationContext:BytecodeGenerationContext, ruleContext:UnitContext):Unit =
		new UnitBytecodeGenerationRule(generationContext, ruleContext).exit()
}
