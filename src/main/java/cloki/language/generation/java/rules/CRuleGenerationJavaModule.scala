package cloki.language.generation.java.rules

import java.io.File

import cloki.language.generation.consts.CConstLanguageMembers._
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.rules.mixins.CMixinRuleGenerationModule
import cloki.language.parsing.CLokiParser.ModuleContext
import cloki.runtime.datatype.{LModule, LUnit}
import cloki.runtime.context.{LModuleContext, LUnitContext}
import cloki.system.CSystem
import cloki.system.CSystem.UNIX
import cloki.utils.CFile
import cloki.utils.extensions.CString.CString

private[java] object CRuleGenerationJavaModule extends CRuleGenerationJava[ModuleContext]
{
	protected class CCoreJavaModule(generationContext:CGenerationContextJava, ruleContext:ModuleContext)
		extends CCoreJava(generationContext, ruleContext) with CMixinRuleGenerationModule
	{
		override def enter()
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

		override def exit()
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
				CFile.writeText(mdlFlPthnm, generationContext.code.toString)
				Runtime.getRuntime.exec(
					s"javac $mdlFlPthnm -cp ./target/classes${if (CSystem.OS == UNIX) ":" else ";"}./lib/antlr.jar"
				).waitFor()

				(
					mdlFldr list ()
					filter (_ endsWith ".class")
					foreach (clsFlPthnm =>
						classLoader.setClassCode(
							clsFlPthnm replace (".class", ""), CFile readBytes s"$mdlFldrPthnm/$clsFlPthnm"
						)
					)
				)
			}
		}
	}

	override def getCore(generationContext:CGenerationContextJava, ruleContext:ModuleContext) =
		new CCoreJavaModule(generationContext, ruleContext)
}
