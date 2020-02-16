package loki.runtime.context;

import loki.runtime.constant.LDataUnit;
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
	public static final Map<String, Supplier<LUnit>> BUILTINS =
		Collections
			.unmodifiableMap(
				new HashMap<String, Supplier<LUnit>>()
				{
					{
						initializeDefaultDataUnitInstances();
						initializePrototypes();
						initializeFunctions();
					}

					void initializeDefaultDataUnitInstances()
					{
						put(LDataUnit.UNDEFINED.name, () -> LUndefined.INSTANCE);
						put(LDataUnit.VOID.name, () -> LVoid.INSTANCE);
						put(LDataUnit.NONE.name, () -> LNone.INSTANCE);
						put(LDataUnit.TRUE.name, () -> LBoolean.TRUE);
						put(LDataUnit.FALSE.name, () -> LBoolean.FALSE);

					}

					void initializePrototypes()
					{
						put(LDataUnit.UNIT_PROTOTYPE.name, LUnit::getPrototype);
						put(LDataUnit.BOOLEAN_PROTOTYPE.name, () -> LBoolean.PROTOTYPE);
						put(LDataUnit.NUMBER_PROTOTYPE.name, () -> LNumber.prototype);
						put(LDataUnit.STRING_PROTOTYPE.name, () -> LString.PROTOTYPE);
						put(LDataUnit.ARRAY_PROTOTYPE.name, () -> LArray.PROTOTYPE);
						put(LDataUnit.MAP_PROTOTYPE.name, () -> LMap.PROTOTYPE);
						put(LDataUnit.OBJECT_PROTOTYPE.name, () -> LObject.PROTOTYPE);
					}

					void initializeFunctions()
					{
						put(LAssert.NAME, () -> LAssert.INSTANCE);
						put(LUse.NAME, () -> LUse.INSTANCE);
						put(LLoop.NAME, () -> LLoop.INSTANCE);
						put(LTimeInNanoseconds.NAME, () -> LTimeInNanoseconds.INSTANCE);
						put(LPrintln.NAME, () -> LPrintln.INSTANCE);
					}
				}
			);
}
