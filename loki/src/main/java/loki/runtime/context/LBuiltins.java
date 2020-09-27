package loki.runtime.context;

import loki.runtime.unit.data.LMap;
import loki.runtime.unit.data.LObject;
import loki.runtime.unit.data.LString;
import loki.runtime.unit.data.array.LArray;
import loki.runtime.unit.data.bool.LBoolean;
import loki.runtime.unit.data.number.LNumber;
import loki.runtime.unit.data.singleton.LNone;
import loki.runtime.unit.data.singleton.LVoid;
import loki.runtime.unit.function.LLoop;
import loki.runtime.unit.function.LPrintln;
import loki.runtime.unit.function.LTest;
import loki.runtime.unit.function.LTimeInNanoseconds;
import loki.runtime.unit.function.LUse;
import loki.runtime.unit.unit.LUnit;
import loki.runtime.unitdescriptor.LInstanceDescriptor;
import loki.runtime.unitdescriptor.LPrototypeDescriptor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LBuiltins
{
	private static final Map<String, Supplier<LUnit>> VALUES = Collections.unmodifiableMap(new Container());

	public static boolean contain(String name)
	{
		return VALUES.containsKey(name);
	}

	public static LUnit get(String name)
	{
		return VALUES.get(name).get();
	}

	private static class Container extends HashMap<String, Supplier<LUnit>>
	{
		{
			initializePrototypes();
			initializeInstances();
		}

		void initializePrototypes()
		{
			put(LUnit.PROTOTYPE_NAME, LUnit::getPrototype);

			initializePrototype(LBoolean.DESCRIPTOR);
			initializePrototype(LNumber.DESCRIPTOR);
			initializePrototype(LString.DESCRIPTOR);
			initializePrototype(LArray.DESCRIPTOR);
			initializePrototype(LMap.DESCRIPTOR);
			initializePrototype(LObject.DESCRIPTOR);
		}

		void initializeInstances()
		{
			initializeSingletons();
			initializeEnumerations();
			initializeFunctions();
		}

		void initializeSingletons()
		{
			initializeInstance(LVoid.DESCRIPTOR);
			initializeInstance(LNone.DESCRIPTOR);
		}

		void initializeEnumerations()
		{
			initializeInstance(LBoolean.TRUE);
			initializeInstance(LBoolean.FALSE);
		}

		void initializeFunctions()
		{
			initializeInstance(LTest.DESCRIPTOR);
			initializeInstance(LUse.DESCRIPTOR);
			initializeInstance(LLoop.DESCRIPTOR);
			initializeInstance(LTimeInNanoseconds.DESCRIPTOR);
			initializeInstance(LPrintln.DESCRIPTOR);
		}

		void initializePrototype(LPrototypeDescriptor<?> prototypeUnitDescriptor)
		{
			put(prototypeUnitDescriptor.getPrototypeName(), prototypeUnitDescriptor::getPrototype);
		}

		void initializeInstance(LInstanceDescriptor<?> instanceUnitDescriptor)
		{
			put(instanceUnitDescriptor.getUnitName(), instanceUnitDescriptor::getInstance);
		}
	}
}
