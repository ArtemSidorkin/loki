package loki.runtime.error;

import loki.runtime.LType;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LTypeUnitDescriptor;
import loki.runtime.unitdescriptor.LUnitDescriptor;

import java.util.function.BiConsumer;

public class LErrors
{
	public static void unitHasWrongType(LUnit unit, LTypeUnitDescriptor<?> expectedUnitTypeDescriptor)
	{
		unitHasWrongType(unit, expectedUnitTypeDescriptor.getType());
	}


	public static void unitHasWrongType(LUnit unit, LType expectedUnitType)
	{
		throwException(
			String.format("Unit has wrong type: unit - '%s', expected unit type - '%s'", unit, expectedUnitType)
		);
	}

	public static <T extends LUnit> BiConsumer<LUnit, LTypeUnitDescriptor<T>> methodParameterHasWrongType(
		LUnit host,
		LUnitDescriptor methodDescriptor,
		int parameterIndex
	)
	{
		return
			(parameterValue, expectedParameterType) ->
				callbackResultHasWrongType(
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
			String
				.format(
					"Method parameter has wrong type: " +
					"host - '%s', " +
					"method name - '%s', " +
					"parameter index - '%s', " +
					"parameter value - '%s', " +
					"expected parameter type - '%s'",
					host,
					methodName,
					parameterIndex,
					parameterValue,
					expectedParameterType
				)
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
			String
				.format(
					"Method result has wrong type: " +
					"host - '%s', " +
					"method name - '%s', " +
					"result - '%s', " +
					"expected result type - '%s'",
					host,
					methodName,
					result,
					expectedResultType
				)
		);
	}


	public static void unitHasNoMember(LUnit unit, String memberName)
	{
		throwException(
			String
				.format(
					"Unit has no member: unit - '%s', member name - '%s'",
					unit,
					memberName
				)
		);
	}

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
		throwException(
			String
				.format(
					"Host has wrong type: host - '%s', method - '%s', expected type - '%s'", host, method, expectedType
				)
		);
	}

	public static <T extends LUnit> BiConsumer<LUnit, LTypeUnitDescriptor<T>> callbackResultHasWrongType(
		LUnit host, LUnitDescriptor method, int indexOfCallbackInOperationParameters
	)
	{
		return
			(result, expectedType) ->
				callbackResultHasWrongType(
					host, method, indexOfCallbackInOperationParameters, result, expectedType
				);
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
			String
				.format(
					"Callback result has wrong type: " +
					"host - '%s', " +
					"method - '%s', " +
					"index of callback in method parameters - '%s', " +
					"result - '%s', " +
					"expected type - '%s'",
					host,
					method,
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

	public static void operandsShouldHaveTypes(
		LUnit leftOperand,
		LType leftOperandType,
		LUnit rightOperand,
		LType rightOperandType
	)
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

	public static void parameterIsMissedForUnit(LUnit unit, int parameterIndex)
	{
		throwException(
			String.format("Parameter is missed for unit: unit - '%s', parameter index - '%s'", unit, parameterIndex)
		);
	}

	public static void unitDoesNotHaveItemWithIndex(LUnit unit, Object index)
	{
		throwException(String.format("Unit \"%s\" does not have item with index \"%s\"", unit, index));
	}

	public static void methodIsNotAllowedForUnit(LUnit unit, LUnitDescriptor methodDescriptor)
	{
		methodIsNotAllowedForUnit(unit, methodDescriptor.getName());
	}

	public static void methodIsNotAllowedForUnit(LUnit unit, String method)
	{
		throwException(String.format("Method is not allowed for unit: unit - '%s', method - '%s'", unit, method));
	}

	private static void throwException(String error)
	{
		throw new LLokiErrorException(error);
	}
}
