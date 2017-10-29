package cloki.runtime.datatype;

import cloki.runtime.builtins.LBuiltins;
import cloki.runtime.constant.LTypes;

public class LNumberPrototype extends LUnit
{
	public static final LNumberPrototype instance = new LNumberPrototype();

	private final double value;

	protected LNumberPrototype(double value)
	{
		super(LTypes.NUMBER);
		this.value = value;
	}

	private LNumberPrototype()
	{
		super(LTypes.NUMBER_PROTOTYPE);
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
		LNumber number = unit.asType(LTypes.NUMBER);
		return number != null && getValue() == number.getValue();
	}

	@Override
	public String _toString()
	{
		if (value == Math.floor(value)) return String.valueOf((long)value);
		else return String.valueOf(value);
	}
}
