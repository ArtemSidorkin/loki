package cloki.runtime.datatypes;

import cloki.runtime.builtins.CBuiltins;
import cloki.runtime.consts.CConstTypes;

public class CNumberPrototype extends CUnit
{
	public static final CNumberPrototype instance = new CNumberPrototype();

	private final double value;

	protected CNumberPrototype(double value)
	{
		super(CConstTypes.NUMBER);
		this.value = value;
	}

	private CNumberPrototype()
	{
		super(CConstTypes.NUMBER_PROTOTYPE);
		CBuiltins.initNumberPrototype(this);
		value = 0;
	}

	public double getValue()
	{
		return value;
	}

	@Override
	public int _hashCode()
	{
		return Double.hashCode(value);
	}

	@Override
	public boolean _equals(CUnit unit)
	{
		CNumber nmbr = unit.asType(CConstTypes.NUMBER);

		return nmbr != null && getValue() == nmbr.getValue();
	}

	@Override
	public String _toString()
	{
		if (value == Math.floor(value)) return String.valueOf((long)value);
		else return String.valueOf(value);
	}
}
