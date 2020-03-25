package loki.language.generation

import loki.language.generation.rule._
import loki.language.generation.rule.mixin._
import loki.language.generation.rule.template.{ContainerGenerationRuleTemplate, MemberCallGenerationRuleTemplate}
import loki.language.parsing.LokiBaseListener
import loki.language.parsing.LokiParser._
import org.antlr.v4.runtime.tree.ErrorNode

class BytecodeGenerator(moduleName:String) extends LokiBaseListener
{
	val classLoader = new GenerationClassLoader

	private implicit val generationContext:GenerationContext = new GenerationContext(moduleName, classLoader)

//	override def visitErrorNode(errorNode:ErrorNode):Unit = throw new IllegalStateException

	override def enterModule(moduleContext:ModuleContext):Unit = ModuleGenerationRule.enter(moduleContext)
	override def exitModule(moduleContext:ModuleContext):Unit = ModuleGenerationRule.exit(moduleContext)

	override def enterInstruction(instructionContext:InstructionContext):Unit =
		InstructionGenerationRule.enter(instructionContext)

	override def exitInstruction(instructionContext:InstructionContext):Unit =
		InstructionGenerationRule.exit(instructionContext)

	override def enterExpressionGroup(expressionGroupContext:ExpressionGroupContext):Unit =
		GenerationRule.enter( expressionGroupContext)

	override def exitExpressionGroup(expressionGroupContext:ExpressionGroupContext):Unit =
		GenerationRule.exit(expressionGroupContext)

	override def enterUnit(unitContext:UnitContext):Unit = UnitGenerationRule.enter(unitContext)
	override def exitUnit(unitContext:UnitContext):Unit = UnitGenerationRule.exit(unitContext)

	override def enterArray(arrayContext:ArrayContext):Unit =
		(new ContainerGenerationRuleTemplate(arrayContext) with ArrayGenerationRuleMixin).enter()

	override def exitArray(arrayContext:ArrayContext):Unit =
		(new ContainerGenerationRuleTemplate(arrayContext) with ArrayGenerationRuleMixin).exit()

	override def enterMap(mapContext:MapContext):Unit =
		(new ContainerGenerationRuleTemplate(mapContext) with MapGenerationRuleMixin).enter()

	override def exitMap(mapContext:MapContext):Unit =
		(new ContainerGenerationRuleTemplate(mapContext) with MapGenerationRuleMixin).exit()

	override def enterObject(objectContext:ObjectContext):Unit =
		(new ContainerGenerationRuleTemplate(objectContext) with ObjectGenerationRuleMixin).enter()

	override def exitObject(objectContext:ObjectContext):Unit =
		(new ContainerGenerationRuleTemplate(objectContext) with ObjectGenerationRuleMixin).exit()

	override def enterIndex(indexContext:IndexContext):Unit = IndexGenerationRule.enter(indexContext)
	override def exitIndex(indexContext:IndexContext):Unit = IndexGenerationRule.exit(indexContext)

	override def enterAssignIndex(assignIndexContext:AssignIndexContext):Unit =
		AssignIndexGenerationRule.exit(assignIndexContext)

	override def exitAssignIndex(assignIndexContext:AssignIndexContext):Unit =
		AssignIndexGenerationRule.exit(assignIndexContext)

	override def enterMemberAccessor(memberAccessorContext:MemberAccessorContext):Unit =
		MemberAccessorGenerationRule.enter(memberAccessorContext)

	override def exitMemberAccessor(memberAccessorContext:MemberAccessorContext):Unit =
		MemberAccessorGenerationRule.exit(memberAccessorContext)

	override def enterAssignMemberAccessor(assignMemberAccessorContext:AssignMemberAccessorContext):Unit =
		AssignMemberAccessorGenerationRule.enter(assignMemberAccessorContext)

	override def exitAssignMemberAccessor(assignMemberAccessorContext:AssignMemberAccessorContext):Unit =
		AssignMemberAccessorGenerationRule.exit(assignMemberAccessorContext)

	override def enterCall(callContext:CallContext):Unit = CallGenerationRule.enter(callContext)
	override def exitCall(callContext:CallContext):Unit = CallGenerationRule.exit(callContext)

	override def enterMemberCall(memberCallContext:MemberCallContext):Unit =
		(new MemberCallGenerationRuleTemplate(memberCallContext) with MemberCallGenerationRuleMixin).enter()

	override def exitMemberCall(memberCallContext:MemberCallContext):Unit =
		(new MemberCallGenerationRuleTemplate(memberCallContext) with MemberCallGenerationRuleMixin).exit()

	override def enterVariableOrParameter(variableOrParameterContext:VariableOrParameterContext):Unit =
		VariableOrParameterGenerationRule.enter(variableOrParameterContext)

	override def exitVariableOrParameter(variableOrParameterContext:VariableOrParameterContext):Unit =
		VariableOrParameterGenerationRule.exit(variableOrParameterContext)

	override def enterSuperHostMember(superHostMemberContext:SuperHostMemberContext):Unit =
		SuperHostMemberGenerationRule.enter(superHostMemberContext)

	override def exitSuperHostMember(superHostMemberContext:SuperHostMemberContext):Unit =
		SuperHostMemberGenerationRule.exit(superHostMemberContext)

	override def enterHostMember(hostMemberContext:HostMemberContext):Unit =
		HostMemberGenerationRule.enter(hostMemberContext)

	override def exitHostMember(hostMemberContext:HostMemberContext):Unit =
		HostMemberGenerationRule.exit(hostMemberContext)

	override def enterMember(memberContext:MemberContext):Unit = MemberGenerationRule.enter(memberContext)
	override def exitMember(memberContext:MemberContext):Unit =	MemberGenerationRule.exit(memberContext)

	override def enterAssignVariable(assignVariableContext:AssignVariableContext):Unit =
		AssignVariableGenerationRule.enter(assignVariableContext)

	override def exitAssignVariable(assignVariableContext:AssignVariableContext):Unit =
		AssignVariableGenerationRule.exit(assignVariableContext)

	override def enterAssignHostMember(assignHostMemberContext:AssignHostMemberContext):Unit =
		AssignHostMemberGenerationRule.enter(assignHostMemberContext)

	override def exitAssignHostMember(assignHostMemberContext:AssignHostMemberContext):Unit =
		AssignHostMemberGenerationRule.exit(assignHostMemberContext)

	override def enterAssignMember(assignMemberContext:AssignMemberContext):Unit =
		AssignMemberGenerationRule.enter(assignMemberContext)

	override def exitAssignMember(assignMemberContext:AssignMemberContext):Unit =
		AssignMemberGenerationRule.exit(assignMemberContext)

	override def enterHost(hostContext:HostContext):Unit = HostGenerationRule.enter(hostContext)
	override def exitHost(hostContext:HostContext):Unit = HostGenerationRule.exit(hostContext)

	override def enterThis(thisContext:ThisContext):Unit = ThisGenerationRule.enter(thisContext)
	override def exitThis(thisContext:ThisContext):Unit = ThisGenerationRule.enter(thisContext)

	override def enterString(stringContext:StringContext):Unit = StringGenerationRule.enter(stringContext)
	override def exitString(stringContext:StringContext):Unit =	StringGenerationRule.exit(stringContext)

	override def enterNumber(numberContext:NumberContext):Unit = NumberGenerationRule.enter(numberContext)
	override def exitNumber(numberContext:NumberContext):Unit =	NumberGenerationRule.exit(numberContext)

	override def enterUnaryOperation(unaryOperationContext:UnaryOperationContext):Unit =
		(new MemberCallGenerationRuleTemplate(unaryOperationContext) with UnaryOperationGenerationRuleMixin).enter()

	override def exitUnaryOperation(unaryOperationContext:UnaryOperationContext):Unit =
		(new MemberCallGenerationRuleTemplate(unaryOperationContext) with UnaryOperationGenerationRuleMixin).exit()

	override def enterBinaryOperation(binaryOperationContext:BinaryOperationContext):Unit =
		(new MemberCallGenerationRuleTemplate[BinaryOperationContext](binaryOperationContext)
			with OperatorGenerationRuleMixin)
			.enter()

	override def exitBinaryOperation(binaryOperationContext:BinaryOperationContext):Unit =
		(new MemberCallGenerationRuleTemplate[BinaryOperationContext](binaryOperationContext)
			with OperatorGenerationRuleMixin)
			.exit()

	override def enterIfElse(ifElseContext:IfElseContext):Unit = IfElseGenerationRule.enter(ifElseContext)
	override def exitIfElse(ifElseContext:IfElseContext):Unit =	IfElseGenerationRule.exit(ifElseContext)

	override def enterWhile(whileContext:WhileContext):Unit = WhileGenerationRule.enter(whileContext)
	override def exitWhile(whileContext:WhileContext):Unit = WhileGenerationRule.exit(whileContext)

	override def enterInheritance(inheritanceContext:InheritanceContext):Unit =
		InheritanceGenerationRule.enter(inheritanceContext)

	override def exitInheritance(inheritanceContext:InheritanceContext):Unit =
		InheritanceGenerationRule.exit(inheritanceContext)
}