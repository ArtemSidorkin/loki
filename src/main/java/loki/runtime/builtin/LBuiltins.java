package loki.runtime.builtin;

import loki.runtime.builtin.unit.*;
import loki.runtime.constant.LDataUnit;
import loki.runtime.constant.LFunctionalUnit;
import loki.runtime.datatype.*;
import loki.runtime.datatype.number.LNumberPrototype;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LBuiltins
{
	public static final Map<String, Supplier<LUnit>> container =
		Collections.unmodifiableMap(new HashMap<String, Supplier<LUnit>>()
		{{
			initializeDefaultDataUnitInstances(this);
			initializeDefaultFunctionalUnitInstances(this);
		}});

	private static void initializeDefaultDataUnitInstances(Map<String, Supplier<LUnit>> builtinContainer)
	{
		builtinContainer.put(LDataUnit.UNDEFINED.name, () -> LUndefined.instance);
		builtinContainer.put(LDataUnit.VOID.name, () -> LVoid.instance);
		builtinContainer.put(LDataUnit.NONE.name, () -> LNone.instance);
		builtinContainer.put(LDataUnit.BOOLEAN_PROTOTYPE.name, () -> LBooleanPrototype.instance);
		builtinContainer.put(LDataUnit.TRUE.name, () -> LTrue.instance);
		builtinContainer.put(LDataUnit.FALSE.name, () -> LFalse.instance);
		builtinContainer.put(LDataUnit.UNIT_PROTOTYPE.name, LUnit::getPrototype);
		builtinContainer.put(LDataUnit.NUMBER_PROTOTYPE.name, () -> LNumberPrototype.instance);
		builtinContainer.put(LDataUnit.STRING_PROTOTYPE.name, () -> LStringPrototype.instance);
		builtinContainer.put(LDataUnit.ARRAY_PROTOTYPE.name, () -> LArrayPrototype.instance);
	}

	private static void initializeDefaultFunctionalUnitInstances(Map<String, Supplier<LUnit>> builtinContainer)
	{
		builtinContainer.put(LFunctionalUnit.ASSERT.name, () -> LAssert.instance);
		builtinContainer.put(LFunctionalUnit.INCLUDE.name, () -> LInclude.instance);
		builtinContainer.put(LFunctionalUnit.IMPORT.name, () -> LImport.instance);
		builtinContainer.put(LFunctionalUnit.LOOP.name, () -> LLoop.instance);
		builtinContainer.put(LFunctionalUnit.TIME.name, () -> LTime.instance);
		builtinContainer.put(LFunctionalUnit.PRINTLN.name, () -> LPrintln.instance);
	}
}