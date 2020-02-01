package loki.runtime.constant;

public enum LUnitMember
{
	NEW("new"),
	ADD_PARENTS("addParents"),
	GET_SUPER_MEMBER("getSuperMember"),
	GET_INDEX_ITEM("getIndexedItem"),
	SET_INDEX_ITEM("setIndexedItem"),
	GET_TYPE("getType"),
	TO_STRING("toString"),
	TO_BOOLEAN("toBoolean"),
	HASH_CODE("hashCode"),
	EQUALS("equals");

	public String name;

	LUnitMember(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
