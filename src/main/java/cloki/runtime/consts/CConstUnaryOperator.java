package cloki.runtime.consts;

public enum CConstUnaryOperator
{
	BANG("!_"),
	MINUS("-_");

	public String sign;

	CConstUnaryOperator(String sign)
	{
		this.sign = sign;
	}

	@Override
	public String toString()
	{
		return sign;
	}
}
