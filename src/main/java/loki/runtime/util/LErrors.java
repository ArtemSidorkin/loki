package loki.runtime.util;

import loki.execution.Execution;
import loki.runtime.constant.LBinaryOperator;
import loki.runtime.datatype.unit.LUnit;

public class LErrors
{
	public static void unitDoesNotBelongToType(Object unit, Object type)
	{
		printErrorAndExit(String.format("\"%s\" is not \"%s\"", unit, type));
	}

	public static void unitOperationIsNotCorrect(Object unit, String operation)
	{
		printErrorAndExit(String.format("\"%s\" implementation of \"%s\" is not correct", unit, operation));
	}

	public static void operatorIsNotDefinedForUnits(LBinaryOperator operator, LUnit unit1, LUnit unit2)
	{
		printErrorAndExit(String.format("Operator \"%s\" is not defined for \"%s\" and \"%s\"", operator, unit1, unit2));
	}

	public static void parameterIsMissedForUnit(int parameterIndex, LUnit unit)
	{
		printErrorAndExit(String.format("Parameter \"%s\" is missed for \"%s\"", parameterIndex, unit));
	}

	public static void itemWithIndexDoesNotExist(Object index)
	{
		printErrorAndExit(String.format("Item with index \"%s\" does not exist", index));
	}

	public static void indexIsUndefined()
	{
		printErrorAndExit("Index is undefined");
	}

	public static void indexValueIsUndefined()
	{
		printErrorAndExit("Index value is undefined");
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
