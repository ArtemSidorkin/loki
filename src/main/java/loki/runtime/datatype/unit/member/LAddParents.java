package loki.runtime.datatype.unit.member;

import loki.runtime.constant.LUnitMember;
import loki.runtime.datatype.LMember;
import loki.runtime.datatype.type.LType;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.util.Nullable;

public class LAddParents extends LMember
{
	public static final LAddParents instance = new LAddParents();

	private LAddParents()
	{
		super(new LType(LUnitMember.ADD_PARENTS.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		host._addParents(parameters);

		return host;
	}
}
