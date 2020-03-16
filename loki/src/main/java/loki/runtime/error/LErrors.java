package loki.runtime.error;

import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;

public class LErrors
{
	public static void operandShouldHaveType(Object unit, LType type)
	{
		throwException(String.format("Unit \"%s\" should have type \"%s\"", unit, type));
	}

	public static void resultOfOperationOfUnitShouldHaveType(LType operationType, Object unit, LType type)
	{
		throwException(
			String
				.format("Result of operation \"%s\" of unit \"%s\" should have type \"%s\"", operationType, unit, type)
		);
	}

	public static void operandsShouldHaveTypes(LUnit leftOperand,
											   LType leftOperandType,
											   LUnit rightOperand,
											   LType rightOperandType)
	{
		throwException(
			String
				.format("Left operand %s should have type %s, right operand %s should have type %s",
					leftOperand,
					leftOperandType,
					rightOperand,
					rightOperandType
				)
		);
	}

	public static void parameterIsMissedForUnit(int parameterIndex, LUnit unit)
	{
		throwException(String.format("Parameter \"%s\" is missed for unit \"%s\"", parameterIndex, unit));
	}

	public static void unitDoesNotHaveItemWithIndex(LUnit unit, Object index)
	{
		throwException(String.format("Unit \"%s\" does not have item with index \"%s\"", unit, index));
	}

	public static void actionIsNotAllowedForUnit(String action, LUnit unit)
	{
		throwException(String.format("%s is not allowed for unit \"%s\"", action, unit));
	}

	private static void throwException(String error)
	{
		throw new LLokiErrorException(error);
	}
}
