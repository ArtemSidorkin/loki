package cloki.runtime.datatypes;

import cloki.runtime.consts.CConstTypes;

public class CStringPrototype extends CUnit
{
	public static final CStringPrototype instance = new CStringPrototype();

	private final String value;

	protected CStringPrototype(String value)
	{
		super(CConstTypes.STRING);
		this.value = value;
	}

	private CStringPrototype()
	{
		super(CConstTypes.STRING_PROTOTYPE);
		value = "";
	}

	public String getValue()
	{
		return value;
	}

	@Override
	public int _hashCode()
	{
		return value.hashCode();
	}

	@Override
	public boolean _equals(CUnit unit)
	{
		CString strng = unit.asType(CConstTypes.STRING);

		return strng != null && getValue().equals(strng.getValue());
	}

	@Override
	public String _toString()
	{
		return value;
	}
}
