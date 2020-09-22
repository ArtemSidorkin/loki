package loki.runtime.error;

import loki.runtime.LType;
import loki.runtime.unit.member.operation.LOperandPosition;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LTypeUnitDescriptor;
import loki.runtime.unitdescriptor.LUnitDescriptor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class LErrors
{
	public static <T extends LUnit> BiConsumer<LUnit, LTypeUnitDescriptor<T>> hostHasWrongType(LUnitDescriptor method)
	{
		return (hostOperand, expectedType) -> hostHasWrongType(hostOperand, method, expectedType);
	}

	public static void hostHasWrongType(LUnit host, LUnitDescriptor method, LTypeUnitDescriptor<?> expectedType)
	{
		hostHasWrongType(host, method.getName(), expectedType.getType());
	}

	public static void hostHasWrongType(LUnit host, String method, LType expectedType)
	{
		throwException("Host has a wrong type", "host", host, "method", method, "expected type", expectedType);
	}

	public static <T extends LUnit> BiConsumer<LUnit, LTypeUnitDescriptor<T>> methodParameterHasWrongType(
		LUnit host,
		LUnitDescriptor methodDescriptor,
		int parameterIndex
	)
	{
		return
			(parameterValue, expectedParameterType) ->
				methodParameterHasWrongType(
					host, methodDescriptor, parameterIndex, parameterValue, expectedParameterType
				);
	}

	public static void methodParameterHasWrongType(
		LUnit host,
		LUnitDescriptor methodDescriptor,
		int parameterIndex,
		LUnit parameterValue,
		LTypeUnitDescriptor<?> expectedParameterType
	)
	{
		methodParameterHasWrongType(
			host, methodDescriptor.getName(), parameterIndex, parameterValue, expectedParameterType.getType()
		);
	}

	public static void methodParameterHasWrongType(
		LUnit host, String methodName, int parameterIndex, LUnit parameterValue, LType expectedParameterType
	)
	{
		throwException(
			"Method parameter has a wrong type",
			"host", host,
			"method name", methodName,
			"parameter index", parameterIndex,
			"parameter value", parameterValue,
			"expected parameter type", expectedParameterType
		);
	}

	public static <T extends LUnit> BiConsumer<LUnit, LTypeUnitDescriptor<T>> callbackResultHasWrongType(
		LUnit host, LUnitDescriptor method, int indexOfCallbackInOperationParameters
	)
	{
		return
			(result, expectedType) ->
				callbackResultHasWrongType(host, method, indexOfCallbackInOperationParameters, result, expectedType);
	}

	public static void callbackResultHasWrongType(
		LUnit host,
		LUnitDescriptor method,
		int indexOfCallbackInOperationParameters,
		LUnit result,
		LTypeUnitDescriptor<?> expectedType
	)
	{
		callbackResultHasWrongType(
			host, method.getName(), indexOfCallbackInOperationParameters, result, expectedType.getType()
		);
	}

	public static void callbackResultHasWrongType(
		LUnit host, String method, int indexOfCallbackInOperationParameters, LUnit result, LType expectedType
	)
	{
		throwException(
			"Callback result has a wrong type",
			"host", host,
			"method", method,
			"index of callback in method parameters", indexOfCallbackInOperationParameters,
			"result", result,
			"expected type", expectedType
		);
	}

	public static <T extends LUnit> BiConsumer<LUnit, LTypeUnitDescriptor<T>> methodResultHasWrongType(
		LUnit host, LUnitDescriptor methodDescriptor
	)
	{
		return
			(result, expectedResultType) ->
				methodResultHasWrongType(host, methodDescriptor, result, expectedResultType);
	}

	public static void methodResultHasWrongType(
		LUnit host,
		LUnitDescriptor methodDescriptor,
		LUnit result,
		LTypeUnitDescriptor<?> expectedResultTypeDescriptor
	)
	{
		methodResultHasWrongType(host, methodDescriptor.getName(), result, expectedResultTypeDescriptor.getType());
	}

	public static void methodResultHasWrongType(LUnit host, String methodName, LUnit result, LType expectedResultType)
	{
		throwException(
			"Method result has a wrong type",
			"host", host,
			"method name", methodName,
			"result", result,
			"expected result type", expectedResultType
		);
	}

	public static <T extends LUnit> BiConsumer<LUnit, LTypeUnitDescriptor<T>> operandHasWrongType(
		LUnit host, LUnitDescriptor operationDescriptor, LOperandPosition operandPosition
	)
	{
		return
			(parameterValue, expectedParameterType) ->
				operandHasWrongType(host, operationDescriptor, operandPosition, parameterValue, expectedParameterType);
	}

	public static void operandHasWrongType(
		LUnit host,
		LUnitDescriptor operationDescriptor,
		LOperandPosition operandPosition,
		LUnit operandValue,
		LTypeUnitDescriptor<?> expectedOperandType
	)
	{
		operandHasWrongType(
			host, operationDescriptor.getName(), operandPosition, operandValue, expectedOperandType.getType()
		);
	}

	public static void operandHasWrongType(
		LUnit host,
		String operationName,
		LOperandPosition operandPosition,
		LUnit operandValue,
		LType expectedOperandType
	)
	{
		throwException(
			"Operand has a wrong type",
			"host", host,
			"operation name", operationName,
			"operand position", operandPosition,
			"operand value", operandValue,
			"expected operand type", expectedOperandType
		);
	}

	public static void unitHasWrongType(LUnit unit, LTypeUnitDescriptor<?> expectedUnitTypeDescriptor)
	{
		unitHasWrongType(unit, expectedUnitTypeDescriptor.getType());
	}

	public static void unitHasWrongType(LUnit unit, LType expectedUnitType)
	{
		throwException("Unit has a wrong type", "unit", unit, "expected unit type", expectedUnitType);
	}

	public static void unitHasNoMember(LUnit unit, String memberName)
	{
		throwException("Unit has no member", "unit", unit, "member name", memberName);
	}

	public static void unitHasNoIndexedItem(LUnit unit, Object index)
	{
		throwException("Unit has no indexed item", "unit", unit, "index", index);
	}

	public static void parameterIsMissedForUnit(LUnit unit, int parameterIndex)
	{
		throwException("Parameter is missed for unit", "unit", unit, "parameter index", parameterIndex);
	}

	public static <NULL> NULL methodIsNotAllowedForUnit(LUnit unit, LUnitDescriptor methodDescriptor)
	{
		methodIsNotAllowedForUnit(unit, methodDescriptor.getName());

		return null;
	}

	public static <NULL> NULL methodIsNotAllowedForUnit(LUnit unit, String method)
	{
		throwException("Method is not allowed for unit", "unit", unit, "method", method);

		return null;
	}

	private static void throwException(String error, Object... keysAndValues)
	{
		throwException(generateExceptionMessage(error, keysAndValues));
	}

	private static String generateExceptionMessage(String error, Object... keysAndValues)
	{
		List<String> parameterDescriptions = new ArrayList<>();

		for (int i = 0; i < keysAndValues.length; i += 2)
			parameterDescriptions.add(String.format("%s : \"%s\"", keysAndValues[i], keysAndValues[i + 1]));

		return String.format("%s - %s", error, String.join(", ", parameterDescriptions));
	}

	private static void throwException(String exceptionMessage)
	{
		throw new LLokiErrorException(exceptionMessage);
	}
}