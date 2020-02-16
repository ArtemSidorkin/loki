package loki.runtime.context;

import loki.runtime.constant.LDataUnit;
import loki.runtime.constant.LFunctionalUnit;
import loki.runtime.unit.*;
import loki.runtime.unit.bool.LBoolean;
import loki.runtime.unit.function.*;
import loki.runtime.unit.number.LNumber;
import loki.runtime.unit.unit.LUnit;

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
		builtinContainer.put(LDataUnit.UNDEFINED.name, () -> LUndefined.INSTANCE);
		builtinContainer.put(LDataUnit.VOID.name, () -> LVoid.INSTANCE);
		builtinContainer.put(LDataUnit.NONE.name, () -> LNone.INSTANCE);
		builtinContainer.put(LDataUnit.BOOLEAN_PROTOTYPE.name, () -> LBoolean.PROTOTYPE);
		builtinContainer.put(LDataUnit.TRUE.name, () -> LBoolean.TRUE);
		builtinContainer.put(LDataUnit.FALSE.name, () -> LBoolean.FALSE);
		builtinContainer.put(LDataUnit.UNIT_PROTOTYPE.name, LUnit::getPrototype);
		builtinContainer.put(LDataUnit.NUMBER_PROTOTYPE.name, () -> LNumber.prototype);
		builtinContainer.put(LDataUnit.STRING_PROTOTYPE.name, () -> LString.PROTOTYPE);
		builtinContainer.put(LDataUnit.ARRAY_PROTOTYPE.name, () -> LArray.PROTOTYPE);
	}

	private static void initializeDefaultFunctionalUnitInstances(Map<String, Supplier<LUnit>> builtinContainer)
	{
		builtinContainer.put(LFunctionalUnit.ASSERT.name, () -> LAssert.instance);
		builtinContainer.put(LFunctionalUnit.USE.name, () -> LUse.instance);
		builtinContainer.put(LFunctionalUnit.LOOP.name, () -> LLoop.instance);
		builtinContainer.put(LFunctionalUnit.TIME.name, () -> LTime.instance);
		builtinContainer.put(LFunctionalUnit.PRINTLN.name, () -> LPrintln.instance);
	}
}
