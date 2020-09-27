package loki.runtime.unit.unit.member.method;

import loki.runtime.unit.member.LUnitMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LSetIndexedItem extends LUnitMember<LSetIndexedItem>
{
	public static final LInstanceDescriptor<LSetIndexedItem> DESCRIPTOR =
		new LInstanceDescriptor<>("setIndexedItem", LSetIndexedItem.class, LSetIndexedItem::new);

	private LSetIndexedItem()
	{
		super(DESCRIPTOR);
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		return host._setIndexedItem(parameters);
	}
}
