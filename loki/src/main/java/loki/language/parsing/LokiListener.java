// Generated from ./loki/src/main/java/loki/language/parsing/Loki.grammar by ANTLR 4.8

package loki.language.parsing;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LokiParser}.
 */
public interface LokiListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LokiParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(LokiParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LokiParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(LokiParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LokiParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(LokiParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LokiParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(LokiParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryOperation}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperation(LokiParser.UnaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryOperation}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperation(LokiParser.UnaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(LokiParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(LokiParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryOperation}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperation(LokiParser.BinaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryOperation}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperation(LokiParser.BinaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterString(LokiParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitString(LokiParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unit}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnit(LokiParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unit}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnit(LokiParser.UnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(LokiParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(LokiParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DynamicMember}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDynamicMember(LokiParser.DynamicMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DynamicMember}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDynamicMember(LokiParser.DynamicMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableOrParameter}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableOrParameter(LokiParser.VariableOrParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableOrParameter}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableOrParameter(LokiParser.VariableOrParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignIndexItem}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignIndexItem(LokiParser.AssignIndexItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignIndexItem}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignIndexItem(LokiParser.AssignIndexItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code This}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThis(LokiParser.ThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code This}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThis(LokiParser.ThisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignMember}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignMember(LokiParser.AssignMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignMember}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignMember(LokiParser.AssignMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Member}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMember(LokiParser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Member}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMember(LokiParser.MemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberCall}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberCall(LokiParser.MemberCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberCall}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberCall(LokiParser.MemberCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Call}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCall(LokiParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCall(LokiParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignDynamicMember}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignDynamicMember(LokiParser.AssignDynamicMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignDynamicMember}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignDynamicMember(LokiParser.AssignDynamicMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionGroup}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionGroup(LokiParser.ExpressionGroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionGroup}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionGroup(LokiParser.ExpressionGroupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Host}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterHost(LokiParser.HostContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Host}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitHost(LokiParser.HostContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SuperHostMember}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuperHostMember(LokiParser.SuperHostMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SuperHostMember}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuperHostMember(LokiParser.SuperHostMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code While}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterWhile(LokiParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code While}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitWhile(LokiParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexItem}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexItem(LokiParser.IndexItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexItem}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexItem(LokiParser.IndexItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Array}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArray(LokiParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Array}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArray(LokiParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignVariable}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignVariable(LokiParser.AssignVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignVariable}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignVariable(LokiParser.AssignVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HostMember}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterHostMember(LokiParser.HostMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HostMember}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitHostMember(LokiParser.HostMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Object}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterObject(LokiParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Object}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitObject(LokiParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignHostMember}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignHostMember(LokiParser.AssignHostMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignHostMember}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignHostMember(LokiParser.AssignHostMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Map}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMap(LokiParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Map}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMap(LokiParser.MapContext ctx);
	/**
	 * Enter a parse tree produced by {@link LokiParser#inheritance}.
	 * @param ctx the parse tree
	 */
	void enterInheritance(LokiParser.InheritanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LokiParser#inheritance}.
	 * @param ctx the parse tree
	 */
	void exitInheritance(LokiParser.InheritanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LokiParser#else_}.
	 * @param ctx the parse tree
	 */
	void enterElse_(LokiParser.Else_Context ctx);
	/**
	 * Exit a parse tree produced by {@link LokiParser#else_}.
	 * @param ctx the parse tree
	 */
	void exitElse_(LokiParser.Else_Context ctx);
	/**
	 * Enter a parse tree produced by {@link LokiParser#unitParameter}.
	 * @param ctx the parse tree
	 */
	void enterUnitParameter(LokiParser.UnitParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LokiParser#unitParameter}.
	 * @param ctx the parse tree
	 */
	void exitUnitParameter(LokiParser.UnitParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link LokiParser#unitDefaultParameterValue}.
	 * @param ctx the parse tree
	 */
	void enterUnitDefaultParameterValue(LokiParser.UnitDefaultParameterValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LokiParser#unitDefaultParameterValue}.
	 * @param ctx the parse tree
	 */
	void exitUnitDefaultParameterValue(LokiParser.UnitDefaultParameterValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LokiParser#unitBody}.
	 * @param ctx the parse tree
	 */
	void enterUnitBody(LokiParser.UnitBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LokiParser#unitBody}.
	 * @param ctx the parse tree
	 */
	void exitUnitBody(LokiParser.UnitBodyContext ctx);
}