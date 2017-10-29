package cloki.runtime.utils;

import cloki.execution.CExecution;
import cloki.runtime.constant.LBinaryOperator;
import cloki.runtime.datatype.LUnit;

public class LErrors
{
	public static void printErrorUnitDoesNotBelongToType(Object unit, Object type)
	{
		printError(String.format("\"%s\" is not \"%s\"", unit, type));
	}

	public static void printErrorOperatorIsNotDefinedForUnits(LBinaryOperator operator, LUnit unit1, LUnit unit2)
	{
		printError(String.format("Operator \"%s\" is not defined for \"%s\" and \"%s\"", operator, unit1, unit2));
	}

	public static void printErrorParameterIsMissedForUnit(int parameterIndex, LUnit unit)
	{
		printError(String.format("Parameter \"%s\" is missed for \"%s\"", parameterIndex, unit));
	}

	public static void printErrorItemWithIndexDoesNotExist(Object index)
	{
		printError(String.format("Item with getIndexedItem \"%s\" does not exist", index));
	}

	public static void printError(String error)
	{
		CExecution.executor().instance().errorPrintStream().println(error);
	}
}
