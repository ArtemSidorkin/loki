package cloki.runtime.datatype.number;

import cloki.runtime.builtins.operations.binary.number.*;
import cloki.runtime.builtins.operations.unary.number.LNumericNegation;
import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.constant.LTypes;
import cloki.runtime.constant.LUnaryOperator;
import cloki.runtime.context.LUnitContext;
import cloki.runtime.datatype.LUnit;
import cloki.runtime.datatype.number.internal.operation.*;
import cloki.runtime.utils.Nullable;

import java.util.HashMap;
import java.util.Map;

public class LNumberPrototype extends LUnit
{
	public static final LNumberPrototype instance = new LNumberPrototype();

	private static final Map<String, LUnit> builtins = new HashMap<String, LUnit>()
	{{
		put(LUnaryOperator.MINUS.symbol, LNumericNegation.instance);
		put(LBinaryOperator.STAR.symbol, LNumberStar.instance);
		put(LBinaryOperator.SLASH.symbol, LNumberSlash.instance);
		put(LBinaryOperator.PLUS.symbol, LNumberPlus.instance);
		put(LBinaryOperator.MINUS.symbol, LNumberMinus.instance);
		put(LBinaryOperator.EQUALS_EQUALS.symbol, LNumberEqualsEquals.instance);
		put(LBinaryOperator.BANG_EQUALS.symbol, LNumberBangEquals.instance);
		put(LBinaryOperator.GREATER_THAN_EQUALS.symbol, LNumberGreaterThanEquals.instance);
		put(LBinaryOperator.LESS_THAN_EQUALS.symbol, LNumberLessThanEquals.instance);
		put(LBinaryOperator.GREATER_THAN.symbol, LNumberGreaterThan.instance);
		put(LBinaryOperator.LESS_THAN.symbol, LNumberLessThan.instance);
	}};

	private static final Map<String, LNumberInternalOperation> internalOperations =
		new HashMap<String, LNumberInternalOperation>()
		{{
			put(LUnaryOperator.MINUS.symbol, LUnaryMinusNumberInternalOperation.instance);
			put(LBinaryOperator.STAR.symbol, LStarNumberInternalOperation.instance);
			put(LBinaryOperator.SLASH.symbol, LSlashNumberInternalOperation.instance);
			put(LBinaryOperator.PLUS.symbol, LPlusNumberInternalOperation.instance);
			put(LBinaryOperator.MINUS.symbol, LMinusNumberInternalOperation.instance);
			put(LBinaryOperator.EQUALS_EQUALS.symbol, LEqualsEqualsNumberInternalOperation.instance);
			put(LBinaryOperator.BANG_EQUALS.symbol, LBangEqualsNumberInternalOperation.instance);
			put(LBinaryOperator.GREATER_THAN_EQUALS.symbol, LGreaterThanEqualsNumberInternalOperation.instance);
			put(LBinaryOperator.LESS_THAN_EQUALS.symbol, LLessThanEqualsNumberInternalOperation.instance);
			put(LBinaryOperator.GREATER_THAN.symbol, LGreaterThanNumberInternalOperation.instance);
			put(LBinaryOperator.LESS_THAN.symbol, LLessThanNumberInternalOperation.instance);
		}};

	private final double value;

	protected LNumberPrototype(double value)
	{
		this.value = value;
	}

	private LNumberPrototype()
	{
		super(LTypes.NUMBER_PROTOTYPE);
		value = 0;
	}

	protected static LNumber checkRightOperand(@Nullable LUnit[] parameters)
	{
		if (parameters != null && 0 < parameters.length) return parameters[0].asType(LTypes.NUMBER);

		return null;
	}

	public double getValue()
	{
		return value;
	}

	@Override
	public int _hashCode()
	{
		return Double.hashCode(value);
	}

	@Override
	public boolean _equals(LUnit unit)
	{
		LNumber number = unit.asType(LTypes.NUMBER);
		return number != null && getValue() == number.getValue();
	}

	@Override
	public String _toString()
	{
		return value == Math.floor(value) ? String.valueOf((long)value) : String.valueOf(value);
	}

	public LUnit getMember(String memberName)
	{
		LUnit member = builtins.get(memberName);

		if (member != null) return member;

		return super.getMember(memberName);
	}

	@Override
	public LUnit callMember(String memberName, LUnit[] parameters, LUnitContext unitContext)
	{
		LNumberInternalOperation internalOperation = internalOperations.get(memberName);

		if (internalOperation != null)
		{
			LUnit result = internalOperation.apply(members, value, parameters);

			if (result != null) return result;
		}

		return super.callMember(memberName, parameters, unitContext);
	}
}
