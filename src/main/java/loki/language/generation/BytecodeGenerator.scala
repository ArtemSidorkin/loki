package loki.language.generation

import loki.language.generation.rule._
import loki.language.generation.rule.mixin.{AssignIndexGenerationRuleMixin, _}
import loki.language.generation.rule.template.{ContainerGenerationRuleTemplate, MemberCallGenerationRuleTemplate}
import loki.language.parsing.LokiBaseListener
import loki.language.parsing.LokiParser._
import org.antlr.v4.runtime.tree.ErrorNode

class BytecodeGenerator(moduleName:String) extends LokiBaseListener
{
	val classLoader = new GenerationClassLoader

	private implicit val bytecodeGenerationContext = new GenerationContext(moduleName, classLoader)

	override def visitErrorNode(errorNode:ErrorNode):Unit = throw new IllegalStateException

	override def enterModule(ruleContext:ModuleContext):Unit =
		ModuleGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitModule(ruleContext:ModuleContext):Unit =
		ModuleGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterInstruction(ruleContext:InstructionContext):Unit =
		InstructionGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitInstruction(ruleContext:InstructionContext):Unit =
		InstructionGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterExpressionGroup(ruleContext:ExpressionGroupContext):Unit =
		GenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitExpressionGroup(ruleContext:ExpressionGroupContext):Unit =
		GenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterUnit(ruleContext:UnitContext):Unit =
		UnitGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitUnit(ruleContext:UnitContext):Unit =
		UnitGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterArray(arrayContext:ArrayContext):Unit = (
		new ContainerGenerationRuleTemplate(bytecodeGenerationContext, arrayContext)
			with ArrayGenerationRuleMixin
	)
		.enter()

	override def exitArray(arrayContext:ArrayContext):Unit = (
		new ContainerGenerationRuleTemplate(bytecodeGenerationContext, arrayContext)
			with ArrayGenerationRuleMixin
	)
		.exit()

	override def enterMap(mapContext:MapContext):Unit =	(
		new ContainerGenerationRuleTemplate(bytecodeGenerationContext, mapContext)	with MapGenerationRuleMixin
	)
		.enter()

	override def exitMap(mapContext:MapContext):Unit = (
		new ContainerGenerationRuleTemplate(bytecodeGenerationContext, mapContext)	with MapGenerationRuleMixin
	)
		.exit()

	override def enterObject(objectContext:ObjectContext):Unit = (
		new ContainerGenerationRuleTemplate(bytecodeGenerationContext, objectContext)
			with ObjectGenerationRuleMixin
	)
		.enter()

	override def exitObject(objectContext:ObjectContext):Unit =	(
		new ContainerGenerationRuleTemplate(bytecodeGenerationContext, objectContext)
			with ObjectGenerationRuleMixin
	)
		.exit()

	override def enterIndex(indexContext:IndexContext):Unit = (
		new MemberCallGenerationRuleTemplate(bytecodeGenerationContext, indexContext)
			with IndexGenerationRuleMixin
	)
		.enter()

	override def exitIndex(indexContext:IndexContext):Unit = (
		new MemberCallGenerationRuleTemplate(bytecodeGenerationContext, indexContext)
			with IndexGenerationRuleMixin
	)
		.exit()

	override def enterAssignIndex(assignIndexContext:AssignIndexContext):Unit = (
		new MemberCallGenerationRuleTemplate(bytecodeGenerationContext, assignIndexContext)
			with AssignIndexGenerationRuleMixin
	)
		.enter()

	override def exitAssignIndex(assignIndexContext:AssignIndexContext):Unit = (
		new MemberCallGenerationRuleTemplate(bytecodeGenerationContext, assignIndexContext)
			with AssignIndexGenerationRuleMixin
	)
		.exit()

	override def enterMemberAccessor(memberAccessorContext:MemberAccessorContext):Unit =
		MemberAccessorGenerationRule.enter(bytecodeGenerationContext, memberAccessorContext)

	override def exitMemberAccessor(memberAccessorContext:MemberAccessorContext):Unit =
		MemberAccessorGenerationRule.exit(bytecodeGenerationContext, memberAccessorContext)

	override def enterAssignMemberAccessor(assignMemberAccessorContext:AssignMemberAccessorContext):Unit =
		AssignMemberAccessorGenerationRule.enter(bytecodeGenerationContext, assignMemberAccessorContext)

	override def exitAssignMemberAccessor(assignMemberAccessorContext:AssignMemberAccessorContext):Unit =
		AssignMemberAccessorGenerationRule.exit(bytecodeGenerationContext, assignMemberAccessorContext)

	override def enterCall(ruleContext:CallContext):Unit =
		CallGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitCall(ruleContext:CallContext):Unit =
		CallGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterMemberCall(memberCallContext:MemberCallContext):Unit = (
		new MemberCallGenerationRuleTemplate(bytecodeGenerationContext, memberCallContext)
			with MemberCallGenerationRuleMixin
	)
		.enter()

	override def exitMemberCall(memberCallContext:MemberCallContext):Unit = (
		new MemberCallGenerationRuleTemplate(bytecodeGenerationContext, memberCallContext)
			with MemberCallGenerationRuleMixin
	)
		.exit()

	override def enterVariableOrParameter(ruleContext:VariableOrParameterContext):Unit =
		VariableOrParameterGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitVariableOrParameter(ruleContext:VariableOrParameterContext):Unit =
		VariableOrParameterGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterSuperHostMember(ruleContext:SuperHostMemberContext):Unit =
		SuperHostMemberGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitSuperHostMember(ruleContext:SuperHostMemberContext):Unit =
		SuperHostMemberGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterHostMember(ruleContext:HostMemberContext):Unit =
		HostMemberGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitHostMember(ruleContext:HostMemberContext):Unit =
		HostMemberGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterMember(ruleContext:MemberContext):Unit =
		MemberGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitMember(ruleContext:MemberContext):Unit =
		MemberGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterAssignVariable(ruleContext:AssignVariableContext):Unit =
		AssignVariableGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitAssignVariable(ruleContext:AssignVariableContext):Unit =
		AssignVariableGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterAssignHostMember(ruleContext:AssignHostMemberContext):Unit =
		AssignHostMemberGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitAssignHostMember(ruleContext:AssignHostMemberContext):Unit =
		AssignHostMemberGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterAssignMember(ruleContext:AssignMemberContext):Unit =
		AssignMemberGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitAssignMember(ruleContext:AssignMemberContext):Unit =
		AssignMemberGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterHost(ruleContext:HostContext):Unit =
		HostGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitHost(ruleContext:HostContext):Unit =
		HostGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterThis(ruleContext:ThisContext):Unit =
		ThisGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitThis(ruleContext:ThisContext):Unit =
		ThisGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def enterString(ruleContext:StringContext):Unit =
		StringGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitString(ruleContext:StringContext):Unit =
		StringGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterNumber(ruleContext:NumberContext):Unit =
		NumberGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitNumber(ruleContext:NumberContext):Unit =
		NumberGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterUnaryOperation(unaryOperationContext:UnaryOperationContext):Unit = (
		new MemberCallGenerationRuleTemplate(bytecodeGenerationContext, unaryOperationContext)
			with UnaryOperationGenerationRuleMixin
	)
		.enter()

	override def exitUnaryOperation(unaryOperationContext:UnaryOperationContext):Unit =	(
		new MemberCallGenerationRuleTemplate(bytecodeGenerationContext, unaryOperationContext)
			with UnaryOperationGenerationRuleMixin
	)
		.exit()

	override def enterMulDiv(mulDivContext:MulDivContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](bytecodeGenerationContext, mulDivContext)
			with OperatorGenerationRuleMixin
	)
		.enter()

	override def exitMulDiv(mulDivContext:MulDivContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](bytecodeGenerationContext, mulDivContext)
			with OperatorGenerationRuleMixin
	)
		.exit()

	override def enterAddSub(addSubContext:AddSubContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](bytecodeGenerationContext, addSubContext)
			with OperatorGenerationRuleMixin
	)
		.enter()
	
	override def exitAddSub(addSubContext:AddSubContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](bytecodeGenerationContext, addSubContext)
			with OperatorGenerationRuleMixin
	)
		.exit()

	override def enterEqNeq(eqNeqContext:EqNeqContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](bytecodeGenerationContext, eqNeqContext)
			with OperatorGenerationRuleMixin
	)
		.enter()
	
	override def exitEqNeq(eqNeqContext:EqNeqContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](bytecodeGenerationContext, eqNeqContext)
			with OperatorGenerationRuleMixin
	)
		.exit()

	override def enterGteLteGtLt(gteLteGtLtContext:GteLteGtLtContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](bytecodeGenerationContext, gteLteGtLtContext)
			with OperatorGenerationRuleMixin
	)
		.enter()
	
	override def exitGteLteGtLt(gteLteGtLtContext:GteLteGtLtContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](bytecodeGenerationContext, gteLteGtLtContext)
			with OperatorGenerationRuleMixin
	)
		.exit()

	override def enterAmpersandAmpersand(ampersandAmpersandContext:AmpersandAmpersandContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](
			bytecodeGenerationContext, ampersandAmpersandContext
		)
			with OperatorGenerationRuleMixin
	)
		.enter()
	
	override def exitAmpersandAmpersand(ampersandAmpersandContext:AmpersandAmpersandContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](
			bytecodeGenerationContext, ampersandAmpersandContext
		)
			with OperatorGenerationRuleMixin
	)
		.exit()

	override def enterPipePipe(pipePipeContext:PipePipeContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](bytecodeGenerationContext, pipePipeContext)
			with OperatorGenerationRuleMixin
	)
		.enter()
	
	override def exitPipePipe(pipePipeContext:PipePipeContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](bytecodeGenerationContext, pipePipeContext)
			with OperatorGenerationRuleMixin
	)
		.exit()

	override def enterIfElse(ruleContext:IfElseContext):Unit = 
		IfElseGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitIfElse(ruleContext:IfElseContext):Unit = 
		IfElseGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterWhile(ruleContext:WhileContext):Unit = 
		WhileGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitWhile(ruleContext:WhileContext):Unit =
		WhileGenerationRule.exit(bytecodeGenerationContext, ruleContext)

	override def enterInheritance(ruleContext:InheritanceContext):Unit =
		InheritanceGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitInheritance(ruleContext:InheritanceContext):Unit = 
		InheritanceGenerationRule.exit(bytecodeGenerationContext, ruleContext)
}