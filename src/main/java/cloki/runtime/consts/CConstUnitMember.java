package cloki.runtime.consts;

public enum CConstUnitMember
{
	NEW("new"),
	ADD_PARENT("addParent"),
	GET_SUPER_MEMBER("getSuperMember"),
	GET_INDEX_ITEM("getIndexedItem"),
	SET_INDEX_ITEM("setIndexedItem"),
	GET_TYPE("getType"),
	TO_STRING("toString"),
	HASH_CODE("hashCode"),
	EQUALS("equals");

	public String name;

	CConstUnitMember(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
