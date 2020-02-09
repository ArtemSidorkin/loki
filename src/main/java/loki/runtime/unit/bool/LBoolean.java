package loki.runtime.unit.bool;

import loki.runtime.constant.LTypes;
import loki.runtime.unit.LString;
import loki.runtime.unit.bool.member.operation.binary.LAndBooleanBinaryOperation;
import loki.runtime.unit.bool.member.operation.binary.LOrBooleanBinaryOperation;
import loki.runtime.unit.bool.member.operation.unary.LNegationBooleanUnaryOperation;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;

public class LBoolean extends LUnit
{
	public static final LBoolean PROTOTYPE = new LBoolean();

	public static final LBoolean TRUE = new LBoolean(true);
	public static final LBoolean FALSE = new LBoolean(false);

	private boolean value;

	private LBoolean(boolean value)
	{
		super(LTypes.BOOLEAN);
		this.value = value;
		_addParents(LBoolean.PROTOTYPE);
	}

	private LBoolean()
	{
		super(LTypes.BOOLEAN_PROTOTYPE);
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
		LNegationBooleanUnaryOperation.instance.init(this);
		LAndBooleanBinaryOperation.instance.init(this);
		LOrBooleanBinaryOperation.instance.init(this);
	}
}
