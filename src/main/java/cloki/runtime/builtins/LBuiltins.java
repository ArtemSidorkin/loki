package cloki.runtime.builtins;

import cloki.runtime.builtins.members.type.LGetId;
import cloki.runtime.builtins.members.type.LGetName;
import cloki.runtime.builtins.members.unit.*;
import cloki.runtime.builtins.operations.binary.bool.LOperationBooleanAmpersandAmpersand;
import cloki.runtime.builtins.operations.binary.bool.LOperationBooleanPipePipe;
import cloki.runtime.builtins.operations.binary.number.*;
import cloki.runtime.builtins.operations.binary.unit.LOperationBangEquals;
import cloki.runtime.builtins.operations.binary.unit.LOperationEqualsEquals;
import cloki.runtime.builtins.operations.unary.bool.LLogicalNegation;
import cloki.runtime.builtins.operations.unary.number.LNumericNegation;
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
		LNew.instance.init(unitPrototype);
		LAddParent.instance.init(unitPrototype);
		LGetSuperMember.instance.init(unitPrototype);
		LGetIndexItem.instance.init(unitPrototype);
		LSetIndexItem.instance.init(unitPrototype);
		LGetType.instance.init(unitPrototype);
		LToString.instance.init(unitPrototype);
		LHashCode.instance.init(unitPrototype);
		LEquals.instance.init(unitPrototype);
		LOperationEqualsEquals.instance.init(unitPrototype);
		LOperationBangEquals.instance.init(unitPrototype);
	}

	public static void initType(LType type)
	{
		LGetId.instance.init(type);
		LGetName.instance.init(type);
	}

	public static void initBooleanPrototype(LBooleanPrototype booleanPrototype)
	{
		LLogicalNegation.instance.init(booleanPrototype);
		LOperationBooleanAmpersandAmpersand.instance.init(booleanPrototype);
		LOperationBooleanPipePipe.instance.init(booleanPrototype);
	}

	public static void initNumberPrototype(LNumberPrototype numberPrototype)
	{
		LNumericNegation.instance.init(numberPrototype);
		LOperationNumberStar.instance.init(numberPrototype);
		LOperationNumberSlash.instance.init(numberPrototype);
		LOperationNumberPlus.instance.init(numberPrototype);
		LOperationNumberMinus.instance.init(numberPrototype);
		LOperationNumberEqualsEquals.instance.init(numberPrototype);
		LOperationNumberBangEquals.instance.init(numberPrototype);
		LOperationNumberGreaterThanEquals.instance.init(numberPrototype);
		LOperationNumberLessThanEquals.instance.init(numberPrototype);
		LOperationNumberGreaterThan.instance.init(numberPrototype);
		LOperationNumberLessThan.instance.init(numberPrototype);
	}
}
