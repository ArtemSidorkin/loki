package loki.runtime.context;

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
						initializePrototypes();
						initializeObjects();
						initializeFunctions();
					}

					void initializeObjects()
					{
						put(LVoid.NAME, () -> LVoid.INSTANCE);
						put(LNone.NAME, () -> LNone.INSTANCE);
						put(LBoolean.TRUE_NAME, () -> LBoolean.TRUE);
						put(LBoolean.FALSE_NAME, () -> LBoolean.FALSE);

					}

					void initializePrototypes()
					{
						put(LUnit.PROTOTYPE_NAME, LUnit::getPrototype);
						put(LBoolean.PROTOTYPE_NAME, () -> LBoolean.PROTOTYPE);
						put(LNumber.PROTOTYPE_NAME, () -> LNumber.PROTOTYPE);
						put(LString.PROTOTYPE_NAME, () -> LString.PROTOTYPE);
						put(LArray.PROTOTYPE_NAME, () -> LArray.PROTOTYPE);
						put(LMap.PROTOTYPE_NAME, () -> LMap.PROTOTYPE);
						put(LObject.PROTOTYPE_NAME, () -> LObject.PROTOTYPE);
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
