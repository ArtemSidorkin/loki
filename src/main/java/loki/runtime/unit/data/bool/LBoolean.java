package loki.runtime.unit.data.bool;

import loki.runtime.unit.data.LString;
import loki.runtime.unit.data.bool.member.operation.binary.LAndBooleanBinaryOperation;
import loki.runtime.unit.data.bool.member.operation.binary.LOrBooleanBinaryOperation;
import loki.runtime.unit.data.bool.member.operation.unary.LNegationBooleanUnaryOperation;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LDataUnitDescriptor;
import loki.runtime.unitdescriptor.LEnumerationUnitDescriptor;
import loki.runtime.util.Prototype;

public class LBoolean extends LUnit
{
	public static final LDataUnitDescriptor<LBoolean> DESCRIPTOR =
		new LDataUnitDescriptor<>("Boolean", "BooleanPrototype", LBoolean.class, LBoolean::new);

	public static final LEnumerationUnitDescriptor<LBoolean> TRUE =
		new LEnumerationUnitDescriptor<>("true", new LBoolean(true));

	public static final LEnumerationUnitDescriptor<LBoolean> FALSE =
		new LEnumerationUnitDescriptor<>("false", new LBoolean(false));

	private boolean value;

	private LBoolean(boolean value)
	{
		super(DESCRIPTOR.getType());

		this.value = value;

		_addParents(DESCRIPTOR.getPrototype());
	}

	@Prototype
	private LBoolean()
	{
		super(DESCRIPTOR.getPrototypeType());

		initializeBuiltins();
	}

	public static LBoolean valueOf(boolean value)
	{
		return value ? TRUE.getInstance() : FALSE.getInstance();
	}

	public boolean getValue()
	{
		return value;
	}

	@Override
	public LNumber _hashCode()
	{
		return new LNumber(Boolean.hashCode(value));
	}

	@Override
	public LBoolean _equals(LUnit unit)
	{
		LBoolean boolean_ = valueOf(unit.toBoolean());

		return LBoolean.valueOf(value == boolean_.value);
	}

	@Override
	public LString _toString()
	{
		return new LString(String.valueOf(value));
	}

	private void initializeBuiltins()
	{
		addMember(LNegationBooleanUnaryOperation.DESCRIPTOR.getInstance());
		addMember(LAndBooleanBinaryOperation.DESCRIPTOR.getInstance());
		addMember(LOrBooleanBinaryOperation.DESCRIPTOR.getInstance());
	}
}
