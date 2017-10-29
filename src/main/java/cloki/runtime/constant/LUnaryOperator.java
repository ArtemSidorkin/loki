package cloki.runtime.constant;

public enum LUnaryOperator
{
	BANG("!_"),
	MINUS("-_");

	public String sign;

	LUnaryOperator(String sign)
	{
		this.sign = sign;
	}

	@Override
	public String toString()
	{
		return sign;
	}
}
