// Generated from CLoki.grammar by ANTLR 4.5

package cloki.language.parsing;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CLokiParser}.
 */
public interface CLokiListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CLokiParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(CLokiParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLokiParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(CLokiParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLokiParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(CLokiParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLokiParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(CLokiParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryOperation}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperation(CLokiParser.UnaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryOperation}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperation(CLokiParser.UnaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(CLokiParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(CLokiParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(CLokiParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(CLokiParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Index}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndex(CLokiParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Index}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndex(CLokiParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterString(CLokiParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitString(CLokiParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unit}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnit(CLokiParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unit}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnit(CLokiParser.UnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GteLteGtLt}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGteLteGtLt(CLokiParser.GteLteGtLtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GteLteGtLt}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGteLteGtLt(CLokiParser.GteLteGtLtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(CLokiParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(CLokiParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AmpersandAmpersand}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAmpersandAmpersand(CLokiParser.AmpersandAmpersandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AmpersandAmpersand}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAmpersandAmpersand(CLokiParser.AmpersandAmpersandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableOrParameter}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableOrParameter(CLokiParser.VariableOrParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableOrParameter}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableOrParameter(CLokiParser.VariableOrParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code This}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThis(CLokiParser.ThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code This}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThis(CLokiParser.ThisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignMember}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignMember(CLokiParser.AssignMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignMember}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignMember(CLokiParser.AssignMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Member}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMember(CLokiParser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Member}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMember(CLokiParser.MemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberCall}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberCall(CLokiParser.MemberCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberCall}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberCall(CLokiParser.MemberCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Call}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCall(CLokiParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Call}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCall(CLokiParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(CLokiParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(CLokiParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionGroup}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionGroup(CLokiParser.ExpressionGroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionGroup}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionGroup(CLokiParser.ExpressionGroupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Host}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterHost(CLokiParser.HostContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Host}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitHost(CLokiParser.HostContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SuperHostMember}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuperHostMember(CLokiParser.SuperHostMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SuperHostMember}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuperHostMember(CLokiParser.SuperHostMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code While}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterWhile(CLokiParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code While}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitWhile(CLokiParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqNeq}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqNeq(CLokiParser.EqNeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqNeq}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqNeq(CLokiParser.EqNeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Array}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArray(CLokiParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Array}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArray(CLokiParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignVariable}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignVariable(CLokiParser.AssignVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignVariable}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignVariable(CLokiParser.AssignVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignIndex}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignIndex(CLokiParser.AssignIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignIndex}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignIndex(CLokiParser.AssignIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HostMember}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterHostMember(CLokiParser.HostMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HostMember}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitHostMember(CLokiParser.HostMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignHostMember}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignHostMember(CLokiParser.AssignHostMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignHostMember}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignHostMember(CLokiParser.AssignHostMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PipePipe}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPipePipe(CLokiParser.PipePipeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PipePipe}
	 * labeled alternative in {@link CLokiParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPipePipe(CLokiParser.PipePipeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLokiParser#inheritance}.
	 * @param ctx the parse tree
	 */
	void enterInheritance(CLokiParser.InheritanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLokiParser#inheritance}.
	 * @param ctx the parse tree
	 */
	void exitInheritance(CLokiParser.InheritanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLokiParser#else_}.
	 * @param ctx the parse tree
	 */
	void enterElse_(CLokiParser.Else_Context ctx);
	/**
	 * Exit a parse tree produced by {@link CLokiParser#else_}.
	 * @param ctx the parse tree
	 */
	void exitElse_(CLokiParser.Else_Context ctx);
}