package loki.language.generation.java.rules

import java.io.File

import loki.language.generation.consts.CConstLanguageMembers._
import loki.language.generation.java.CGenerationJava.CGenerationContextJava
import loki.language.generation.rules.mixins.ModuleGenerationRuleMixin
import loki.language.parsing.LokiParser.ModuleContext
import loki.runtime.context.{LModuleContext, LUnitContext}
import loki.runtime.datatype.{LModule, LUnit}
import loki.system.SystemConfiguration
import loki.system.SystemConfiguration.UNIX
import loki.util.FileUtil
import loki.util.extension.StringExtensions.StringExtensions

class GenerationRuleJavaModule(generationContext:CGenerationContextJava, ruleContext:ModuleContext)
	extends GenerationRuleJava(generationContext, ruleContext) with ModuleGenerationRuleMixin
{
	override protected def enterAction()
	{
		pushFrame()
		(addCode _ compose removeTabulation) (
			s"""
				public class $moduleName extends ${classOf[LModule].getName}
				{
					public $moduleName(${classOf[LUnitContext].getName} $UNIT__METHOD__INIT__CALL_PARAMETER__CONTEXT)
					{
						super("$moduleName", $UNIT__METHOD__INIT__CALL_PARAMETER__CONTEXT);
					}

					public ${classOf[LUnit].getName} $UNIT__METHOD__CALL(final ${classOf[LUnit].getName} $UNIT__METHOD__CALL__PARAMETER__HOST, final ${classOf[LUnit].getName}[] $UNIT__METHOD__CALL__PARAMETER__PARAMETERS, ${classOf[LUnitContext].getName} $UNIT__METHOD__CALL__PARAMETER__CONTEXT)
					{
						$UNIT__METHOD__CALL__PARAMETER__CONTEXT = new ${classOf[LModuleContext].getName}(this, $UNIT__METHOD__CALL__PARAMETER__HOST, $UNIT__METHOD__CALL__PARAMETER__PARAMETERS, this.$UNIT__FIELD__UNIT_CONTEXT);
			""".withoutSideLines
		)
	}

	override protected def exitAction()
	{
		(addCode _ compose removeTabulationBackward) (
			s"""
						return this;
					}
				}
			""".withoutSideLines
		)
		popFrame()
		saveJavaCodeAndLoadBytecode()

		def saveJavaCodeAndLoadBytecode()
		{
			val mdlFldr = new File(moduleName)
			mdlFldr.mkdir()
			val mdlFldrPthnm = mdlFldr.getAbsolutePath
			val mdlFlPthnm = s"$mdlFldrPthnm/$moduleName.java"
			FileUtil.writeText(mdlFlPthnm, generationContext.code.toString)
			Runtime.getRuntime.exec(
				s"javac $mdlFlPthnm -cp ./target/classes${if (SystemConfiguration.OS == UNIX) ":" else ";"}./lib/antlr.jar"
			).waitFor()

			(
				mdlFldr list ()
				filter (_ endsWith ".class")
				foreach (clsFlPthnm =>
					classLoader.setClassCode(
						clsFlPthnm replace (".class", ""), FileUtil readBytes s"$mdlFldrPthnm/$clsFlPthnm"
					)
				)
			)
		}
	}
}

object GenerationRuleJavaModule
{
	def enter(generationContext:CGenerationContextJava, ruleContext:ModuleContext):Unit =
		new GenerationRuleJavaModule(generationContext, ruleContext).enter()

	def exit(generationContext:CGenerationContextJava, ruleContext:ModuleContext):Unit =
		new GenerationRuleJavaModule(generationContext, ruleContext).exit()
}