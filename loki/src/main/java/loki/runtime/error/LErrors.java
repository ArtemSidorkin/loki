package loki.runtime.error;

import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LTypeUnitDescriptor;
import loki.runtime.unitdescriptor.LUnitDescriptor;

import java.util.function.BiConsumer;

public class LErrors
{
	public static <T extends LUnit> BiConsumer<LUnit, LTypeUnitDescriptor<T>> hostOperandHasWrongType(LUnitDescriptor operation)
	{
		return (hostOperand, expectedType) -> hostOperandHasWrongType(hostOperand, operation, expectedType);
	}

	public static void hostOperandHasWrongType(LUnit hostOperand, LUnitDescriptor operation, LTypeUnitDescriptor<?> expectedType)
	{
		hostOperandHasWrongType(hostOperand, operation.getName(), expectedType.getType());
	}

	public static void hostOperandHasWrongType(LUnit hostOperand, String operation, LType expectedType)
	{
		throwException(
			String
				.format(
					"Host operand has wrong type: " +
						"host operand - '%s', " +
						"operation - '%s', " +
						"expected type - '%s'",
					hostOperand,
					operation,
					expectedType
				)
		);
	}

	public static <T extends LUnit> BiConsumer<LUnit, LTypeUnitDescriptor<T>> callbackOperationResultHasWrongType(
		LUnit host, LUnitDescriptor operation, int indexOfCallbackInOperationParameters
	)
	{
		return
			(result, expectedType) ->
				callbackOperationResultHasWrongType(
					host, operation, indexOfCallbackInOperationParameters, result, expectedType
				);
	}

	public static void callbackOperationResultHasWrongType(
		LUnit host,
		LUnitDescriptor operation,
		int indexOfCallbackInOperationParameters,
		LUnit result,
		LTypeUnitDescriptor<?> expectedType
	)
	{
		callbackOperationResultHasWrongType(
			host, operation.getName(), indexOfCallbackInOperationParameters, result, expectedType.getType()
		);
	}

	public static void callbackOperationResultHasWrongType(
		LUnit host, String operation, int indexOfCallbackInOperationParameters, LUnit result, LType expectedType
	)
	{
		throwException(
			String
				.format(
					"Callback operation result has wrong type: " +
					"host - '%s', " +
					"operation - '%s', " +
					"index of callback in operation parameters - '%s', " +
					"result - '%s', " +
					"expected type - '%s'",
					host,
					operation,
					indexOfCallbackInOperationParameters,
					result,
					expectedType
				)
		);
	}

	public static void operandShouldHaveType(Object unit, LType type)
	{
		throwException(String.format("Unit \"%s\" should have type \"%s\"", unit, type));
	}

	public static void unitOperationResultShouldHaveType(LType operationType, Object unit, LType expectedType)
	{
		throwException(
			String
				.format(
					"Result of operation \"%s\" of unit \"%s\" should have type \"%s\"",
					operationType,
					unit,
					expectedType
				)
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
