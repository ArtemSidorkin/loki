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

	private implicit val generationContext = new GenerationContext(moduleName, classLoader)

	override def visitErrorNode(errorNode:ErrorNode):Unit = throw new IllegalStateException

	override def enterModule(moduleContext:ModuleContext):Unit =
		ModuleGenerationRule.enter(generationContext, moduleContext)

	override def exitModule(moduleContext:ModuleContext):Unit =
		ModuleGenerationRule.exit(generationContext, moduleContext)

	override def enterInstruction(instructionContext:InstructionContext):Unit =
		InstructionGenerationRule.enter(generationContext, instructionContext)

	override def exitInstruction(instructionContext:InstructionContext):Unit =
		InstructionGenerationRule.exit(generationContext, instructionContext)

	override def enterExpressionGroup(expressionGroupContext:ExpressionGroupContext):Unit =
		GenerationRule.enter(generationContext, expressionGroupContext)

	override def exitExpressionGroup(expressionGroupContext:ExpressionGroupContext):Unit =
		GenerationRule.exit(generationContext, expressionGroupContext)

	override def enterUnit(unitContext:UnitContext):Unit = UnitGenerationRule.enter(generationContext, unitContext)
	override def exitUnit(unitContext:UnitContext):Unit = UnitGenerationRule.exit(generationContext, unitContext)

	override def enterArray(arrayContext:ArrayContext):Unit = (
		new ContainerGenerationRuleTemplate(generationContext, arrayContext) with ArrayGenerationRuleMixin
	)
		.enter()

	override def exitArray(arrayContext:ArrayContext):Unit = (
		new ContainerGenerationRuleTemplate(generationContext, arrayContext) with ArrayGenerationRuleMixin
	)
		.exit()

	override def enterMap(mapContext:MapContext):Unit =	(
		new ContainerGenerationRuleTemplate(generationContext, mapContext)	with MapGenerationRuleMixin
	)
		.enter()

	override def exitMap(mapContext:MapContext):Unit = (
		new ContainerGenerationRuleTemplate(generationContext, mapContext)	with MapGenerationRuleMixin
	)
		.exit()

	override def enterObject(objectContext:ObjectContext):Unit = (
		new ContainerGenerationRuleTemplate(generationContext, objectContext) with ObjectGenerationRuleMixin
	)
		.enter()

	override def exitObject(objectContext:ObjectContext):Unit =	(
		new ContainerGenerationRuleTemplate(generationContext, objectContext) with ObjectGenerationRuleMixin
	)
		.exit()

	override def enterIndex(indexContext:IndexContext):Unit = (
		new MemberCallGenerationRuleTemplate(generationContext, indexContext) with IndexGenerationRuleMixin
	)
		.enter()

	override def exitIndex(indexContext:IndexContext):Unit = (
		new MemberCallGenerationRuleTemplate(generationContext, indexContext) with IndexGenerationRuleMixin
	)
		.exit()

	override def enterAssignIndex(assignIndexContext:AssignIndexContext):Unit = (
		new MemberCallGenerationRuleTemplate(generationContext, assignIndexContext) with AssignIndexGenerationRuleMixin
	)
		.enter()

	override def exitAssignIndex(assignIndexContext:AssignIndexContext):Unit = (
		new MemberCallGenerationRuleTemplate(generationContext, assignIndexContext) with AssignIndexGenerationRuleMixin
	)
		.exit()

	override def enterMemberAccessor(memberAccessorContext:MemberAccessorContext):Unit =
		MemberAccessorGenerationRule.enter(generationContext, memberAccessorContext)

	override def exitMemberAccessor(memberAccessorContext:MemberAccessorContext):Unit =
		MemberAccessorGenerationRule.exit(generationContext, memberAccessorContext)

	override def enterAssignMemberAccessor(assignMemberAccessorContext:AssignMemberAccessorContext):Unit =
		AssignMemberAccessorGenerationRule.enter(generationContext, assignMemberAccessorContext)

	override def exitAssignMemberAccessor(assignMemberAccessorContext:AssignMemberAccessorContext):Unit =
		AssignMemberAccessorGenerationRule.exit(generationContext, assignMemberAccessorContext)

	override def enterCall(callContext:CallContext):Unit = CallGenerationRule.enter(generationContext, callContext)
	override def exitCall(callContext:CallContext):Unit = CallGenerationRule.exit(generationContext, callContext)

	override def enterMemberCall(memberCallContext:MemberCallContext):Unit = (
		new MemberCallGenerationRuleTemplate(generationContext, memberCallContext) with MemberCallGenerationRuleMixin
	)
		.enter()

	override def exitMemberCall(memberCallContext:MemberCallContext):Unit = (
		new MemberCallGenerationRuleTemplate(generationContext, memberCallContext) with MemberCallGenerationRuleMixin
	)
		.exit()

	override def enterVariableOrParameter(variableOrParameterContext:VariableOrParameterContext):Unit =
		VariableOrParameterGenerationRule.enter(generationContext, variableOrParameterContext)

	override def exitVariableOrParameter(variableOrParameterContext:VariableOrParameterContext):Unit =
		VariableOrParameterGenerationRule.exit(generationContext, variableOrParameterContext)

	override def enterSuperHostMember(superHostMemberContext:SuperHostMemberContext):Unit =
		SuperHostMemberGenerationRule.enter(generationContext, superHostMemberContext)

	override def exitSuperHostMember(superHostMemberContext:SuperHostMemberContext):Unit =
		SuperHostMemberGenerationRule.exit(generationContext, superHostMemberContext)

	override def enterHostMember(hostMemberContext:HostMemberContext):Unit =
		HostMemberGenerationRule.enter(generationContext, hostMemberContext)

	override def exitHostMember(hostMemberContext:HostMemberContext):Unit =
		HostMemberGenerationRule.exit(generationContext, hostMemberContext)

	override def enterMember(memberContext:MemberContext):Unit =
		MemberGenerationRule.enter(generationContext, memberContext)

	override def exitMember(memberContext:MemberContext):Unit =
		MemberGenerationRule.exit(generationContext, memberContext)

	override def enterAssignVariable(assignVariableContext:AssignVariableContext):Unit =
		AssignVariableGenerationRule.enter(generationContext, assignVariableContext)

	override def exitAssignVariable(assignVariableContext:AssignVariableContext):Unit =
		AssignVariableGenerationRule.exit(generationContext, assignVariableContext)

	override def enterAssignHostMember(assignHostMemberContext:AssignHostMemberContext):Unit =
		AssignHostMemberGenerationRule.enter(generationContext, assignHostMemberContext)

	override def exitAssignHostMember(assignHostMemberContext:AssignHostMemberContext):Unit =
		AssignHostMemberGenerationRule.exit(generationContext, assignHostMemberContext)

	override def enterAssignMember(assignMemberContext:AssignMemberContext):Unit =
		AssignMemberGenerationRule.enter(generationContext, assignMemberContext)

	override def exitAssignMember(assignMemberContext:AssignMemberContext):Unit =
		AssignMemberGenerationRule.exit(generationContext, assignMemberContext)

	override def enterHost(hostContext:HostContext):Unit = HostGenerationRule.enter(generationContext, hostContext)
	override def exitHost(hostContext:HostContext):Unit = HostGenerationRule.exit(generationContext, hostContext)

	override def enterThis(thisContext:ThisContext):Unit = ThisGenerationRule.enter(generationContext, thisContext)
	override def exitThis(thisContext:ThisContext):Unit = ThisGenerationRule.enter(generationContext, thisContext)

	override def enterString(stringContext:StringContext):Unit =
		StringGenerationRule.enter(generationContext, stringContext)

	override def exitString(stringContext:StringContext):Unit =
		StringGenerationRule.exit(generationContext, stringContext)

	override def enterNumber(numberContext:NumberContext):Unit =
		NumberGenerationRule.enter(generationContext, numberContext)

	override def exitNumber(numberContext:NumberContext):Unit =
		NumberGenerationRule.exit(generationContext, numberContext)

	override def enterUnaryOperation(unaryOperationContext:UnaryOperationContext):Unit = (
		new MemberCallGenerationRuleTemplate(generationContext, unaryOperationContext)
			with UnaryOperationGenerationRuleMixin
	)
		.enter()

	override def exitUnaryOperation(unaryOperationContext:UnaryOperationContext):Unit =	(
		new MemberCallGenerationRuleTemplate(generationContext, unaryOperationContext)
			with UnaryOperationGenerationRuleMixin
	)
		.exit()

	override def enterMulDiv(mulDivContext:MulDivContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](generationContext, mulDivContext)
			with OperatorGenerationRuleMixin
	)
		.enter()

	override def exitMulDiv(mulDivContext:MulDivContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](generationContext, mulDivContext)
			with OperatorGenerationRuleMixin
	)
		.exit()

	override def enterAddSub(addSubContext:AddSubContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](generationContext, addSubContext)
			with OperatorGenerationRuleMixin
	)
		.enter()
	
	override def exitAddSub(addSubContext:AddSubContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](generationContext, addSubContext)
			with OperatorGenerationRuleMixin
	)
		.exit()

	override def enterEqNeq(eqNeqContext:EqNeqContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](generationContext, eqNeqContext)
			with OperatorGenerationRuleMixin
	)
		.enter()
	
	override def exitEqNeq(eqNeqContext:EqNeqContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](generationContext, eqNeqContext)
			with OperatorGenerationRuleMixin
	)
		.exit()

	override def enterGteLteGtLt(gteLteGtLtContext:GteLteGtLtContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](generationContext, gteLteGtLtContext)
			with OperatorGenerationRuleMixin
	)
		.enter()
	
	override def exitGteLteGtLt(gteLteGtLtContext:GteLteGtLtContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](generationContext, gteLteGtLtContext)
			with OperatorGenerationRuleMixin
	)
		.exit()

	override def enterAmpersandAmpersand(ampersandAmpersandContext:AmpersandAmpersandContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](generationContext, ampersandAmpersandContext)
			with OperatorGenerationRuleMixin
	)
		.enter()
	
	override def exitAmpersandAmpersand(ampersandAmpersandContext:AmpersandAmpersandContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](generationContext, ampersandAmpersandContext)
			with OperatorGenerationRuleMixin
	)
		.exit()

	override def enterPipePipe(pipePipeContext:PipePipeContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](generationContext, pipePipeContext)
			with OperatorGenerationRuleMixin
	)
		.enter()
	
	override def exitPipePipe(pipePipeContext:PipePipeContext):Unit = (
		new MemberCallGenerationRuleTemplate[ExpressionContext](generationContext, pipePipeContext)
			with OperatorGenerationRuleMixin
	)
		.exit()

	override def enterIfElse(ifElseContext:IfElseContext):Unit =
		IfElseGenerationRule.enter(generationContext, ifElseContext)
	
	override def exitIfElse(ifElseContext:IfElseContext):Unit =
		IfElseGenerationRule.exit(generationContext, ifElseContext)

	override def enterWhile(whileContext:WhileContext):Unit = WhileGenerationRule.enter(generationContext, whileContext)
	override def exitWhile(whileContext:WhileContext):Unit = WhileGenerationRule.exit(generationContext, whileContext)

	override def enterInheritance(inheritanceContext:InheritanceContext):Unit =
		InheritanceGenerationRule.enter(generationContext, inheritanceContext)

	override def exitInheritance(inheritanceContext:InheritanceContext):Unit =
		InheritanceGenerationRule.exit(generationContext, inheritanceContext)
}