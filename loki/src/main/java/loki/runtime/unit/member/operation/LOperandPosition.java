package loki.runtime.unit.member.operation;

public enum LOperandPosition
{
	LEFT, RIGHT, ONLY;

	@Override
	public String toString()
	{
		return super.toString().toLowerCase();
	}
}
