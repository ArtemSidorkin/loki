package loki.runtime.unit.member.operation;

public enum LOperandPosition
{
	LEFT, RIGHT, SOLE;

	@Override
	public String toString()
	{
		return super.toString().toLowerCase();
	}
}
