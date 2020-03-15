// Generated from ./src/main/java/loki/language/parsing/Loki.grammar by ANTLR 4.5

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
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(LokiParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(LokiParser.MulDivContext ctx);
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
	 * Enter a parse tree produced by the {@code Index}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndex(LokiParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Index}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndex(LokiParser.IndexContext ctx);
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
	 * Enter a parse tree produced by the {@code GteLteGtLt}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGteLteGtLt(LokiParser.GteLteGtLtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GteLteGtLt}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGteLteGtLt(LokiParser.GteLteGtLtContext ctx);
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
	 * Enter a parse tree produced by the {@code AmpersandAmpersand}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAmpersandAmpersand(LokiParser.AmpersandAmpersandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AmpersandAmpersand}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAmpersandAmpersand(LokiParser.AmpersandAmpersandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberAccessor}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccessor(LokiParser.MemberAccessorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberAccessor}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccessor(LokiParser.MemberAccessorContext ctx);
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
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(LokiParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(LokiParser.AddSubContext ctx);
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
	 * Enter a parse tree produced by the {@code EqNeq}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqNeq(LokiParser.EqNeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqNeq}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqNeq(LokiParser.EqNeqContext ctx);
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
	 * Enter a parse tree produced by the {@code AssignMemberAccessor}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignMemberAccessor(LokiParser.AssignMemberAccessorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignMemberAccessor}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignMemberAccessor(LokiParser.AssignMemberAccessorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignIndex}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignIndex(LokiParser.AssignIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignIndex}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignIndex(LokiParser.AssignIndexContext ctx);
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
	 * Enter a parse tree produced by the {@code PipePipe}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPipePipe(LokiParser.PipePipeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PipePipe}
	 * labeled alternative in {@link LokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPipePipe(LokiParser.PipePipeContext ctx);
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
}