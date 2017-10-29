package cloki.runtime.datatype;


import cloki.runtime.builtins.LBuiltins;
import cloki.runtime.consts.CConstTypes;

public class LBooleanPrototype extends LUnit
{
	public static final LBooleanPrototype instance = new LBooleanPrototype();

	private boolean value;

	protected LBooleanPrototype(boolean value)
	{
		super(CConstTypes.BOOLEAN);
		this.value = value;
	}

	private LBooleanPrototype()
	{
		super(CConstTypes.BOOLEAN_PROTOTYPE);
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
		LBoolean boolean_ = unit.asType(CConstTypes.BOOLEAN);
		return boolean_ != null && getValue() == boolean_.getValue();
	}
}
