package loki.runtime.datatype;

import loki.runtime.constant.LDataUnit;
import loki.runtime.context.LUnitContext;
import loki.runtime.utils.LErrors;
import loki.runtime.utils.Nullable;

import java.util.function.Consumer;

public class LUndefined extends LUnit
{
	public static final LUndefined instance = new LUndefined();

	private LUndefined()
	{
		super(new LType(LDataUnit.UNDEFINED.name));
	}

	@Override
	public LUnit addParent(LUnit parent)
	{
		LErrors.printError("Inheriting from \"undefined\"!");
		return super.addParent(parent);
	}

	@Override
	public LUnit getSuperMember(String superMemberName)
	{
		LErrors.printError("Getting supper member from \"undefined\"!");
		return super.getSuperMember(superMemberName);
	}

	@Override
	public LUnit getMember(String memberName)
	{
		LErrors.printError("Getting member from \"undefined\"!");
		return super.getMember(memberName);
	}

	@Override
	public LUnit setMember(String memberName, LUnit member)
	{
		LErrors.printError("Setting member to \"undefined\"!");
		return super.setMember(memberName, member);
	}

	@Override
	public LUnit instantiate(LUnit[] parameters, LUnitContext unitContext, Consumer<LUnit> saver)
	{
		LErrors.printError("Instantiating \"undefined\"!");
		return super.instantiate(parameters, unitContext, saver);
	}

	@Override
	public LUnit call(LUnit host, LUnit[] parameters, LUnitContext unitContext)
	{
		LErrors.printError("Calling \"undefined\"!");
		return super.call(host, parameters, unitContext);
	}

	@Override
	public LUnit callMember(String memberName, LUnit[] parameters, LUnitContext unitContext)
	{
		LErrors.printError("Calling member of \"undefined\"!");
		return super.callMember(memberName, parameters, unitContext);
	}

	@Nullable
	@Override
	public <T extends LUnit> T asType(LType type)
	{
		LErrors.printError("Calling \"asType\" from \"undefined\"!");
		return super.asType(type);
	}

	@Override
	public LUnit getIndexedItem(LUnit[] parameters)
	{
		LErrors.printError("Calling \"getIndexedItem\" from \"undefined\"!");
		return super.getIndexedItem(parameters);
	}

	@Override
	public int hashCode()
	{
		LErrors.printError("Calling \"hashCode\" from \"undefined\"!");
		return super.hashCode();
	}

	@Override
	public boolean equals(Object object)
	{
		LErrors.printError("Calling \"equals\" from \"undefined\"!");
		return super.equals(object);
	}

}
