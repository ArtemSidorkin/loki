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
		super(DESCRIPTOR.getPrototypeType());

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
		addMember(LNegationNumberUnaryOperation.DESCRIPTOR.getInstance());
		addMember(LMultiplicationNumberBinaryOperation.DESCRIPTOR.getInstance());
		addMember(LDivisionNumberBinaryOperation.DESCRIPTOR.getInstance());
		addMember(LAdditionNumberBinaryOperation.DESCRIPTOR.getInstance());
		addMember(LSubtractionNumberBinaryOperation.DESCRIPTOR.getInstance());
		addMember(LEqualityNumberBinaryOperation.DESCRIPTOR.getInstance());
		addMember(LInequalityNumberBinaryOperation.DESCRIPTOR.getInstance());
		addMember(LGreaterThanEqualsNumberBinaryOperation.DESCRIPTOR.getInstance());
		addMember(LLessThanEqualsNumberBinaryOperation.DESCRIPTOR.getInstance());
		addMember(LGreaterThanNumberBinaryOperation.DESCRIPTOR.getInstance());
		addMember(LLessThanNumberBinaryOperation.DESCRIPTOR.getInstance());
	}
}
