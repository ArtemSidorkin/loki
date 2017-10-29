package cloki.runtime.datatype;

import cloki.runtime.builtins.LBuiltins;
import cloki.runtime.consts.CConstTypes;

public class LNumberPrototype extends LUnit
{
	public static final LNumberPrototype instance = new LNumberPrototype();

	private final double value;

	protected LNumberPrototype(double value)
	{
		super(CConstTypes.NUMBER);
		this.value = value;
	}

	private LNumberPrototype()
	{
		super(CConstTypes.NUMBER_PROTOTYPE);
		LBuiltins.initNumberPrototype(this);
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
	public boolean _equals(LUnit unit)
	{
		LNumber number = unit.asType(CConstTypes.NUMBER);
		return number != null && getValue() == number.getValue();
	}

	@Override
	public String _toString()
	{
		if (value == Math.floor(value)) return String.valueOf((long)value);
		else return String.valueOf(value);
	}
}
