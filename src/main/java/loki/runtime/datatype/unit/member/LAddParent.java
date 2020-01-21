package loki.runtime.datatype.unit.member;

import loki.runtime.constant.LUnitMember;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LMember;
import loki.runtime.datatype.type.LType;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.util.Nullable;

public class LAddParent extends LMember
{
	public static final LAddParent instance = new LAddParent();

	private LAddParent()
	{
		super(new LType(LUnitMember.ADD_PARENT.name));
	}

	@Override
	public LUnit call(LUnit host, @Nullable LUnit[] parameters)
	{
		for (LUnit parent : parameters) host.addParent(parent);

		return host;
	}
}
