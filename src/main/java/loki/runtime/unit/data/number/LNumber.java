package loki.runtime.unit.data.number;

import loki.runtime.unit.data.LString;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.member.operation.binary.*;
import loki.runtime.unit.data.number.member.operation.unary.LNegationNumberUnaryOperation;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LDataUnitDescriptor;

public class LNumber extends LUnit
{
	public static final LDataUnitDescriptor<LNumber> DESCRIPTOR =
		new LDataUnitDescriptor<>("Number", "NumberPrototype", LNumber.class);

	private final double value;

	public LNumber(double value)
	{
		super(DESCRIPTOR.getType());

		this.value = value;

		_addParents(DESCRIPTOR.getPrototype());
	}

	private LNumber()
	{
		setType(DESCRIPTOR.getPrototypeType());

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
		LNumber number = unit.asType(DESCRIPTOR.getType());

		return LBoolean.valueOf(number != null && value == number.value);
	}

	@Override
	public LString _toString()
	{
		return new LString(value == Math.floor(value) ? String.valueOf((long)value) : String.valueOf(value));
	}

	private void initBuiltins()
	{
		//TODO redirect, move init to unit (aslo for other places)
		LNegationNumberUnaryOperation.DESCRIPTOR.getInstance().init(this);
		LMultiplicationNumberBinaryOperation.DESCRIPTOR.getInstance().init(this);
		LDivisionNumberBinaryOperation.DESCRIPTOR.getInstance().init(this);
		LAdditionNumberBinaryOperation.DESCRIPTOR.getInstance().init(this);
		LSubtractionNumberBinaryOperation.DESCRIPTOR.getInstance().init(this);
		LEqualityNumberBinaryOperation.DESCRIPTOR.getInstance().init(this);
		LInequalityNumberBinaryOperation.DESCRIPTOR.getInstance().init(this);
		LGreaterThanEqualsNumberBinaryOperation.DESCRIPTOR.getInstance().init(this);
		LLessThanEqualsNumberBinaryOperation.DESCRIPTOR.getInstance().init(this);
		LGreaterThanNumberBinaryOperation.DESCRIPTOR.getInstance().init(this);
		LLessThanNumberBinaryOperation.DESCRIPTOR.getInstance().init(this);
	}
}
