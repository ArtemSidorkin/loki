package cloki.runtime.constant;

public enum LUnaryOperator
{
	BANG("!_"),
	MINUS("-_");

	public String symbol;

	LUnaryOperator(String symbol)
	{
		this.symbol = symbol;
	}

	@Override
	public String toString()
	{
		return symbol;
	}
}
