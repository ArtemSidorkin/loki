package cloki.language.generation.bytecode.rules

import cloki.language.generation.bytecode.CGenerationBytecode.CGenerationContextBytecode
import cloki.language.generation.bytecode.templates.CTemplateBytecodeUnit.CTemplateUnit
import cloki.language.generation.rules.mixins.CMixinRuleGenerationHostMember
import cloki.language.parsing.CLokiParser.HostMemberContext

private[bytecode] object CRuleGenerationBytecodeHostMember
	extends CRuleGenerationBytecode[HostMemberContext]
{
	protected class CCoreBytecodeHostMember(generationContext:CGenerationContextBytecode, ruleContext:HostMemberContext)
		extends CCoreBytecode(generationContext, ruleContext) with CMixinRuleGenerationHostMember
	{
		override def enter() =
		(
			topMethodCall
			aloadUnitMethodCallParameterHost ()
			ldc hostMemberName
			invokeVirtualUnitMethodGetMember ()
			incrementObjectCounter ()
		)
	}

	override protected def getCore(generationContext:CGenerationContextBytecode, ruleContext:HostMemberContext) =
		new CCoreBytecodeHostMember(generationContext, ruleContext)
}
