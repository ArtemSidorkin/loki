package loki.runtime.datatype.number;

import loki.runtime.LSettings;
import loki.runtime.constant.LBinaryOperator;
import loki.runtime.constant.LTypes;
import loki.runtime.constant.LUnaryOperator;
import loki.runtime.constant.LUnitMember;
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
			put(LUnitMember.GET_TYPE.name, LGetTypeNumberInternalMember.instance);
			put(LUnitMember.HASH_CODE.name, LHashCodeNumberInternalMember.instance);
			put(LUnitMember.TO_STRING.name, LToStringNumberInternalMember.instance);

			put(LUnaryOperator.MINUS.symbol, LNumericNegationNumberInternalOperation.instance);
			put(LBinaryOperator.STAR.symbol, LMultiplicationNumberInternalOperation.instance);
			put(LBinaryOperator.SLASH.symbol, LDivisionNumberInternalOperation.instance);
			put(LBinaryOperator.PLUS.symbol, LAdditionNumberInternalOperation.instance);
			put(LBinaryOperator.MINUS.symbol, LSubtractionNumberInternalOperation.instance);
			put(LBinaryOperator.EQUALS_EQUALS.symbol, LEqualityNumberInternalOperation.instance);
			put(LBinaryOperator.BANG_EQUALS.symbol, LInequalityNumberInternalOperation.instance);
			put(LBinaryOperator.GREATER_THAN_EQUALS.symbol, LGreaterThanEqualsNumberInternalOperation.instance);
			put(LBinaryOperator.LESS_THAN_EQUALS.symbol, LLessThanEqualsNumberInternalOperation.instance);
			put(LBinaryOperator.GREATER_THAN.symbol, LGreaterThanNumberInternalOperation.instance);
			put(LBinaryOperator.LESS_THAN.symbol, LLessThanNumberInternalOperation.instance);
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
