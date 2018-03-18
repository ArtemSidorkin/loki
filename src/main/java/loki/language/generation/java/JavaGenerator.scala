package loki.language.generation.java

import loki.language.generation.Generator
import loki.language.generation.java.JavaGeneration.JavaGenerationContext
import loki.language.generation.java.rule._
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



	override def enterArray(ruleContext:ArrayContext):Unit =
		ArrayGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitArray(ruleContext:ArrayContext):Unit =
		ArrayGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterMap(ruleContext:MapContext):Unit = MapGenerationJavaRule.enter(javaGenerationContext, ruleContext)
	override def exitMap(ruleContext:MapContext):Unit = MapGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterObject(ruleContext:ObjectContext):Unit =
		new ObjectGenerationJavaRule(javaGenerationContext, ruleContext).enter()

	override def exitObject(ruleContext:ObjectContext):Unit =
		new ObjectGenerationJavaRule(javaGenerationContext, ruleContext).exit()



	override def enterIndex(ruleContext:IndexContext):Unit =
		IndexGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitIndex(ruleContext:IndexContext):Unit =
		IndexGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterAssignIndex(ruleContext:AssignIndexContext):Unit =
		AssignIndexGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitAssignIndex(ruleContext:AssignIndexContext):Unit =
		AssignIndexGenerationJavaRule.exit(javaGenerationContext, ruleContext)



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



	override def enterMemberCall(ruleContext:MemberCallContext):Unit =
		MemberCallGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitMemberCall(ruleContext:MemberCallContext):Unit =
		MemberCallGenerationJavaRule.exit(javaGenerationContext, ruleContext)



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



	override def enterUnaryOperation(ruleContext:UnaryOperationContext):Unit =
		UnaryOperationGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitUnaryOperation(ruleContext:UnaryOperationContext):Unit =
		UnaryOperationGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterMulDiv(ruleContext:MulDivContext):Unit =
		OperatorGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitMulDiv(ruleContext:MulDivContext):Unit =
		OperatorGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterAddSub(ruleContext:AddSubContext):Unit =
		OperatorGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitAddSub(ruleContext:AddSubContext):Unit =
		OperatorGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterEqNeq(ruleContext:EqNeqContext):Unit =
		OperatorGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitEqNeq(ruleContext:EqNeqContext):Unit =
		OperatorGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterGteLteGtLt(ruleContext:GteLteGtLtContext):Unit =
		OperatorGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitGteLteGtLt(ruleContext:GteLteGtLtContext):Unit =
		OperatorGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterAmpersandAmpersand(ruleContext:AmpersandAmpersandContext):Unit =
		OperatorGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitAmpersandAmpersand(ruleContext:AmpersandAmpersandContext):Unit =
		OperatorGenerationJavaRule.exit(javaGenerationContext, ruleContext)



	override def enterPipePipe(ruleContext:PipePipeContext):Unit =
		OperatorGenerationJavaRule.enter(javaGenerationContext, ruleContext)

	override def exitPipePipe(ruleContext:PipePipeContext):Unit =
		OperatorGenerationJavaRule.exit(javaGenerationContext, ruleContext)



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