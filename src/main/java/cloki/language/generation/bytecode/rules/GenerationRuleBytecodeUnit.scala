package cloki.language.generation.bytecode.rules

import casm._
import casm.consts.{FINAL, PUBLIC, SYNTHETIC}
import casm.entities.CAMethod
import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.consts.CConstBytecodeMethodDescriptors
import cloki.language.generation.bytecode.templates.CTemplateBytecodeCommon.CTemplateCommon
import cloki.language.generation.bytecode.templates.CTemplateBytecodeContext.CTemplateContext
import cloki.language.generation.bytecode.templates.CTemplateBytecodeType.CTemplateType
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationUnit
import cloki.language.parsing.LokiParser
import cloki.language.parsing.LokiParser.UnitContext
import cloki.runtime.datatype.LUnit
import cloki.system.SystemSettings

class GenerationRuleBytecodeUnit(generationContext:CGenerationContextBytecode, ruleContext:UnitContext)
	extends GenerationRuleBytecode(generationContext, ruleContext) with CMixinRuleGenerationUnit
{
	override def __enter()
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
				PUBLIC, CConstBytecodeMethodDescriptors UNIT_HEIR__METHOD__INIT_1 preTopClassFrame.descriptor
			)
			else topClassFrame.addMethodInit(
				PUBLIC, CConstBytecodeMethodDescriptors UNIT_HEIR__METHOD__INIT_2 preTopClassFrame.descriptor
			)

		def addAndGenerateUnitFieldOuterClassInMethodInit(methodInit:CAMethod) =
		{
			topClassFrame.addField(
				FINAL & SYNTHETIC, topOuterClassFieldName, CAUtils getClassDescriptor preTopClassFrame.internalName
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

		def addAndGenerateParametersUnitFieldIfOuterClassIsUnitInMethodInit(methodInit:CAMethod) =
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

		def generateUnitMethodInit(methodInit:CAMethod) =
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
			generationContext:CGenerationContextBytecode, ruleContext:LokiParser.InstructionContext
		):Unit = if (ruleContext.expression != null)
			generationContext.addPostExitRuleTask(ruleContext.expression, () => topMethodCall aReturn ())
	}

	override def __exit()
	{
		classLoader.setClassCode(
			topClassFrame.internalName,
			topClassFrame toBytecode (if (SystemSettings.TRACE_BYTECODE) Some(System.out) else None)
		)

		popFrame()

		if (isInheritancePresent) generationContext.applyDeferredRules(ruleContext.inheritance)
	}
}
