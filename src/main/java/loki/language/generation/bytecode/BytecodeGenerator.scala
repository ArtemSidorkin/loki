package loki.language.generation.bytecode

import loki.language.generation.Generator
import loki.language.generation.bytecode.BytecodeGeneration.BytecodeGenerationContext
import loki.language.generation.bytecode.rule._
import loki.language.generation.bytecode.rule.template.{ContainerGenerationBytecodeRuleTemplate, MemberCallBytecodeGenerationRuleTemplate}
import loki.language.generation.rule.mixin.{AssignIndexGenerationRuleMixin, _}
import loki.language.parsing.LokiParser._

class BytecodeGenerator(moduleName:String) extends Generator[BytecodeGenerationContext]
{
	private implicit val bytecodeGenerationContext = new BytecodeGenerationContext(moduleName, classLoader)



	override def enterModule(ruleContext:ModuleContext):Unit =
		ModuleBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitModule(ruleContext:ModuleContext):Unit =
		ModuleBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterInstruction(ruleContext:InstructionContext):Unit =
		InstructionBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitInstruction(ruleContext:InstructionContext):Unit =
		InstructionBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterExpressionGroup(ruleContext:ExpressionGroupContext):Unit =
		new BytecodeGenerationRule[ExpressionGroupContext](bytecodeGenerationContext, ruleContext).enter()

	override def exitExpressionGroup(ruleContext:ExpressionGroupContext):Unit =
		new BytecodeGenerationRule[ExpressionGroupContext](bytecodeGenerationContext, ruleContext).exit()



	override def enterUnit(ruleContext:UnitContext):Unit =
		UnitBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitUnit(ruleContext:UnitContext):Unit =
		UnitBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterArray(arrayContext:ArrayContext):Unit = (
		new ContainerGenerationBytecodeRuleTemplate(bytecodeGenerationContext, arrayContext)
			with ArrayGenerationRuleMixin
	)
		.enter()

	override def exitArray(arrayContext:ArrayContext):Unit = (
		new ContainerGenerationBytecodeRuleTemplate(bytecodeGenerationContext, arrayContext)
			with ArrayGenerationRuleMixin
	)
		.exit()



	override def enterMap(mapContext:MapContext):Unit =
		(new ContainerGenerationBytecodeRuleTemplate(bytecodeGenerationContext, mapContext)	with MapGenerationRuleMixin)
			.enter()

	override def exitMap(mapContext:MapContext):Unit =
		(new ContainerGenerationBytecodeRuleTemplate(bytecodeGenerationContext, mapContext)	with MapGenerationRuleMixin)
			.exit()



	override def enterObject(objectContext:ObjectContext):Unit = (
		new ContainerGenerationBytecodeRuleTemplate(bytecodeGenerationContext, objectContext)
			with ObjectGenerationRuleMixin
	)
		.enter()

	override def exitObject(objectContext:ObjectContext):Unit =	(
		new ContainerGenerationBytecodeRuleTemplate(bytecodeGenerationContext, objectContext)
			with ObjectGenerationRuleMixin
	)
		.exit()



	override def enterIndex(indexContext:IndexContext):Unit = (
		new MemberCallBytecodeGenerationRuleTemplate(bytecodeGenerationContext, indexContext)
			with IndexGenerationRuleMixin
	)
		.enter()

	override def exitIndex(indexContext:IndexContext):Unit = (
		new MemberCallBytecodeGenerationRuleTemplate(bytecodeGenerationContext, indexContext)
			with IndexGenerationRuleMixin
	)
		.exit()



	override def enterAssignIndex(assignIndexContext:AssignIndexContext):Unit = (
		new MemberCallBytecodeGenerationRuleTemplate(bytecodeGenerationContext, assignIndexContext)
			with AssignIndexGenerationRuleMixin
	)
		.enter()

	override def exitAssignIndex(assignIndexContext:AssignIndexContext):Unit = (
		new MemberCallBytecodeGenerationRuleTemplate(bytecodeGenerationContext, assignIndexContext)
			with AssignIndexGenerationRuleMixin
	)
		.exit()



	override def enterMemberAccessor(memberAccessorContext:MemberAccessorContext):Unit =
		new MemberAccessorBytecodeGenerationRule(bytecodeGenerationContext, memberAccessorContext).enter()

	override def exitMemberAccessor(memberAccessorContext:MemberAccessorContext):Unit =
		new MemberAccessorBytecodeGenerationRule(bytecodeGenerationContext, memberAccessorContext).exit()



	override def enterAssignMemberAccessor(assignMemberAccessorContext:AssignMemberAccessorContext):Unit =
		new AssignMemberAccessorBytecodeGenerationRule(bytecodeGenerationContext, assignMemberAccessorContext).enter()

	override def exitAssignMemberAccessor(assignMemberAccessorContext:AssignMemberAccessorContext):Unit =
		new AssignMemberAccessorBytecodeGenerationRule(bytecodeGenerationContext, assignMemberAccessorContext).exit()



	override def enterCall(ruleContext:CallContext):Unit =
		CallBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitCall(ruleContext:CallContext):Unit =
		CallBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterMemberCall(memberCallContext:MemberCallContext):Unit = (
		new MemberCallBytecodeGenerationRuleTemplate(bytecodeGenerationContext, memberCallContext)
			with MemberCallGenerationRuleMixin
	)
		.enter()

	override def exitMemberCall(memberCallContext:MemberCallContext):Unit = (
		new MemberCallBytecodeGenerationRuleTemplate(bytecodeGenerationContext, memberCallContext)
			with MemberCallGenerationRuleMixin
	)
		.exit()


	override def enterVariableOrParameter(ruleContext:VariableOrParameterContext):Unit =
		VariableOrParameterBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitVariableOrParameter(ruleContext:VariableOrParameterContext):Unit =
		VariableOrParameterBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterSuperHostMember(ruleContext:SuperHostMemberContext):Unit =
		SuperHostMemberBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitSuperHostMember(ruleContext:SuperHostMemberContext):Unit =
		SuperHostMemberBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterHostMember(ruleContext:HostMemberContext):Unit =
		HostMemberBytecodeGenerationRuleHostMember.enter(bytecodeGenerationContext, ruleContext)

	override def exitHostMember(ruleContext:HostMemberContext):Unit =
		HostMemberBytecodeGenerationRuleHostMember.exit(bytecodeGenerationContext, ruleContext)



	override def enterMember(ruleContext:MemberContext):Unit =
		MemberBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitMember(ruleContext:MemberContext):Unit =
		MemberBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterAssignVariable(ruleContext:AssignVariableContext):Unit =
		AssignVariableBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitAssignVariable(ruleContext:AssignVariableContext):Unit =
		AssignVariableBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterAssignHostMember(ruleContext:AssignHostMemberContext):Unit =
		AssignHostMemberBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitAssignHostMember(ruleContext:AssignHostMemberContext):Unit =
		AssignHostMemberBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterAssignMember(ruleContext:AssignMemberContext):Unit =
		AssignMemberBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitAssignMember(ruleContext:AssignMemberContext):Unit =
		AssignMemberBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterHost(ruleContext:HostContext):Unit =
		HostBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitHost(ruleContext:HostContext):Unit =
		HostBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterThis(ruleContext:ThisContext):Unit =
		ThisBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitThis(ruleContext:ThisContext):Unit =
		ThisBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)



	override def enterString(ruleContext:StringContext):Unit =
		new StringBytecodeGenerationRule(bytecodeGenerationContext, ruleContext).enter()

	override def exitString(ruleContext:StringContext):Unit =
		new StringBytecodeGenerationRule(bytecodeGenerationContext, ruleContext).exit()



	override def enterNumber(ruleContext:NumberContext):Unit =
		NumberBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitNumber(ruleContext:NumberContext):Unit =
		NumberBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterUnaryOperation(unaryOperationContext:UnaryOperationContext):Unit = (
		new MemberCallBytecodeGenerationRuleTemplate(bytecodeGenerationContext, unaryOperationContext)
			with UnaryOperationGenerationRuleMixin
	)
		.enter()

	override def exitUnaryOperation(unaryOperationContext:UnaryOperationContext):Unit =	(
		new MemberCallBytecodeGenerationRuleTemplate(bytecodeGenerationContext, unaryOperationContext)
			with UnaryOperationGenerationRuleMixin
	)
		.exit()



	override def enterMulDiv(ruleContext:MulDivContext):Unit =
		OperatorBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitMulDiv(ruleContext:MulDivContext):Unit =
		OperatorBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterAddSub(ruleContext:AddSubContext):Unit =
		OperatorBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitAddSub(ruleContext:AddSubContext):Unit =
		OperatorBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterEqNeq(ruleContext:EqNeqContext):Unit = 
		OperatorBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitEqNeq(ruleContext:EqNeqContext):Unit = 
		OperatorBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterGteLteGtLt(ruleContext:GteLteGtLtContext):Unit = 
		OperatorBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitGteLteGtLt(ruleContext:GteLteGtLtContext):Unit = 
		OperatorBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterAmpersandAmpersand(ruleContext:AmpersandAmpersandContext):Unit = 
		OperatorBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitAmpersandAmpersand(ruleContext:AmpersandAmpersandContext):Unit = 
		OperatorBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterPipePipe(ruleContext:PipePipeContext):Unit = 
		OperatorBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitPipePipe(ruleContext:PipePipeContext):Unit = 
		OperatorBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterIfElse(ruleContext:IfElseContext):Unit = 
		IfElseBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitIfElse(ruleContext:IfElseContext):Unit = 
		IfElseBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterWhile(ruleContext:WhileContext):Unit = 
		WhileBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)
	
	override def exitWhile(ruleContext:WhileContext):Unit =
		WhileBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)



	override def enterInheritance(ruleContext:InheritanceContext):Unit =
		InheritanceBytecodeGenerationRule.enter(bytecodeGenerationContext, ruleContext)

	override def exitInheritance(ruleContext:InheritanceContext):Unit = 
		InheritanceBytecodeGenerationRule.exit(bytecodeGenerationContext, ruleContext)
}