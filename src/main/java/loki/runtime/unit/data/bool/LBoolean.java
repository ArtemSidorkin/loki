package loki.runtime.unit.data.bool;

import loki.runtime.unit.data.LString;
import loki.runtime.unit.data.bool.member.operation.binary.LAndBooleanBinaryOperation;
import loki.runtime.unit.data.bool.member.operation.binary.LOrBooleanBinaryOperation;
import loki.runtime.unit.data.bool.member.operation.unary.LNegationBooleanUnaryOperation;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LDataUnitDescriptor;

public class LBoolean extends LUnit
{
	public static final LDataUnitDescriptor<LBoolean> DESCRIPTOR =
		new LDataUnitDescriptor<>("Boolean", "BooleanPrototype", LBoolean.class);

	public static final String TRUE_NAME = "true";
	public static final String FALSE_NAME = "false";

	public static final LBoolean TRUE = new LBoolean(true);
	public static final LBoolean FALSE = new LBoolean(false);

	private boolean value;

	private LBoolean(boolean value)
	{
		super(DESCRIPTOR.getType());

		this.value = value;

		_addParents(DESCRIPTOR.getPrototype());
	}

	private LBoolean()
	{
		super(DESCRIPTOR.getPrototypeType());

		initializeBuiltins();
	}

	public static LBoolean valueOf(boolean value)
	{
		return value ? TRUE : FALSE;
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
		LNegationBooleanUnaryOperation.DESCRIPTOR.getInstance().init(this);
		LAndBooleanBinaryOperation.DESCRIPTOR.getInstance().init(this);
		LOrBooleanBinaryOperation.DESCRIPTOR.getInstance().init(this);
	}
}
