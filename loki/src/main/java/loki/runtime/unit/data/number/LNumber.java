package loki.runtime.unit.data.number;

import loki.runtime.marker.Prototype;
import loki.runtime.marker.compilerapi.number.NumberConstructor;
import loki.runtime.unit.data.LString;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.member.operation.binary.LAddition;
import loki.runtime.unit.data.number.member.operation.binary.LDivision;
import loki.runtime.unit.data.number.member.operation.binary.LGreaterThan;
import loki.runtime.unit.data.number.member.operation.binary.LGreaterThanEquals;
import loki.runtime.unit.data.number.member.operation.binary.LInequality;
import loki.runtime.unit.data.number.member.operation.binary.LLessThan;
import loki.runtime.unit.data.number.member.operation.binary.LLessThanEquals;
import loki.runtime.unit.data.number.member.operation.binary.LMultiplication;
import loki.runtime.unit.data.number.member.operation.binary.LSubtraction;
import loki.runtime.unit.data.number.member.operation.unary.LNegation;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LPrototypeDescriptor;

public class LNumber extends LUnit
{
	public static final LPrototypeDescriptor<LNumber> DESCRIPTOR =
		new LPrototypeDescriptor<>("Number", "NumberPrototype", LNumber.class, LNumber::new);

	private final double value;

	@NumberConstructor
	public LNumber(double value)
	{
		super(DESCRIPTOR);

		this.value = value;

		_addParents(DESCRIPTOR);
	}

	@Prototype
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

	public int intValue()
	{
		return (int)value;
	}

	@Override
	public LNumber _hashCode()
	{
		return new LNumber(Double.hashCode(value));
	}

	@Override
	public LBoolean _equals(LUnit unit)
	{
		LNumber number = unit.asType(DESCRIPTOR);

		return LBoolean.valueOf(number != null && value == number.value);
	}

	@Override
	public LString _toString()
	{
		return new LString(value == Math.floor(value) ? String.valueOf((long)value) : String.valueOf(value));
	}

	private void initBuiltins()
	{
		initializeBuiltins(
			LNegation.DESCRIPTOR,
			LMultiplication.DESCRIPTOR,
			LDivision.DESCRIPTOR,
			LAddition.DESCRIPTOR,
			LSubtraction.DESCRIPTOR,
			LInequality.DESCRIPTOR,
			LGreaterThanEquals.DESCRIPTOR,
			LLessThanEquals.DESCRIPTOR,
			LGreaterThan.DESCRIPTOR,
			LLessThan.DESCRIPTOR
		);
	}
}
