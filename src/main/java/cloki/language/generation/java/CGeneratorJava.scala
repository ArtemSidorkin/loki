package cloki.language.generation.java

import cloki.language.generation.Generator
import cloki.language.generation.java.CGenerationJava.CGenerationContextJava
import cloki.language.generation.java.rules._
import cloki.language.parsing.LokiParser._

class CGeneratorJava(moduleName:String) extends Generator[CGenerationContextJava]
{
	protected implicit val generationContext = new CGenerationContextJava(moduleName, classLoader)

	override def enterModule(ruleContext:ModuleContext) = new GenerationRuleJavaModule(generationContext, ruleContext).enter()
	override def exitModule(ruleContext:ModuleContext) = new GenerationRuleJavaModule(generationContext, ruleContext).exit()

	override def enterInstruction(ruleContext:InstructionContext) = new GenerationRuleJavaInstruction(generationContext, ruleContext).enter()
	override def exitInstruction(ruleContext:InstructionContext) = new GenerationRuleJavaInstruction(generationContext, ruleContext).exit()

	override def enterExpressionGroup(ruleContext:ExpressionGroupContext) = ()
	override def exitExpressionGroup(ruleContext:ExpressionGroupContext) = ()

	override def enterUnit(ruleContext:UnitContext) = new GenerationRuleJavaUnit(generationContext, ruleContext).enter()
	override def exitUnit(ruleContext:UnitContext) = new GenerationRuleJavaUnit(generationContext, ruleContext).exit()

	override def enterArray(ruleContext:ArrayContext) = new GenerationRuleJavaArray(generationContext, ruleContext).enter()
	override def exitArray(ruleContext:ArrayContext) = new GenerationRuleJavaArray(generationContext, ruleContext).exit()

	override def enterIndex(ruleContext:IndexContext) = new GenerationRuleJavaIndex(generationContext, ruleContext).enter()
	override def exitIndex(ruleContext:IndexContext) = new GenerationRuleJavaIndex(generationContext, ruleContext).exit()

	override def enterAssignIndex(ruleContext:AssignIndexContext) = new GenerationRuleJavaAssignIndex(generationContext, ruleContext).enter()
	override def exitAssignIndex(ruleContext:AssignIndexContext) = new GenerationRuleJavaAssignIndex(generationContext, ruleContext).exit()

	override def enterCall(ruleContext:CallContext) = new GenerationRuleJavaCall(generationContext, ruleContext).enter()
	override def exitCall(ruleContext:CallContext) = new GenerationRuleJavaCall(generationContext, ruleContext).exit()

	override def enterMemberCall(ruleContext:MemberCallContext) = new GenerationRuleJavaMemberCall(generationContext, ruleContext).enter()
	override def exitMemberCall(ruleContext:MemberCallContext) = new GenerationRuleJavaMemberCall(generationContext, ruleContext).exit()

	override def enterVariableOrParameter(ruleContext:VariableOrParameterContext) =
		new GenerationRuleJavaVariableOrParameter(generationContext, ruleContext).enter()

	override def exitVariableOrParameter(ruleContext:VariableOrParameterContext) =
		new GenerationRuleJavaVariableOrParameter(generationContext, ruleContext).exit()

	override def enterSuperHostMember(ruleContext:SuperHostMemberContext) =
		new GenerationRuleJavaSuperHostMember(generationContext, ruleContext).enter()

	override def exitSuperHostMember(ruleContext:SuperHostMemberContext) =
		new GenerationRuleJavaSuperHostMember(generationContext, ruleContext).exit()

	override def enterHostMember(ruleContext:HostMemberContext) = new GenerationRuleJavaHostMember(generationContext, ruleContext).enter()
	override def exitHostMember(ruleContext:HostMemberContext) = new GenerationRuleJavaHostMember(generationContext, ruleContext).exit()

	override def enterMember(ruleContext:MemberContext) = new GenerationRuleJavaMember(generationContext, ruleContext).enter()
	override def exitMember(ruleContext:MemberContext) = new GenerationRuleJavaMember(generationContext, ruleContext).exit()

	override def enterAssignVariable(ruleContext:AssignVariableContext) =
		new GenerationRuleJavaAssignVariable(generationContext, ruleContext).enter()

	override def exitAssignVariable(ruleContext:AssignVariableContext) =
		new GenerationRuleJavaAssignVariable(generationContext, ruleContext).exit()

	override def enterAssignHostMember(ruleContext:AssignHostMemberContext) =
		new GenerationRuleJavaAssignHostMember(generationContext, ruleContext).enter()

	override def exitAssignHostMember(ruleContext:AssignHostMemberContext) =
		new GenerationRuleJavaAssignHostMember(generationContext, ruleContext).exit()

	override def enterAssignMember(ruleContext:AssignMemberContext) = new GenerationRuleJavaAssignMember(generationContext, ruleContext).enter()
	override def exitAssignMember(ruleContext:AssignMemberContext) = new GenerationRuleJavaAssignMember(generationContext, ruleContext).exit()

	override def enterHost(ruleContext:HostContext) = new GenerationRuleJavaHost(generationContext, ruleContext).enter()
	override def exitHost(ruleContext:HostContext) = new GenerationRuleJavaHost(generationContext, ruleContext).exit()

	override def enterThis(ruleContext:ThisContext) = new GenerationRuleJavaThis(generationContext, ruleContext).enter()
	override def exitThis(ruleContext:ThisContext) = new GenerationRuleJavaThis(generationContext, ruleContext).exit()

	override def enterString(ruleContext:StringContext) = new GenerationRuleJavaString(generationContext, ruleContext).enter()
	override def exitString(ruleContext:StringContext) = new GenerationRuleJavaString(generationContext, ruleContext).exit()

	override def enterNumber(ruleContext:NumberContext) = new GenerationRuleJavaNumber(generationContext, ruleContext).enter()
	override def exitNumber(ruleContext:NumberContext) = new GenerationRuleJavaNumber(generationContext, ruleContext).exit()

	override def enterUnaryOperation(ruleContext:UnaryOperationContext) = new GenerationRuleJavaUnaryOperation(generationContext, ruleContext).enter()
	override def exitUnaryOperation(ruleContext:UnaryOperationContext) = new GenerationRuleJavaUnaryOperation(generationContext, ruleContext).exit()

	override def enterMulDiv(ruleContext:MulDivContext) = new GenerationRuleJavaOperator(generationContext, ruleContext).enter()
	override def exitMulDiv(ruleContext:MulDivContext) = new GenerationRuleJavaOperator(generationContext, ruleContext).exit()

	override def enterAddSub(ruleContext:AddSubContext) = new GenerationRuleJavaOperator(generationContext, ruleContext).enter()
	override def exitAddSub(ruleContext:AddSubContext) = new GenerationRuleJavaOperator(generationContext, ruleContext).exit()

	override def enterEqNeq(ruleContext:EqNeqContext) = new GenerationRuleJavaOperator(generationContext, ruleContext).enter()
	override def exitEqNeq(ruleContext:EqNeqContext) = new GenerationRuleJavaOperator(generationContext, ruleContext).exit()

	override def enterGteLteGtLt(ruleContext:GteLteGtLtContext) = new GenerationRuleJavaOperator(generationContext, ruleContext).enter()
	override def exitGteLteGtLt(ruleContext:GteLteGtLtContext) = new GenerationRuleJavaOperator(generationContext, ruleContext).exit()

	override def enterAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = new GenerationRuleJavaOperator(generationContext, ruleContext).enter()
	override def exitAmpersandAmpersand(ruleContext:AmpersandAmpersandContext) = new GenerationRuleJavaOperator(generationContext, ruleContext).exit()

	override def enterPipePipe(ruleContext:PipePipeContext) = new GenerationRuleJavaOperator(generationContext, ruleContext).enter()
	override def exitPipePipe(ruleContext:PipePipeContext) = new GenerationRuleJavaOperator(generationContext, ruleContext).exit()

	override def enterIfElse(ruleContext:IfElseContext) = new GenerationRuleJavaIfElse(generationContext, ruleContext).enter()
	override def exitIfElse(ruleContext:IfElseContext) = new GenerationRuleJavaIfElse(generationContext, ruleContext).exit()

	override def enterWhile(ruleContext:WhileContext) = new GenerationRuleJavaWhile(generationContext, ruleContext).enter()
	override def exitWhile(ruleContext:WhileContext) = new GenerationRuleJavaWhile(generationContext, ruleContext).exit()

	override def enterInheritance(ruleContext:InheritanceContext) = new GenerationRuleJavaInheritance(generationContext, ruleContext).enter()
	override def exitInheritance(ruleContext:InheritanceContext) = new GenerationRuleJavaInheritance(generationContext, ruleContext).exit()
}