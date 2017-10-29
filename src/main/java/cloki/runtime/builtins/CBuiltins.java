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
import cloki.runtime.consts.CConstDataUnit;
import cloki.runtime.consts.CConstFunctionalUnit;
import cloki.runtime.datatypes.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CBuiltins
{
	public static final Map<String, Supplier<CUnit>> defaults = Collections.unmodifiableMap
	(
		new HashMap<String, Supplier<CUnit>>()
		{{
			put(CConstDataUnit.UNDEFINED.name, () -> CUndefined.instance);
			put(CConstDataUnit.VOID.name, () -> CVoid.instance);
			put(CConstDataUnit.NONE.name, () -> CNone.instance);
			put(CConstDataUnit.BOOLEAN_PROTOTYPE.name, () -> CBooleanPrototype.instance);
			put(CConstDataUnit.TRUE.name, () -> CTrue.instance);
			put(CConstDataUnit.FALSE.name, () -> CFalse.instance);
			put(CConstDataUnit.UNIT_PROTOTYPE.name, CUnit::getUnitPrototype);
			put(CConstDataUnit.NUMBER_PROTOTYPE.name, () -> CNumberPrototype.instance);
			put(CConstDataUnit.STRING_PROTOTYPE.name, () -> CStringPrototype.instance);
			put(CConstDataUnit.ARRAY_PROTOTYPE.name, () -> CArrayPrototype.instance);

			put(CConstFunctionalUnit.INCLUDE.name, () -> CInclude.instance);
			put(CConstFunctionalUnit.IMPORT.name, () -> CImport.instance);
			put(CConstFunctionalUnit.LOOP.name, () -> CLoop.instance);
			put(CConstFunctionalUnit.TIME.name, () -> CTime.instance);
			put(CConstFunctionalUnit.PRINTLN.name, () -> CPrintln.instance);
		}}
	);

	public static void initUnitPrototype(CUnit unitPrototype)
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

	public static void initType(CType type)
	{
		CGetId.instance.init(type);
		CGetName.instance.init(type);
	}

	public static void initBooleanPrototype(CBooleanPrototype booleanPrototype)
	{
		CLogicalNegation.instance.init(booleanPrototype);
		COperationBooleanAmpersandAmpersand.instance.init(booleanPrototype);
		COperationBooleanPipePipe.instance.init(booleanPrototype);
	}

	public static void initNumberPrototype(CNumberPrototype numberPrototype)
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
