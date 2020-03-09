package loki.runtime.context;

import loki.runtime.unit.data.LArray;
import loki.runtime.unit.data.LMap;
import loki.runtime.unit.data.LObject;
import loki.runtime.unit.data.LString;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.function.*;
import loki.runtime.unit.singleton.LNone;
import loki.runtime.unit.singleton.LVoid;
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
						initializeValues();
						initializeFunctions();
					}

					void initializeValues()
					{
						put(LVoid.DESCRIPTOR.getType().getName(), LVoid.DESCRIPTOR::getInstance);
						put(LNone.DESCRIPTOR.getType().getName(), LNone.DESCRIPTOR::getInstance);
						put(LBoolean.TRUE_NAME, () -> LBoolean.TRUE);
						put(LBoolean.FALSE_NAME, () -> LBoolean.FALSE);
					}

					void initializePrototypes()
					{
						put(LUnit.PROTOTYPE_NAME, LUnit::getPrototype);
						put(LBoolean.DESCRIPTOR.getPrototypeType().getName(), LBoolean.DESCRIPTOR::getPrototype);
						put(LNumber.DESCRIPTOR.getPrototypeType().getName(), LNumber.DESCRIPTOR::getPrototype);
						put(LString.DESCRIPTOR.getPrototypeType().getName(), LString.DESCRIPTOR::getPrototype);
						put(LArray.DESCRIPTOR.getPrototypeType().getName(), LArray.DESCRIPTOR::getPrototype);
						put(LMap.DESCRIPTOR.getPrototypeType().getName(), LMap.DESCRIPTOR::getPrototype);
						put(LObject.DESCRIPTOR.getPrototypeType().getName(), LObject.DESCRIPTOR::getPrototype);
					}

					void initializeFunctions()
					{
						put(LAssert.DESCRIPTOR.getType().getName(), LAssert.DESCRIPTOR::getInstance);
						put(LUse.DESCRIPTOR.getType().getName(), LUse.DESCRIPTOR::getInstance);
						put(LLoop.DESCRIPTOR.getType().getName(), LLoop.DESCRIPTOR::getInstance);
						put(LTimeInNanoseconds.DESCRIPTOR.getType().getName(), LTimeInNanoseconds.DESCRIPTOR::getInstance);
						put(LPrintln.DESCRIPTOR.getType().getName(), LPrintln.DESCRIPTOR::getInstance);
					}
				}
			);
}
