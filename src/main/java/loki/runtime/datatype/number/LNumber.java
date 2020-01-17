package loki.runtime.datatype.number;

import loki.runtime.constant.LTypes;
import loki.runtime.datatype.number.operation.binary.*;
import loki.runtime.datatype.unit.LUnit;
import loki.runtime.datatype.number.operation.unary.LNumericNegationNumberUnaryOperation;


public class LNumber extends LUnit
{
	public static final LNumber prototype = new LNumber();

	public final double value;

	public LNumber(double value)
	{
		super(LTypes.NUMBER);
		this.value = value;
		addParent(prototype);
	}

	private LNumber()
	{
		super(LTypes.NUMBER_PROTOTYPE);
		value = 0;
		initBuiltins();
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
