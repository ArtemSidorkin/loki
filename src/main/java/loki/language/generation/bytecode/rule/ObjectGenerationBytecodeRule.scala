package loki.language.generation.bytecode.rule

import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.rule.template.ContainerGenerationBytecodeRuleTemplate
import loki.language.generation.rule.mixin.ObjectGenerationRuleMixin
import loki.language.parsing.LokiParser.ObjectContext

class ObjectGenerationBytecodeRule(bytecodeGenerationContext:BytecodeGenerationContext, objectContext:ObjectContext)
	extends BytecodeGenerationRule(bytecodeGenerationContext, objectContext) with ObjectGenerationRuleMixin
{
	override protected def enterAction():Unit =
		new ContainerGenerationBytecodeRuleTemplate(bytecodeGenerationContext, objectContext)
			.enter(objectClass, objectMemberNameValueItemCount, objectKeyValueItemExpressionContexts)

	override protected def exitAction():Unit =
		new ContainerGenerationBytecodeRuleTemplate(bytecodeGenerationContext, objectContext)
			.exit(objectClass)
}