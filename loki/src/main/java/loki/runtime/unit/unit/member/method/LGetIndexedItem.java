package loki.runtime.unit.unit.member.method;

import loki.runtime.unit.member.LUnitMember;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;

public class LGetIndexedItem extends LUnitMember<LGetIndexedItem>
{
	public static final LInstanceDescriptor<LGetIndexedItem> DESCRIPTOR =
		new LInstanceDescriptor<>("getIndexedItem", LGetIndexedItem.class, LGetIndexedItem::new);

	private LGetIndexedItem()
	{
		super(DESCRIPTOR);
	}

	@Override
	public LUnit call(LUnit host, LUnit... parameters)
	{
		return host._getIndexedItem(parameters);
	}
}
