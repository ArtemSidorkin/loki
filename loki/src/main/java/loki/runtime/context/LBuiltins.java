package loki.runtime.context;

import loki.runtime.unit.data.array.LArray;
import loki.runtime.unit.data.LMap;
import loki.runtime.unit.data.LObject;
import loki.runtime.unit.data.LString;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.data.singleton.LNone;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.function.*;
import loki.runtime.unit.unit.LUnit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LBuiltins
{
	private static final Map<String, Supplier<LUnit>> VALUES =
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
						put(LVoid.DESCRIPTOR.getName(), LVoid.DESCRIPTOR::getInstance);
						put(LNone.DESCRIPTOR.getName(), LNone.DESCRIPTOR::getInstance);
						put(LBoolean.TRUE.getName(), LBoolean.TRUE::getInstance);
						put(LBoolean.FALSE.getName(), LBoolean.FALSE::getInstance);
					}

					void initializePrototypes()
					{
						put(LUnit.PROTOTYPE_NAME, LUnit::getPrototype);
						put(LBoolean.DESCRIPTOR.getPrototypeName(), LBoolean.DESCRIPTOR::getPrototype);
						put(LNumber.DESCRIPTOR.getPrototypeName(), LNumber.DESCRIPTOR::getPrototype);
						put(LString.DESCRIPTOR.getPrototypeName(), LString.DESCRIPTOR::getPrototype);
						put(LArray.DESCRIPTOR.getPrototypeName(), LArray.DESCRIPTOR::getPrototype);
						put(LMap.DESCRIPTOR.getPrototypeName(), LMap.DESCRIPTOR::getPrototype);
						put(LObject.DESCRIPTOR.getPrototypeName(), LObject.DESCRIPTOR::getPrototype);
					}

					void initializeFunctions()
					{
						put(LTest.DESCRIPTOR.getName(), LTest.DESCRIPTOR::getInstance);
						put(LUse.DESCRIPTOR.getName(), LUse.DESCRIPTOR::getInstance);
						put(LLoop.DESCRIPTOR.getName(), LLoop.DESCRIPTOR::getInstance);
						put(LTimeInNanoseconds.DESCRIPTOR.getName(), LTimeInNanoseconds.DESCRIPTOR::getInstance);
						put(LPrintln.DESCRIPTOR.getName(), LPrintln.DESCRIPTOR::getInstance);
					}
				}
			);

	public static boolean contain(String name)
	{
		return VALUES.containsKey(name);
	}

	public static LUnit get(String name)
	{
		return VALUES.get(name).get();
	}
}
