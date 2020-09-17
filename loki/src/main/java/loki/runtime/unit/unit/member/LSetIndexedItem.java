package loki.runtime.unit.unit.member;

import loki.runtime.unit.member.LMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceUnitDescriptor;

public class LSetIndexedItem extends LMember
{
	public static final LInstanceUnitDescriptor<LSetIndexedItem> DESCRIPTOR =
		new LInstanceUnitDescriptor<>("setIndexedItem", LSetIndexedItem.class, LSetIndexedItem::new);

	private LSetIndexedItem()
	{
		super(DESCRIPTOR.getType());
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		return host._setIndexedItem(parameters);
	}
}
