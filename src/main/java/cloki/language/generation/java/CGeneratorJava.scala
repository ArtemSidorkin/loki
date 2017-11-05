package cloki.language.generation.java

import cloki.language.generation.Generator
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.java.rules._
import cloki.language.parsing.LokiParser._

class CGeneratorJava(moduleName:String) extends Generator[CGenerationContextJava]
{
	protected implicit val generationContext = new CGenerationContextJava(moduleName, classLoader)

	override def enterModule(ruleContext:ModuleContext) = CRuleGenerationJavaModule.enter(ruleContext)
	override def exitModule(ruleContext:ModuleContext) = CRuleGenerationJavaModule.exit(ruleContext)

	override def enterInstruction(ruleContext:InstructionContext) = CRuleGenerationJavaInstruction.enter(ruleContext)
	override def exitInstruction(ruleContext:InstructionContext) = CRuleGenerationJavaInstruction.exit(ruleContext)

	override def enterExpressionGroup(ruleContext:ExpressionGroupContext) = CRuleGenerationJavaStub.enter(ruleContext)
	override def exitExpressionGroup(ruleContext:ExpressionGroupContext) = CRuleGenerationJavaStub.exit(ruleContext)

	override def enterUnit(ruleContext:UnitContext) = CRuleGenerationJavaUnit.enter(ruleContext)
	override def exitUnit(ruleContext:UnitContext) = CRuleGenerationJavaUnit.exit(ruleContext)

	override def enterArray(ruleContext:ArrayContext) = CRuleGenerationJavaArray.enter(ruleContext)
	override def exitArray(ruleContext:ArrayContext) = CRuleGenerationJavaArray.exit(ruleContext)

	override def enterIndex(ruleContext:IndexContext) = CRuleGenerationJavaIndex.enter(ruleContext)
	override def exitIndex(ruleContext:IndexContext) = CRuleGenerationJavaIndex.exit(ruleContext)

	override def enterAssignIndex(ruleContext:AssignIndexContext) = CRuleGenerationJavaAssignIndex.enter(ruleContext)
	override def exitAssignIndex(ruleContext:AssignIndexContext) = CRuleGenerationJavaAssignIndex.exit(ruleContext)

	override def enterCall(ruleContext:CallContext) = CRuleGenerationJavaCall.enter(ruleContext)
	override def exitCall(ruleContext:CallContext) = CRuleGenerationJavaCall.exit(ruleContext)

	override def enterMemberCall(ruleContext:MemberCallContext) = CRuleGenerationJavaMemberCall.enter(ruleContext)
	override def exitMemberCall(ruleContext:MemberCallContext) = CRuleGenerationJavaMemberCall.exit(ruleContext)

	override def enterVariableOrParameter(ruleContext:VariableOrParameterContext) =
		CRuleGenerationJavaVariableOrParameter.enter(ruleContext)

	override def exitVariableOrParameter(ruleContext:VariableOrParameterContext) =
		CRuleGenerationJavaVariableOrParameter.exit(ruleContext)

	override def enterSuperHostMember(ruleContext:SuperHostMemberContext) =
		CRuleGenerationJavaSuperHostMember.enter(ruleContext)

	override def exitSuperHostMember(ruleContext:SuperHostMemberContext) =
		CRuleGenerationJavaSuperHostMember.exit(ruleContext)

	override def enterHostMember(ruleContext:HostMemberContext) = CRuleGenerationJavaHostMember.enter(ruleContext)
	override def exitHostMember(ruleContext:HostMemberContext) = CRuleGenerationJavaHostMember.exit(ruleContext)

	override def enterMember(ruleContext:MemberContext) = CRuleGenerationJavaMember.enter(ruleContext)
	override def exitMember(ruleContext:MemberContext) = CRuleGenerationJavaMember.exit(ruleContext)

	override def enterAssignVariable(ruleContext:AssignVariableContext) =
		CRuleGenerationJavaAssignVariable.enter(ruleContext)

	override def exitAssignVariable(ruleContext:AssignVariableContext) =
		CRuleGenerationJavaAssignVariable.exit(ruleContext)

	override def enterAssignHostMember(ruleContext:AssignHostMemberContext) =
		CRuleGenerationJavaAssignHostMember.enter(ruleContext)

	override def exitAssignHostMember(ruleContext:AssignHostMemberContext) =
		CRuleGenerationJavaAssignHostMember.exit(ruleContext)

	override def enterAssignMember(ruleContext:AssignMemberContext) = CRuleGenerationJavaAssignMember.enter(ruleContext)
	override def exitAssignMember(ruleContext:AssignMemberContext) = CRuleGenerationJavaAssignMember.exit(ruleContext)

	override def enterHost(ruleContext:HostContext) = CRuleGenerationJavaHost.enter(ruleContext)
	override def exitHost(ruleContext:HostContext) = CRuleGenerationJavaHost.exit(ruleContext)

	override def enterThis(ruleContext:ThisContext) = CRuleGenerationJavaThis.enter(ruleContext)
	override def exitThis(ruleContext:ThisContext) = CRuleGenerationJavaThis.exit(ruleContext)

	override def enterString(ruleContext:StringContext) = CRuleGenerationJavaString.enter(ruleContext)
	override def exitString(ruleContext:StringContext) = CRuleGenerationJavaString.exit(ruleContext)

	override def enterNumber(ruleContext:NumberContext) = CRuleGenerationJavaNumber.enter(ruleContext)
	override def exitNumber(ruleContext:NumberContext) = CRuleGenerationJavaNumber.exit(ruleContext)

	override def enterUnaryOperation(ruleContext:UnaryOperationContext) = CRuleGenerationJavaUnaryOperation.enter(ruleContext)
	override def exitUnaryOperation(ruleContext:UnaryOperationContext) = CRuleGenerationJavaUnaryOperation.exit(ruleContext)

	override def enterMulDiv(ruleContext:MulDivContext) = CRuleGenerationJavaOperator.enter(ruleContext)
	override def exitMulDiv(ruleContext:MulDivContext) = CRuleGenerationJavaOperator.exit(ruleContext)

	override def enterAddSub(ruleContext:AddSubContext) = CRuleGenerationJavaOperator.enter(ruleContext)
	override def exitAddSub(ruleContext:AddSubContext) = CRuleGenerationJavaOperator.exit(ruleContext)

	override def enterEqNeq(ruleContext:EqNeqContext) = CRuleGenerationJavaOperator.enter(ruleContext)
	override def exitEqNeq(ruleContext:EqNeqContext) = CRuleGenerationJavaOperator.exit(ruleContext)

	override def enterGteLteGtLt(ruleContext:GteLteGtLtContext) = CRuleGenerationJavaOperator.enter(ruleContext)
	override def exitGteLteGtLt(ruleContext:GteLteGtLtContext) = CRuleGenerationJavaOperator.exit(ruleContext)

	override def enterAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = CRuleGenerationJavaOperator.enter(ruleContext)
	override def exitAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = CRuleGenerationJavaOperator.exit(ruleContext)

	override def enterPipePipe(ruleContext:PipePipeContext) = CRuleGenerationJavaOperator.enter(ruleContext)
	override def exitPipePipe(ruleContext:PipePipeContext) = CRuleGenerationJavaOperator.exit(ruleContext)

	override def enterIfElse(ruleContext:IfElseContext) = CRuleGenerationJavaIfElse.enter(ruleContext)
	override def exitIfElse(ruleContext:IfElseContext) = CRuleGenerationJavaIfElse.exit(ruleContext)

	override def enterWhile(ruleContext:WhileContext) = CRuleGenerationJavaWhile.enter(ruleContext)
	override def exitWhile(ruleContext:WhileContext) = CRuleGenerationJavaWhile.exit(ruleContext)

	override def enterInheritance(ruleContext:InheritanceContext) = CRuleGenerationJavaInheritance.enter(ruleContext)
	override def exitInheritance(ruleContext:InheritanceContext) = CRuleGenerationJavaInheritance.exit(ruleContext)	
}