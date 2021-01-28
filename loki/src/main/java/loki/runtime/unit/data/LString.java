package loki.runtime.unit.data;

import loki.runtime.marker.Prototype;
import loki.runtime.marker.compilerapi.string.StringConstructor;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unit.unit.member.operation.binary.LEquality;
import loki.runtime.unitdescriptor.LPrototypeDescriptor;

import static loki.runtime.error.LErrors.operandHasWrongType;
import static loki.runtime.unit.member.operation.LOperandPosition.RIGHT;

public class LString extends LUnit
{
	public static final LPrototypeDescriptor<LString> DESCRIPTOR =
		new LPrototypeDescriptor<>("String", "StringPrototype", LString.class, LString::new);

	private final String value;

	@StringConstructor
	public LString(String value)
	{
		super(DESCRIPTOR);

		_addParents(DESCRIPTOR.getPrototype());

		this.value = value;
	}

	@Prototype
	private LString()
	{
		super(DESCRIPTOR.getPrototypeType());

		value = "";
	}

	public String getValue()
	{
		return value;
	}

	@Override
	public LNumber _hashCode()
	{
		return new LNumber(value.hashCode());
	}

	@Override
	public LBoolean _equals(LUnit unit)
	{
		String unitValue = unit.asType(DESCRIPTOR, operandHasWrongType(this, LEquality.DESCRIPTOR, RIGHT)).value;

		return LBoolean.valueOf(value.equals(unitValue));
	}

	@Override
	public LString _toString()
	{
		return new LString(value);
	}
}
