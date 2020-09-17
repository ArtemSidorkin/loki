package loki.runtime.unit.unit.member;

import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LGetIndexedItem extends LMember
{
	public static final LInstanceUnitDescriptor<LGetIndexedItem> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("getIndexedItem", LGetIndexedItem.class, LGetIndexedItem::new);

	private LGetIndexedItem()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		return host._getIndexedItem(parameters);
	}
}
