package cloki.runtime.datatypes;

import cloki.runtime.consts.CConstDataUnit;
import cloki.runtime.unitcontexts.CUnitContext;
import cloki.runtime.utils.CErrors;
import cloki.runtime.utils.Nullable;

import java.util.function.Consumer;

public class CUndefined extends CUnit
{
	public static final CUndefined instance = new CUndefined();

	private CUndefined()
	{
		super(new CType(CConstDataUnit.UNDEFINED.name));
	}

	@Override
	public CUnit addParent(CUnit parent)
	{
		CErrors.printError("Inheriting from \"undefined\"!");
		return super.addParent(parent);
	}

	@Override
	public CUnit getSuperMember(String superMemberName)
	{
		CErrors.printError("Getting supper member from \"undefined\"!");
		return super.getSuperMember(superMemberName);
	}

	@Override
	public CUnit getMember(String memberName)
	{
		CErrors.printError("Getting member from \"undefined\"!");
		return super.getMember(memberName);
	}

	@Override
	public CUnit setMember(String memberName, CUnit member)
	{
		CErrors.printError("Setting member to \"undefined\"!");
		return super.setMember(memberName, member);
	}

	@Override
	public CUnit instantiate(CUnit[] parameters, CUnitContext unitContext, Consumer<CUnit> saver)
	{
		CErrors.printError("Instantiating \"undefined\"!");
		return super.instantiate(parameters, unitContext, saver);
	}

	@Override
	public CUnit call(CUnit host, CUnit[] parameters, CUnitContext unitContext)
	{
		CErrors.printError("Calling \"undefined\"!");
		return super.call(host, parameters, unitContext);
	}

	@Override
	public CUnit callMember(String memberName, CUnit[] parameters, CUnitContext unitContext)
	{
		CErrors.printError("Calling member of \"undefined\"!");
		return super.callMember(memberName, parameters, unitContext);
	}

	@Nullable
	@Override
	public <T extends CUnit> T asType(CType type)
	{
		CErrors.printError("Calling \"asType\" from \"undefined\"!");
		return super.asType(type);
	}

	@Override
	public CUnit getIndexedItem(CUnit[] parameters)
	{
		CErrors.printError("Calling \"getIndexedItem\" from \"undefined\"!");
		return super.getIndexedItem(parameters);
	}

	@Override
	public int hashCode()
	{
		CErrors.printError("Calling \"hashCode\" from \"undefined\"!");
		return super.hashCode();
	}

	@Override
	public boolean equals(Object object)
	{
		CErrors.printError("Calling \"equals\" from \"undefined\"!");
		return super.equals(object);
	}

}
