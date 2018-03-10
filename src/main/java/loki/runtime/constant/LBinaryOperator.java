package loki.runtime.constant;

public enum LBinaryOperator
{
	STAR("*"),
	SLASH("/"),
	PLUS("+"),
	MINUS("-"),
	EQUALS_EQUALS("=="),
	BANG_EQUALS("!="),
	GREATER_THAN_EQUALS(">="),
	LESS_THAN_EQUALS("<="),
	GREATER_THAN(">"),
	LESS_THAN("<"),
	AMPERSAND_AMPERSAND("&&"),
	PIPE_PIPE("||");

	public String symbol;

	LBinaryOperator(String symbol)
	{
		this.symbol = symbol;
	}

	@Override
	public String toString()
	{
		return symbol;
	}
}
