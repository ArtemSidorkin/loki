package loki.runtime.util;

import loki.execution.Execution;
import loki.runtime.unit.type.LType;
import loki.runtime.unit.unit.LUnit;

public class LErrors
{
	public static void operandShouldHaveType(Object unit, LType type)
	{
		printErrorAndExit(String.format("Unit \"%s\" should have type \"%s\"", unit, type));
	}

	public static void resultOfOperationOfUnitShouldHaveType(LType operationType, Object unit, LType type)
	{
		printErrorAndExit(
			String
				.format("Result of operation \"%s\" of unit \"%s\" should have type \"%s\"", operationType, unit, type)
		);
	}

	public static void operandsShouldHaveTypes(LUnit leftOperand,
											   LType leftOperandType,
											   LUnit rightOperand,
											   LType rightOperandType)
	{
		printErrorAndExit(
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
		printErrorAndExit(String.format("Parameter \"%s\" is missed for unit \"%s\"", parameterIndex, unit));
	}

	public static void UnitDoesNotHaveItemWithIndex(LUnit unit, Object index)
	{
		printErrorAndExit(String.format("Unit \"%s\" does not have item with index \"%s\"", unit, index));
	}

	public static void printErrorAndExit(String error)
	{
		Execution.executor().errorPrintStream().println(error);

		exit();
	}

	private static void exit()
	{
		System.exit(-1);
	}
}
