package cloki.runtime.datatypes;


import cloki.runtime.builtins.CBuiltins;
import cloki.runtime.consts.CConstTypes;

public class CBooleanPrototype extends CUnit
{
	public static final CBooleanPrototype instance = new CBooleanPrototype();

	private boolean value;

	protected CBooleanPrototype(boolean value)
	{
		super(CConstTypes.BOOLEAN);
		this.value = value;
	}

	private CBooleanPrototype()
	{
		super(CConstTypes.BOOLEAN_PROTOTYPE);
		CBuiltins.initBooleanPrototype(this);
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
	public boolean _equals(CUnit unit)
	{
		CBoolean bln = unit.asType(CConstTypes.BOOLEAN);

		return bln != null && getValue() == bln.getValue();
	}
}
