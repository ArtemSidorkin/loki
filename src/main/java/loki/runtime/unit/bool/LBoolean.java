package loki.runtime.unit.bool;

import loki.runtime.unit.LString;
import loki.runtime.unit.bool.member.operation.binary.LAndBooleanBinaryOperation;
import loki.runtime.unit.bool.member.operation.binary.LOrBooleanBinaryOperation;
import loki.runtime.unit.bool.member.operation.unary.LNegationBooleanUnaryOperation;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LBoolean extends LUnit
{
	public static final String TYPE_NAME = "Boolean";
	public static final LType TYPE = new LType(TYPE_NAME, LBoolean.class);

	public static final String PROTOTYPE_NAME = "BooleanPrototype";
	public static final LType PROTO_TYPE = new LType(PROTOTYPE_NAME, LBoolean.class);
	public static final LBoolean PROTOTYPE = new LBoolean();

	public static final String TRUE_NAME = "true";
	public static final String FALSE_NAME = "false";

	public static final LBoolean TRUE = new LBoolean(true);
	public static final LBoolean FALSE = new LBoolean(false);

	private boolean value;

	private LBoolean(boolean value)
	{
		super(TYPE);

		this.value = value;

		_addParents(LBoolean.PROTOTYPE);
	}

	private LBoolean()
	{
		super(PROTO_TYPE);

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
		LNegationBooleanUnaryOperation.INSTANCE.init(this);
		LAndBooleanBinaryOperation.INSTANCE.init(this);
		LOrBooleanBinaryOperation.INSTANCE.init(this);
	}
}
