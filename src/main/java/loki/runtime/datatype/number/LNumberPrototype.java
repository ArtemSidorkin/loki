package loki.runtime.datatype.number;

import loki.runtime.constant.LBinaryOperator;
import loki.runtime.constant.LTypes;
import loki.runtime.constant.LUnaryOperator;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.operation.binary.*;
import loki.runtime.datatype.number.operation.internal.*;
import loki.runtime.datatype.number.operation.unary.LNumericNegation;
import loki.runtime.util.Nullable;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LNumberPrototype extends LUnit
{
	public static final LNumberPrototype instance = new LNumberPrototype();

	private static final ConcurrentMap<String, LNumberInternalOperation> internalOperations =
		new ConcurrentHashMap<String, LNumberInternalOperation>()
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
		initBuiltins();
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
	public LUnit setMember(String memberName, LUnit member)
	{
		if (internalOperations != null) internalOperations.remove(memberName);

		return super.setMember(memberName, member);
	}

	@Override
	public LUnit callMember(String memberName, LUnit[] parameters, LUnitContext unitContext)
	{
		LNumberInternalOperation internalOperation = internalOperations.get(memberName);

		if (internalOperation != null) return internalOperation.apply(value, parameters);

		return super.callMember(memberName, parameters, unitContext);
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

	private void initBuiltins()
	{
		LNumericNegation.instance.init(this);
		LNumberStar.instance.init(this);
		LNumberSlash.instance.init(this);
		LNumberPlus.instance.init(this);
		LNumberMinus.instance.init(this);
		LNumberEqualsEquals.instance.init(this);
		LNumberBangEquals.instance.init(this);
		LNumberGreaterThanEquals.instance.init(this);
		LNumberLessThanEquals.instance.init(this);
		LNumberGreaterThan.instance.init(this);
		LNumberLessThan.instance.init(this);
	}
}
