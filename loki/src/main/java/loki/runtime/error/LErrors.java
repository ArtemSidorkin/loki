package loki.runtime.error;

import loki.runtime.LUnitType;
import loki.runtime.unit.member.operation.LOperandPosition;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LUnitDescriptor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class LErrors
{
	public static <T extends LUnit> BiConsumer<LUnit, LUnitDescriptor<T>> hostHasWrongType(
		LUnitDescriptor<?> methodDescriptor
	)
	{
		return (host, expectedTypeDescriptor) -> hostHasWrongType(host, methodDescriptor, expectedTypeDescriptor);
	}

	public static LUnit hostHasWrongType(
		LUnit host, LUnitDescriptor<?> methodDescriptor, LUnitDescriptor<?> expectedTypeDescriptor
	)
	{
		return hostHasWrongType(host, methodDescriptor.getUnitName(), expectedTypeDescriptor.getUnitType());
	}

	public static LUnit hostHasWrongType(LUnit host, String methodName, LUnitType expectedType)
	{
		return throwException(
			"Host has a wrong type", "host", host, "method name", methodName, "expected type", expectedType
		);
	}

	public static <T extends LUnit> BiConsumer<LUnit, LUnitDescriptor<T>> methodParameterHasWrongType(
		LUnit host, LUnitDescriptor<?> methodDescriptor, int parameterIndex
	)
	{
		return (parameterValue, expectedTypeDescriptor) ->
			methodParameterHasWrongType(host, methodDescriptor, parameterIndex, parameterValue, expectedTypeDescriptor);
	}

	public static LUnit methodParameterHasWrongType(
		LUnit host,
		LUnitDescriptor<?> methodDescriptor,
		int parameterIndex,
		LUnit parameter,
		LUnitDescriptor<?> expectedTypeDescriptor
	)
	{
		return methodParameterHasWrongType(
			host, methodDescriptor.getUnitName(), parameterIndex, parameter, expectedTypeDescriptor.getUnitType()
		);
	}

	public static LUnit methodParameterHasWrongType(
		LUnit host, String methodName, int parameterIndex, LUnit parameter, LUnitType expectedType
	)
	{
		return throwException(
			"Method parameter has a wrong type",
			"host", host,
			"method name", methodName,
			"parameter index", parameterIndex,
			"parameter", parameter,
			"expected type", expectedType
		);
	}

	public static <T extends LUnit> BiConsumer<LUnit, LUnitDescriptor<T>> callbackResultHasWrongType(
		LUnit host, LUnitDescriptor<?> methodDescriptor, int callbackParameterIndex
	)
	{
		return (result, expectedTypeDescriptor) ->
			callbackResultHasWrongType(host, methodDescriptor, callbackParameterIndex, result, expectedTypeDescriptor);
	}

	public static LUnit callbackResultHasWrongType(
		LUnit host,
		LUnitDescriptor<?> methodDescriptor,
		int callbackParameterIndex,
		LUnit result,
		LUnitDescriptor<?> expectedTypeDescriptor
	)
	{
		return callbackResultHasWrongType(
			host, methodDescriptor.getUnitName(), callbackParameterIndex, result, expectedTypeDescriptor.getUnitType()
		);
	}

	public static LUnit callbackResultHasWrongType(
		LUnit host, String methodName, int callbackParameterIndex, LUnit result, LUnitType expectedType
	)
	{
		return throwException(
			"Callback result has a wrong type",
			"host", host,
			"method name", methodName,
			"callback parameter index", callbackParameterIndex,
			"result", result,
			"expected type", expectedType
		);
	}

	public static <T extends LUnit> BiConsumer<LUnit, LUnitDescriptor<T>> methodResultHasWrongType(
		LUnit host, LUnitDescriptor<?> methodDescriptor
	)
	{
		return (methodResult, expectedTypeDescriptor) ->
			methodResultHasWrongType(host, methodDescriptor, methodResult, expectedTypeDescriptor);
	}

	public static LUnit methodResultHasWrongType(
		LUnit host, LUnitDescriptor<?> methodDescriptor, LUnit result, LUnitDescriptor<?> expectedTypeDescriptor
	)
	{
		return methodResultHasWrongType(
			host, methodDescriptor.getUnitName(), result, expectedTypeDescriptor.getUnitType()
		);
	}

	public static LUnit methodResultHasWrongType(LUnit host, String methodName, LUnit result, LUnitType expectedType)
	{
		return throwException(
			"Method result has a wrong type",
			"host", host,
			"method name", methodName,
			"result", result,
			"expected type", expectedType
		);
	}

	public static <T extends LUnit> BiConsumer<LUnit, LUnitDescriptor<T>> operandHasWrongType(
		LUnit host, LUnitDescriptor<?> operationDescriptor, LOperandPosition operandPosition
	)
	{
		return (operandValue, expectedTypeDescriptor) ->
			operandHasWrongType(host, operationDescriptor, operandPosition, operandValue, expectedTypeDescriptor);
	}

	public static LUnit operandHasWrongType(
		LUnit host,
		LUnitDescriptor<?> operationDescriptor,
		LOperandPosition operandPosition,
		LUnit operand,
		LUnitDescriptor<?> expectedTypeDescriptor
	)
	{
		return operandHasWrongType(
			host, operationDescriptor.getUnitName(), operandPosition, operand, expectedTypeDescriptor.getUnitType()
		);
	}

	public static LUnit operandHasWrongType(
		LUnit host, String operationName, LOperandPosition operandPosition, LUnit operand, LUnitType expectedType
	)
	{
		return throwException(
			"Operand has a wrong type",
			"host", host,
			"operation name", operationName,
			"operand position", operandPosition,
			"operand", operand,
			"expected type", expectedType
		);
	}

	public static LUnit unitHasWrongType(LUnit unit, LUnitDescriptor<?> expectedTypeDescriptor)
	{
		return unitHasWrongType(unit, expectedTypeDescriptor.getUnitType());
	}

	public static LUnit unitHasWrongType(LUnit unit, LUnitType expectedType)
	{
		return throwException("Unit has a wrong type", "unit", unit, "expected type", expectedType);
	}

	public static LUnit unitHasNoParameter(LUnit unit, int parameterIndex)
	{
		return throwException("Unit has no parameter", "unit", unit, "parameter index", parameterIndex);
	}

	public static LUnit unitHasNoMember(LUnit unit, LUnitDescriptor<?> memberDescriptor)
	{
		return unitHasNoMember(unit, memberDescriptor.getUnitName());
	}

	public static LUnit unitHasNoMember(LUnit unit, String memberName)
	{
		return throwException("Unit has no member", "unit", unit, "member name", memberName);
	}

	public static LUnit unitHasNoIndexedItem(LUnit unit, Object itemIndex)
	{
		return throwException("Unit has no indexed item", "unit", unit, "item index", itemIndex);
	}

	private static LUnit throwException(String error, Object... parameterKeysAndValues)
	{
		return throwException(generateExceptionMessage(error, parameterKeysAndValues));
	}

	private static String generateExceptionMessage(String error, Object... parameterKeysAndValues)
	{
		List<String> parameterDescriptions = new ArrayList<>();

		for (int i = 0; i < parameterKeysAndValues.length; i += 2)
			parameterDescriptions
				.add(String.format("%s : \"%s\"", parameterKeysAndValues[i], parameterKeysAndValues[i + 1]));

		return String.format("%s - %s", error, String.join(", ", parameterDescriptions));
	}

	private static LUnit throwException(String exceptionMessage)
	{
		throw new LLokiErrorException(exceptionMessage);
	}
}