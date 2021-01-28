package loki.runtime.unit.data.bool;

import loki.runtime.marker.Prototype;
import loki.runtime.unit.data.LString;
import loki.runtime.unit.data.bool.member.operation.binary.LConjunction;
import loki.runtime.unit.data.bool.member.operation.binary.LDisjunction;
import loki.runtime.unit.data.bool.member.operation.unary.LNegation;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unit.unit.member.operation.binary.LEquality;
import loki.runtime.unitdescriptor.LInstanceDescriptor;
import loki.runtime.unitdescriptor.LPrototypeDescriptor;

import static loki.runtime.error.LErrors.operandHasWrongType;
import static loki.runtime.unit.member.operation.LOperandPosition.RIGHT;

public class LBoolean extends LUnit
{
	public static final LPrototypeDescriptor<LBoolean> DESCRIPTOR =
		new LPrototypeDescriptor<>("Boolean", "BooleanPrototype", LBoolean.class, LBoolean::new);

	public static final LInstanceDescriptor<LBoolean> TRUE = createInstanceDescriptor(true);
	public static final LInstanceDescriptor<LBoolean> FALSE = createInstanceDescriptor(false);

	private boolean value;

	private LBoolean(boolean value)
	{
		super(DESCRIPTOR.getUnitType());

		this.value = value;

		_addParents(DESCRIPTOR.getPrototype());
	}

	@Prototype
	private LBoolean()
	{
		super(DESCRIPTOR.getPrototypeType());

		initializeBuiltins();
	}

	public static LBoolean trueInstance()
	{
		return TRUE.getInstance();
	}

	public static LBoolean falseInstance()
	{
		return FALSE.getInstance();
	}

	public static LBoolean valueOf(boolean value)
	{
		return value ? TRUE.getInstance() : FALSE.getInstance();
	}

	private static LInstanceDescriptor<LBoolean> createInstanceDescriptor(boolean value)
	{
		return new LInstanceDescriptor<>(String.valueOf(value), LBoolean.class, () -> new LBoolean(value));
	}

	public boolean getValue()
	{
		return value;
	}

	public LBoolean invert()
	{
		return valueOf(!value);
	}

	@Override
	public LNumber _hashCode()
	{
		return new LNumber(Boolean.hashCode(value));
	}

	@Override
	public LBoolean _equals(LUnit unit)
	{
		boolean value = unit.asType(DESCRIPTOR, operandHasWrongType(this, LEquality.DESCRIPTOR, RIGHT)).value;

		return LBoolean.valueOf(this.value == value);
	}

	@Override
	public LString _toString()
	{
		return new LString(String.valueOf(value));
	}

	private void initializeBuiltins()
	{
		addMember(LNegation.DESCRIPTOR);
		addMember(LConjunction.DESCRIPTOR);
		addMember(LDisjunction.DESCRIPTOR);
	}
}
