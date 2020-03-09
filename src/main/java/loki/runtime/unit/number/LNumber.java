package loki.runtime.unit.number;

import loki.runtime.unit.LString;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.number.member.operation.binary.*;
import loki.runtime.unit.number.member.operation.unary.LNegationNumberUnaryOperation;
import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;

public class LNumber extends LUnit
{
	public static final String TYPE_NAME = "Number";
	public static final LType TYPE = new LType(TYPE_NAME, LNumber.class);

	public static final String PROTOTYPE_NAME = "NumberPrototype";
	public static final LType PROTO_TYPE = new LType(PROTOTYPE_NAME, LNumber.class);
	public static final LNumber PROTOTYPE = new LNumber();

	private final double value;

	public LNumber(double value)
	{
		super(TYPE);

		this.value = value;

		_addParents(PROTOTYPE);
	}

	private LNumber()
	{
		setType(PROTO_TYPE);

		value = 0;

		initBuiltins();
	}

	public double getValue()
	{
		return value;
	}

	@Override
	public LNumber _hashCode()
	{
		return new LNumber(Double.hashCode(value));
	}

	@Override
	public LBoolean _equals(LUnit unit)
	{
		LNumber number = unit.asType(TYPE);

		return LBoolean.valueOf(number != null && value == number.value);
	}

	@Override
	public LString _toString()
	{
		return new LString(value == Math.floor(value) ? String.valueOf((long)value) : String.valueOf(value));
	}

	private void initBuiltins()
	{
		LNegationNumberUnaryOperation.INSTANCE.init(this);
		LMultiplicationNumberBinaryOperation.INSTANCE.init(this);
		LDivisionNumberBinaryOperation.INSTANCE.init(this);
		LAdditionNumberBinaryOperation.INSTANCE.init(this);
		LSubtractionNumberBinaryOperation.INSTANCE.init(this);
		LEqualityNumberBinaryOperation.INSTANCE.init(this);
		LInequalityNumberBinaryOperation.INSTANCE.init(this);
		LGreaterThanEqualsNumberBinaryOperation.INSTANCE.init(this);
		LLessThanEqualsNumberBinaryOperation.INSTANCE.init(this);
		LGreaterThanNumberBinaryOperation.INSTANCE.init(this);
		LLessThanNumberBinaryOperation.INSTANCE.init(this);
	}
}
