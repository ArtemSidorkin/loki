package loki.language.generation.java

import loki.language.generation.Generator
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.java.rule._
import loki.language.generation.java.rule.template.{ContainerGenerationJavaRuleTemplate, MemberCallGenerationJavaRuleTemplate}
import loki.language.generation.rule.mixin._
import loki.language.parsing.LokiParser._

class JavaGenerator(moduleName:String) extends Generator[JavaGenerationContext]
{
	private implicit val javaGenerationContext = new JavaGenerationContext(moduleName, classLoader) //if it is implicit, this should be used



	override def enterModule(ruleContext:ModuleContext):Unit =
		ModuleGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitModule(ruleContext:ModuleContext):Unit =
		ModuleGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterInstruction(ruleContext:InstructionContext):Unit =
		InstructionGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitInstruction(ruleContext:InstructionContext):Unit =
		InstructionGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterExpressionGroup(ruleContext:ExpressionGroupContext):Unit =
		new GenerationJavaRule[ExpressionGroupContext](javaGenerationContext, ruleContext).enter()

	override def exitExpressionGroup(ruleContext:ExpressionGroupContext):Unit =
		new GenerationJavaRule[ExpressionGroupContext](javaGenerationContext, ruleContext).exit()



	override def enterUnit(ruleContext:UnitContext):Unit =
		UnitGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitUnit(ruleContext:UnitContext):Unit =
		UnitGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterArray(arrayContext:ArrayContext):Unit =
		(new ContainerGenerationJavaRuleTemplate(javaGenerationContext, arrayContext) with ArrayGenerationRuleMixin)
			.enter()

	override def exitArray(arrayContext:ArrayContext):Unit =
		(new ContainerGenerationJavaRuleTemplate(javaGenerationContext, arrayContext) with ArrayGenerationRuleMixin)
			.exit()



	override def enterMap(mapContext:MapContext):Unit =
		(new ContainerGenerationJavaRuleTemplate(javaGenerationContext, mapContext) with MapGenerationRuleMixin).enter()

	override def exitMap(mapContext:MapContext):Unit =
		(new ContainerGenerationJavaRuleTemplate(javaGenerationContext, mapContext) with MapGenerationRuleMixin).exit()



	override def enterObject(objectContext:ObjectContext):Unit =
		(new ContainerGenerationJavaRuleTemplate(javaGenerationContext, objectContext) with ObjectGenerationRuleMixin)
			.enter()

	override def exitObject(objectContext:ObjectContext):Unit =
		(new ContainerGenerationJavaRuleTemplate(javaGenerationContext, objectContext) with ObjectGenerationRuleMixin)
			.exit()



	override def enterIndex(indexContext:IndexContext):Unit =
		(new MemberCallGenerationJavaRuleTemplate(javaGenerationContext, indexContext) with IndexGenerationRuleMixin)
			.enter()

	override def exitIndex(indexContext:IndexContext):Unit =
		(new MemberCallGenerationJavaRuleTemplate(javaGenerationContext, indexContext) with IndexGenerationRuleMixin)
			.exit()



	override def enterAssignIndex(assignIndexContext:AssignIndexContext):Unit = (
		new MemberCallGenerationJavaRuleTemplate(javaGenerationContext, assignIndexContext)
			with AssignIndexGenerationRuleMixin
	)
		.enter()

	override def exitAssignIndex(assignIndexContext:AssignIndexContext):Unit = (
		new MemberCallGenerationJavaRuleTemplate(javaGenerationContext, assignIndexContext)
			with AssignIndexGenerationRuleMixin
	)
		.exit()



	override def enterMemberAccessor(memberAccessorContext:MemberAccessorContext):Unit =
		new MemberAccessorGenerationJavaRule(javaGenerationContext, memberAccessorContext).enter()

	override def exitMemberAccessor(memberAccessorContext:MemberAccessorContext):Unit =
		new MemberAccessorGenerationJavaRule(javaGenerationContext, memberAccessorContext).exit()



	override def enterAssignMemberAccessor(assignMemberAccessorContext:AssignMemberAccessorContext):Unit =
		new AssignMemberAccessorGenerationJavaRule(javaGenerationContext, assignMemberAccessorContext).enter()

	override def exitAssignMemberAccessor(assignMemberAccessorContext:AssignMemberAccessorContext):Unit =
		new AssignMemberAccessorGenerationJavaRule(javaGenerationContext, assignMemberAccessorContext).exit()



	override def enterCall(ruleContext:CallContext):Unit =
		CallGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitCall(ruleContext:CallContext):Unit =
		CallGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterMemberCall(memberCallContext:MemberCallContext):Unit = (
		new MemberCallGenerationJavaRuleTemplate(javaGenerationContext, memberCallContext)
			with MemberCallGenerationRuleMixin
	)
		.enter()

	override def exitMemberCall(memberCallContext:MemberCallContext):Unit = (
		new MemberCallGenerationJavaRuleTemplate(javaGenerationContext, memberCallContext)
			with MemberCallGenerationRuleMixin
	)
		.exit()



	override def enterVariableOrParameter(ruleContext:VariableOrParameterContext):Unit =
		VariableOrParameterGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitVariableOrParameter(ruleContext:VariableOrParameterContext):Unit =
		VariableOrParameterGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterSuperHostMember(ruleContext:SuperHostMemberContext):Unit =
		SuperHostMemberGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitSuperHostMember(ruleContext:SuperHostMemberContext):Unit =
		SuperHostMemberGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterHostMember(ruleContext:HostMemberContext):Unit =
		HostMemberGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitHostMember(ruleContext:HostMemberContext):Unit =
		HostMemberGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterMember(ruleContext:MemberContext):Unit =
		MemberGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitMember(ruleContext:MemberContext):Unit =
		MemberGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterAssignVariable(ruleContext:AssignVariableContext):Unit =
		AssignVariableGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitAssignVariable(ruleContext:AssignVariableContext):Unit =
		AssignVariableGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterAssignHostMember(ruleContext:AssignHostMemberContext):Unit =
		AssignHostMemberGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitAssignHostMember(ruleContext:AssignHostMemberContext):Unit =
		AssignHostMemberGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterAssignMember(ruleContext:AssignMemberContext):Unit =
		AssignMemberGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitAssignMember(ruleContext:AssignMemberContext):Unit =
		AssignMemberGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterHost(ruleContext:HostContext):Unit =
		HostGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitHost(ruleContext:HostContext):Unit =
		HostGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterThis(ruleContext:ThisContext):Unit =
		ThisGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitThis(ruleContext:ThisContext):Unit =
		ThisGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterString(ruleContext:StringContext):Unit =
		new StringGenerationJavaRule(javaGenerationContext, ruleContext).enter()

	override def exitString(ruleContext:StringContext):Unit =
		new StringGenerationJavaRule(javaGenerationContext, ruleContext).exit()



	override def enterNumber(ruleContext:NumberContext):Unit =
		NumberGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitNumber(ruleContext:NumberContext):Unit =
		NumberGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterUnaryOperation(unaryOperationContext:UnaryOperationContext):Unit = (
		new MemberCallGenerationJavaRuleTemplate(javaGenerationContext, unaryOperationContext)
			with UnaryOperationGenerationRuleMixin
	)
		.enter()

	override def exitUnaryOperation(unaryOperationContext:UnaryOperationContext):Unit = (
		new MemberCallGenerationJavaRuleTemplate(javaGenerationContext, unaryOperationContext)
			with UnaryOperationGenerationRuleMixin
	)
		.exit()



	override def enterMulDiv(mulDivContext:MulDivContext):Unit = (
		new MemberCallGenerationJavaRuleTemplate[ExpressionContext](javaGenerationContext, mulDivContext)
			with OperatorGenerationRuleMixin
	)
		.enter()

	override def exitMulDiv(mulDivContext:MulDivContext):Unit =	(
		new MemberCallGenerationJavaRuleTemplate[ExpressionContext](javaGenerationContext, mulDivContext)
			with OperatorGenerationRuleMixin
	).exit()



	override def enterAddSub(addSubContext:AddSubContext):Unit = (
		new MemberCallGenerationJavaRuleTemplate[ExpressionContext](javaGenerationContext, addSubContext)
			with OperatorGenerationRuleMixin
	)
		.enter()

	override def exitAddSub(addSubContext:AddSubContext):Unit =	(
		new MemberCallGenerationJavaRuleTemplate[ExpressionContext](javaGenerationContext, addSubContext)
			with OperatorGenerationRuleMixin
	)
		.exit()



	override def enterEqNeq(eqNeqContext:EqNeqContext):Unit = (
		new MemberCallGenerationJavaRuleTemplate[ExpressionContext](javaGenerationContext, eqNeqContext)
			with OperatorGenerationRuleMixin
	)
		.enter()

	override def exitEqNeq(eqNeqContext:EqNeqContext):Unit =	(
		new MemberCallGenerationJavaRuleTemplate[ExpressionContext](javaGenerationContext, eqNeqContext)
			with OperatorGenerationRuleMixin
	)
		.exit()



	override def enterGteLteGtLt(gteLteGtLtContext:GteLteGtLtContext):Unit = (
		new MemberCallGenerationJavaRuleTemplate[ExpressionContext](javaGenerationContext, gteLteGtLtContext)
			with OperatorGenerationRuleMixin
	)
		.enter()

	override def exitGteLteGtLt(gteLteGtLtContext:GteLteGtLtContext):Unit =	(
		new MemberCallGenerationJavaRuleTemplate[ExpressionContext](javaGenerationContext, gteLteGtLtContext)
			with OperatorGenerationRuleMixin
	).exit()



	override def enterAmpersandAmpersand(ampersandAmpersandContext:AmpersandAmpersandContext):Unit = (
		new MemberCallGenerationJavaRuleTemplate[ExpressionContext](javaGenerationContext, ampersandAmpersandContext)
			with OperatorGenerationRuleMixin
	)
		.enter()

	override def exitAmpersandAmpersand(ampersandAmpersandContext:AmpersandAmpersandContext):Unit = (
		new MemberCallGenerationJavaRuleTemplate[ExpressionContext](javaGenerationContext, ampersandAmpersandContext)
			with OperatorGenerationRuleMixin
	)
		.exit()



	override def enterPipePipe(pipePipeContext:PipePipeContext):Unit = (
		new MemberCallGenerationJavaRuleTemplate[ExpressionContext](javaGenerationContext, pipePipeContext)
			with OperatorGenerationRuleMixin
	)
		.enter()

	override def exitPipePipe(pipePipeContext:PipePipeContext):Unit = (
		new MemberCallGenerationJavaRuleTemplate[ExpressionContext](javaGenerationContext, pipePipeContext)
			with OperatorGenerationRuleMixin
	)
		.exit()



	override def enterIfElse(ruleContext:IfElseContext):Unit =
		IfElseGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitIfElse(ruleContext:IfElseContext):Unit =
		IfElseGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterWhile(ruleContext:WhileContext):Unit =
		WhileGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitWhile(ruleContext:WhileContext):Unit =
		WhileGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterInheritance(ruleContext:InheritanceContext):Unit =
		InheritanceGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitInheritance(ruleContext:InheritanceContext):Unit =
		InheritanceGenerationJavaRule.exit(javaGenerationContext, ruleContext)
}