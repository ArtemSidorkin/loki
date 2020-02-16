package loki.runtime.util;

import loki.execution.Execution;
import loki.runtime.constant.LBinaryOperator;
import loki.runtime.unit.unit.LUnit;

public class LErrors
{
	public static void unitShouldHaveType(Object unit, String type)
	{
		printErrorAndExit(String.format("Unit \"%s\" should have type \"%s\"", unit, type));
	}

	public static void resultOfOperationForUnitShouldHaveType(String operation, Object unit, String type)
	{
		printErrorAndExit(
			String.format("Result of operation \"%s\" of unit \"%s\" should have type \"%s\"", operation, unit, type)
		);
	}

	public static void binaryOperatorIsNotDefinedForUnits(LBinaryOperator operator, LUnit unit1, LUnit unit2)
	{
		printErrorAndExit(
			String.format("Binary operator \"%s\" is not defined for units \"%s\" and \"%s\"", operator, unit1, unit2)
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
