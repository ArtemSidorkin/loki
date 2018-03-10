package loki.runtime.datatype;


import loki.runtime.builtin.LBuiltins;
import loki.runtime.constant.LTypes;

public class LBooleanPrototype extends LUnit
{
	public static final LBooleanPrototype instance = new LBooleanPrototype();

	private boolean value;

	protected LBooleanPrototype(boolean value)
	{
		super(LTypes.BOOLEAN);
		this.value = value;
	}

	private LBooleanPrototype()
	{
		super(LTypes.BOOLEAN_PROTOTYPE);
		LBuiltins.initBooleanPrototype(this);
	}

	public boolean getValue()
	{
		return value;
	}

	@Override
	public int _hashCode()
	{
		return Boolean.hashCode(value);
	}

	@Override
	public boolean _equals(LUnit unit)
	{
		LBoolean boolean_ = unit.asType(LTypes.BOOLEAN);
		return boolean_ != null && getValue() == boolean_.getValue();
	}
}
