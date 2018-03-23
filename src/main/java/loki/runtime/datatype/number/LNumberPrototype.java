package loki.runtime.datatype.number;

import loki.runtime.LSettings;
import loki.runtime.constant.LTypes;
import loki.runtime.context.LUnitContext;
import loki.runtime.datatype.LUnit;
import loki.runtime.datatype.number.member.internal.LGetTypeNumberInternalMember;
import loki.runtime.datatype.number.member.internal.LHashCodeNumberInternalMember;
import loki.runtime.datatype.number.member.internal.LNumberInternalMember;
import loki.runtime.datatype.number.member.internal.LToStringNumberInternalMember;
import loki.runtime.datatype.number.member.operation.binary.*;
import loki.runtime.datatype.number.member.operation.internal.*;
import loki.runtime.datatype.number.member.operation.unary.LNumericNegationNumberUnaryOperation;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LNumberPrototype extends LUnit
{
	public static final LNumberPrototype instance = new LNumberPrototype();

	private static final ConcurrentMap<String, LNumberInternalMember> internalMembers =
		new ConcurrentHashMap<String, LNumberInternalMember>(
			LSettings.INTERNAL_MEMBERS_INITIAL_CAPACITY,
			LSettings.INTERNAL_MEMBERS_LOAD_FACTOR,
			LSettings.INTERNAL_MEMBERS_CONCURRENCY_LEVEL
		)
		{{
			LGetTypeNumberInternalMember.instance.initialize(this);
			LHashCodeNumberInternalMember.instance.initialize(this);
			LToStringNumberInternalMember.instance.initialize(this);

			LNumericNegationNumberInternalOperation.instance.initialize(this);
			LNumericNegationNumberInternalOperation.instance.initialize(this);
			LMultiplicationNumberInternalOperation.instance.initialize(this);
			LDivisionNumberInternalOperation.instance.initialize(this);
			LAdditionNumberInternalOperation.instance.initialize(this);
			LSubtractionNumberInternalOperation.instance.initialize(this);
			LEqualityNumberInternalOperation.instance.initialize(this);
			LInequalityNumberInternalOperation.instance.initialize(this);
			LGreaterThanEqualsNumberInternalOperation.instance.initialize(this);
			LLessThanEqualsNumberInternalOperation.instance.initialize(this);
			LGreaterThanNumberInternalOperation.instance.initialize(this);
			LLessThanNumberInternalOperation.instance.initialize(this);
		}};

	public final double value;

	protected LNumberPrototype(double value)
	{
		this.value = value;
	}

	private LNumberPrototype()
	{
		super(LTypes.NUMBER_PROTOTYPE);
		value = 0;
		initBuiltins();
	}

	@Override
	public LUnit setMember(String memberName, LUnit member)
	{
		if (internalMembers != null) internalMembers.remove(memberName);

		return super.setMember(memberName, member);
	}

	@Override
	public LUnit callMember(String memberName, LUnit[] parameters, LUnitContext unitContext)
	{
		LNumberInternalMember internalOperation = internalMembers.get(memberName);

		if (internalOperation != null) return internalOperation.apply(value, parameters);

		return super.callMember(memberName, parameters, unitContext);
	}

	@Override
	public int _hashCode()
	{
		return Double.hashCode(value);
	}

	@Override
	public boolean _equals(LUnit unit)
	{
		LNumber number = unit.asType(LTypes.NUMBER);

		return number != null && value == number.value;
	}

	@Override
	public String _toString()
	{
		return value == Math.floor(value) ? String.valueOf((long)value) : String.valueOf(value);
	}

	private void initBuiltins()
	{
		LNumericNegationNumberUnaryOperation.instance.init(this);
		LMultiplicationNumberBinaryOperation.instance.init(this);
		LDivisionNumberBinaryOperation.instance.init(this);
		LAdditionNumberBinaryOperation.instance.init(this);
		LSubtractionNumberBinaryOperation.instance.init(this);
		LEqualityNumberBinaryOperation.instance.init(this);
		LInequalityNumberBinaryOperation.instance.init(this);
		LGreaterThanEqualsNumberBinaryOperation.instance.init(this);
		LLessThanEqualsNumberBinaryOperation.instance.init(this);
		LGreaterThanNumberBinaryOperation.instance.init(this);
		LLessThanNumberBinaryOperation.instance.init(this);
	}
}
