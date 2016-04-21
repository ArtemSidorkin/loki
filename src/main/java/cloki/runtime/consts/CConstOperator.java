package cloki.runtime.consts;

public enum CConstOperator
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

	public String sign;

	CConstOperator(String sign)
	{
		this.sign = sign;
	}

	@Override
	public String toString()
	{
		return sign;
	}
}
