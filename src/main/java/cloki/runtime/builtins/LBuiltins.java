package cloki.runtime.builtins;

import cloki.runtime.builtins.members.type.LGetId;
import cloki.runtime.builtins.members.type.LGetName;
import cloki.runtime.builtins.members.unit.*;
import cloki.runtime.builtins.operations.binary.bool.LBooleanAmpersandAmpersand;
import cloki.runtime.builtins.operations.binary.bool.LBooleanPipePipe;
import cloki.runtime.builtins.operations.binary.number.*;
import cloki.runtime.builtins.operations.binary.unit.LUnitBangEquals;
import cloki.runtime.builtins.operations.binary.unit.LUnitEqualsEquals;
import cloki.runtime.builtins.operations.unary.bool.LBooleanNegation;
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

					put(LFunctionalUnit.ASSERT.name, () -> LAssert.instance);
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
		LUnitEqualsEquals.instance.init(unitPrototype);
		LUnitBangEquals.instance.init(unitPrototype);
	}

	public static void initType(LType type)
	{
		LGetId.instance.init(type);
		LGetName.instance.init(type);
	}

	public static void initBooleanPrototype(LBooleanPrototype booleanPrototype)
	{
		LBooleanNegation.instance.init(booleanPrototype);
		LBooleanAmpersandAmpersand.instance.init(booleanPrototype);
		LBooleanPipePipe.instance.init(booleanPrototype);
	}

	public static void initNumberPrototype(LNumberPrototype numberPrototype)
	{
		LNumericNegation.instance.init(numberPrototype);
		LNumberStar.instance.init(numberPrototype);
		LNumberSlash.instance.init(numberPrototype);
		LNumberPlus.instance.init(numberPrototype);
		LNumberMinus.instance.init(numberPrototype);
		LNumberEqualsEquals.instance.init(numberPrototype);
		LNumberBangEquals.instance.init(numberPrototype);
		LNumberGreaterThanEquals.instance.init(numberPrototype);
		LNumberLessThanEquals.instance.init(numberPrototype);
		LNumberGreaterThan.instance.init(numberPrototype);
		LNumberLessThan.instance.init(numberPrototype);
	}
}
