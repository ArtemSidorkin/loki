package cloki.language.generation.java

import cloki.language.generation.Generator
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.java.rules._
import cloki.language.parsing.LokiParser._

class CGeneratorJava(moduleName:String) extends Generator[CGenerationContextJava]
{
	protected implicit val generationContext = new CGenerationContextJava(moduleName, classLoader)

	override def enterModule(ruleContext:ModuleContext) = GenerationRuleJavaModule.enter(generationContext, ruleContext)
	override def exitModule(ruleContext:ModuleContext) = GenerationRuleJavaModule.exit(generationContext, ruleContext)

	override def enterInstruction(ruleContext:InstructionContext) = GenerationRuleJavaInstruction.enter(generationContext, ruleContext)
	override def exitInstruction(ruleContext:InstructionContext) = GenerationRuleJavaInstruction.exit(generationContext, ruleContext)

	override def enterExpressionGroup(ruleContext:ExpressionGroupContext) = new GenerationRuleJava[ExpressionGroupContext](generationContext, ruleContext).enter()
	override def exitExpressionGroup(ruleContext:ExpressionGroupContext) = new GenerationRuleJava[ExpressionGroupContext](generationContext, ruleContext).exit()

	override def enterUnit(ruleContext:UnitContext) = GenerationRuleJavaUnit.enter(generationContext, ruleContext)
	override def exitUnit(ruleContext:UnitContext) = GenerationRuleJavaUnit.exit(generationContext, ruleContext)

	override def enterArray(ruleContext:ArrayContext) = GenerationRuleJavaArray.enter(generationContext, ruleContext)
	override def exitArray(ruleContext:ArrayContext) = GenerationRuleJavaArray.exit(generationContext, ruleContext)

	override def enterIndex(ruleContext:IndexContext) = GenerationRuleJavaIndex.enter(generationContext, ruleContext)
	override def exitIndex(ruleContext:IndexContext) = GenerationRuleJavaIndex.exit(generationContext, ruleContext)

	override def enterAssignIndex(ruleContext:AssignIndexContext) = GenerationRuleJavaAssignIndex.enter(generationContext, ruleContext)
	override def exitAssignIndex(ruleContext:AssignIndexContext) = GenerationRuleJavaAssignIndex.exit(generationContext, ruleContext)

	override def enterCall(ruleContext:CallContext) = GenerationRuleJavaCall.enter(generationContext, ruleContext)
	override def exitCall(ruleContext:CallContext) = GenerationRuleJavaCall.exit(generationContext, ruleContext)

	override def enterMemberCall(ruleContext:MemberCallContext) = GenerationRuleJavaMemberCall.enter(generationContext, ruleContext)
	override def exitMemberCall(ruleContext:MemberCallContext) = GenerationRuleJavaMemberCall.exit(generationContext, ruleContext)

	override def enterVariableOrParameter(ruleContext:VariableOrParameterContext) =
		GenerationRuleJavaVariableOrParameter.enter(generationContext, ruleContext)

	override def exitVariableOrParameter(ruleContext:VariableOrParameterContext) =
		GenerationRuleJavaVariableOrParameter.exit(generationContext, ruleContext)

	override def enterSuperHostMember(ruleContext:SuperHostMemberContext) =
		GenerationRuleJavaSuperHostMember.enter(generationContext, ruleContext)

	override def exitSuperHostMember(ruleContext:SuperHostMemberContext) =
		GenerationRuleJavaSuperHostMember.exit(generationContext, ruleContext)

	override def enterHostMember(ruleContext:HostMemberContext) = GenerationRuleJavaHostMember.enter(generationContext, ruleContext)
	override def exitHostMember(ruleContext:HostMemberContext) = GenerationRuleJavaHostMember.exit(generationContext, ruleContext)

	override def enterMember(ruleContext:MemberContext) = GenerationRuleJavaMember.enter(generationContext, ruleContext)
	override def exitMember(ruleContext:MemberContext) = GenerationRuleJavaMember.exit(generationContext, ruleContext)

	override def enterAssignVariable(ruleContext:AssignVariableContext) =
		GenerationRuleJavaAssignVariable.enter(generationContext, ruleContext)

	override def exitAssignVariable(ruleContext:AssignVariableContext) =
		GenerationRuleJavaAssignVariable.exit(generationContext, ruleContext)

	override def enterAssignHostMember(ruleContext:AssignHostMemberContext) =
		GenerationRuleJavaAssignHostMember.enter(generationContext, ruleContext)

	override def exitAssignHostMember(ruleContext:AssignHostMemberContext) =
		GenerationRuleJavaAssignHostMember.exit(generationContext, ruleContext)

	override def enterAssignMember(ruleContext:AssignMemberContext) = GenerationRuleJavaAssignMember.enter(generationContext, ruleContext)
	override def exitAssignMember(ruleContext:AssignMemberContext) = GenerationRuleJavaAssignMember.exit(generationContext, ruleContext)

	override def enterHost(ruleContext:HostContext) = GenerationRuleJavaHost.enter(generationContext, ruleContext)
	override def exitHost(ruleContext:HostContext) = GenerationRuleJavaHost.exit(generationContext, ruleContext)

	override def enterThis(ruleContext:ThisContext) = GenerationRuleJavaThis.enter(generationContext, ruleContext)
	override def exitThis(ruleContext:ThisContext) = GenerationRuleJavaThis.exit(generationContext, ruleContext)

	override def enterString(ruleContext:StringContext) = GenerationRuleJavaString.enter(generationContext, ruleContext)
	override def exitString(ruleContext:StringContext) = GenerationRuleJavaString.exit(generationContext, ruleContext)

	override def enterNumber(ruleContext:NumberContext) = GenerationRuleJavaNumber.enter(generationContext, ruleContext)
	override def exitNumber(ruleContext:NumberContext) = GenerationRuleJavaNumber.exit(generationContext, ruleContext)

	override def enterUnaryOperation(ruleContext:UnaryOperationContext) = GenerationRuleJavaUnaryOperation.enter(generationContext, ruleContext)
	override def exitUnaryOperation(ruleContext:UnaryOperationContext) = GenerationRuleJavaUnaryOperation.exit(generationContext, ruleContext)

	override def enterMulDiv(ruleContext:MulDivContext) = GenerationRuleJavaOperator.enter(generationContext, ruleContext)
	override def exitMulDiv(ruleContext:MulDivContext) = GenerationRuleJavaOperator.exit(generationContext, ruleContext)

	override def enterAddSub(ruleContext:AddSubContext) = GenerationRuleJavaOperator.enter(generationContext, ruleContext)
	override def exitAddSub(ruleContext:AddSubContext) = GenerationRuleJavaOperator.exit(generationContext, ruleContext)

	override def enterEqNeq(ruleContext:EqNeqContext) = GenerationRuleJavaOperator.enter(generationContext, ruleContext)
	override def exitEqNeq(ruleContext:EqNeqContext) = GenerationRuleJavaOperator.exit(generationContext, ruleContext)

	override def enterGteLteGtLt(ruleContext:GteLteGtLtContext) = GenerationRuleJavaOperator.enter(generationContext, ruleContext)
	override def exitGteLteGtLt(ruleContext:GteLteGtLtContext) = GenerationRuleJavaOperator.exit(generationContext, ruleContext)

	override def enterAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = GenerationRuleJavaOperator.enter(generationContext, ruleContext)
	override def exitAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = GenerationRuleJavaOperator.exit(generationContext, ruleContext)

	override def enterPipePipe(ruleContext:PipePipeContext) = GenerationRuleJavaOperator.enter(generationContext, ruleContext)
	override def exitPipePipe(ruleContext:PipePipeContext) = GenerationRuleJavaOperator.exit(generationContext, ruleContext)

	override def enterIfElse(ruleContext:IfElseContext) = GenerationRuleJavaIfElse.enter(generationContext, ruleContext)
	override def exitIfElse(ruleContext:IfElseContext) = GenerationRuleJavaIfElse.exit(generationContext, ruleContext)

	override def enterWhile(ruleContext:WhileContext) = GenerationRuleJavaWhile.enter(generationContext, ruleContext)
	override def exitWhile(ruleContext:WhileContext) = GenerationRuleJavaWhile.exit(generationContext, ruleContext)

	override def enterInheritance(ruleContext:InheritanceContext) = GenerationRuleJavaInheritance.enter(generationContext, ruleContext)
	override def exitInheritance(ruleContext:InheritanceContext) = GenerationRuleJavaInheritance.exit(generationContext, ruleContext)
}