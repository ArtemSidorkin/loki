package loki.runtime.unit.number;

import loki.runtime.constant.LTypes;
import loki.runtime.unit.LString;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.member.operation.binary.*;
import loki.runtime.unit.number.member.operation.unary.LNumericNegationNumberUnaryOperation;
import loki.runtime.unit.unit.LUnit;


public class LNumber extends LUnit
{
	public static final LNumber prototype = new LNumber();

	public final double value;

	public LNumber(double value)
	{
		super(LTypes.NUMBER);
		this.value = value;
		_addParents(prototype);
	}

	private LNumber()
	{
		super(LTypes.NUMBER_PROTOTYPE);
		value = 0;
		initBuiltins();
	}

	@Override
	public LNumber _hashCode()
	{
		return new LNumber(Double.hashCode(value));
	}

	@Override
	public LBoolean _equals(LUnit unit)
	{
		LNumber number = unit.asType(LTypes.NUMBER);

		return LBoolean.valueOf(number != null && value == number.value);
	}

	@Override
	public LString _toString()
	{
		return new LString(value == Math.floor(value) ? String.valueOf((long)value) : String.valueOf(value));
	}

	private void initBuiltins()
	{
		LNumericNegationNumberUnaryOperation.instance.init(this);
		LMultiplicationNumberBinaryOperation.instance.init(this);
		LDivisionNumberBinaryOperation.instance.init(this);
		LAdditionNumberBinaryOperation.instance.init(this);
		LSubtractionNumberBinaryOperation.instance.init(this);
		LEqualityNumberBinaryOperation.instance.init(this);
		LInequalityNumberBinaryOperation.instance.init(this);
		LGreaterThanEqualsNumberBinaryOperation.instance.init(this);
		LLessThanEqualsNumberBinaryOperation.instance.init(this);
		LGreaterThanNumberBinaryOperation.instance.init(this);
		LLessThanNumberBinaryOperation.instance.init(this);
	}
}
