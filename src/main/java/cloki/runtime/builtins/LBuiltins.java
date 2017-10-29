package cloki.runtime.builtins;

import cloki.runtime.builtins.members.type.CGetId;
import cloki.runtime.builtins.members.type.CGetName;
import cloki.runtime.builtins.members.unit.*;
import cloki.runtime.builtins.operations.bool.COperationBooleanAmpersandAmpersand;
import cloki.runtime.builtins.operations.bool.COperationBooleanPipePipe;
import cloki.runtime.builtins.operations.number.*;
import cloki.runtime.builtins.operations.unit.COperationBangEquals;
import cloki.runtime.builtins.operations.unit.COperationEqualsEquals;
import cloki.runtime.builtins.unaryoperations.bool.CLogicalNegation;
import cloki.runtime.builtins.unaryoperations.number.CNumericNegation;
import cloki.runtime.builtins.units.*;
import cloki.runtime.constant.LDataUnit;
import cloki.runtime.constant.LFunctionalUnit;
import cloki.runtime.datatype.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LBuiltins
{
	public static final Map<String, Supplier<LUnit>> defaults =
		Collections
			.unmodifiableMap(
				new HashMap<String, Supplier<LUnit>>()
				{{
					put(LDataUnit.UNDEFINED.name, () -> LUndefined.instance);
					put(LDataUnit.VOID.name, () -> LVoid.instance);
					put(LDataUnit.NONE.name, () -> LNone.instance);
					put(LDataUnit.BOOLEAN_PROTOTYPE.name, () -> LBooleanPrototype.instance);
					put(LDataUnit.TRUE.name, () -> LTrue.instance);
					put(LDataUnit.FALSE.name, () -> LFalse.instance);
					put(LDataUnit.UNIT_PROTOTYPE.name, LUnit::getPrototype);
					put(LDataUnit.NUMBER_PROTOTYPE.name, () -> LNumberPrototype.instance);
					put(LDataUnit.STRING_PROTOTYPE.name, () -> LStringPrototype.instance);
					put(LDataUnit.ARRAY_PROTOTYPE.name, () -> LArrayPrototype.instance);

					put(LFunctionalUnit.INCLUDE.name, () -> LInclude.instance);
					put(LFunctionalUnit.IMPORT.name, () -> LImport.instance);
					put(LFunctionalUnit.LOOP.name, () -> LLoop.instance);
					put(LFunctionalUnit.TIME.name, () -> LTime.instance);
					put(LFunctionalUnit.PRINTLN.name, () -> LPrintln.instance);
				}}
			);

	public static void initUnitPrototype(LUnit unitPrototype)
	{
		CNew.instance.init(unitPrototype);
		CAddParent.instance.init(unitPrototype);
		CGetSuperMember.instance.init(unitPrototype);
		CGetIndexItem.instance.init(unitPrototype);
		CSetIndexItem.instance.init(unitPrototype);
		CGetType.instance.init(unitPrototype);
		CToString.instance.init(unitPrototype);
		CHashCode.instance.init(unitPrototype);
		CEquals.instance.init(unitPrototype);
		COperationEqualsEquals.instance.init(unitPrototype);
		COperationBangEquals.instance.init(unitPrototype);
	}

	public static void initType(LType type)
	{
		CGetId.instance.init(type);
		CGetName.instance.init(type);
	}

	public static void initBooleanPrototype(LBooleanPrototype booleanPrototype)
	{
		CLogicalNegation.instance.init(booleanPrototype);
		COperationBooleanAmpersandAmpersand.instance.init(booleanPrototype);
		COperationBooleanPipePipe.instance.init(booleanPrototype);
	}

	public static void initNumberPrototype(LNumberPrototype numberPrototype)
	{
		CNumericNegation.instance.init(numberPrototype);
		COperationNumberStar.instance.init(numberPrototype);
		COperationNumberSlash.instance.init(numberPrototype);
		COperationNumberPlus.instance.init(numberPrototype);
		COperationNumberMinus.instance.init(numberPrototype);
		COperationNumberEqualsEquals.instance.init(numberPrototype);
		COperationNumberBangEquals.instance.init(numberPrototype);
		COperationNumberGreaterThanEquals.instance.init(numberPrototype);
		COperationNumberLessThanEquals.instance.init(numberPrototype);
		COperationNumberGreaterThan.instance.init(numberPrototype);
		COperationNumberLessThan.instance.init(numberPrototype);
	}
}
