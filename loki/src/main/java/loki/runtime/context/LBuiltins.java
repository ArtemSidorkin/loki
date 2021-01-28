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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class LBuiltins
{
	private static final Map<String, Supplier<LUnit>> VALUES = Collections.unmodifiableMap(new Container());

	public static Optional<LUnit> get(String name)
	{
		return Optional.ofNullable(VALUES.get(name)).map(Supplier::get);
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

			initializePrototypes(
				LBoolean.DESCRIPTOR,
				LNumber.DESCRIPTOR,
				LString.DESCRIPTOR,
				LArray.DESCRIPTOR,
				LMap.DESCRIPTOR,
				LObject.DESCRIPTOR
			);
		}

		void initializeInstances()
		{
			initializeSingletons();
			initializeEnumerations();
			initializeFunctions();
		}

		void initializeSingletons()
		{
			initializeInstances(
				LVoid.DESCRIPTOR,
				LNone.DESCRIPTOR
			);
		}

		void initializeEnumerations()
		{
			initializeInstances(
				LBoolean.TRUE,
				LBoolean.FALSE
			);
		}

		void initializeFunctions()
		{
			initializeInstances(
				LTest.DESCRIPTOR,
				LUse.DESCRIPTOR,
				LLoop.DESCRIPTOR,
				LTimeInNanoseconds.DESCRIPTOR,
				LPrintln.DESCRIPTOR
			);
		}

		void initializePrototypes(LPrototypeDescriptor<?>... prototypeDescriptors)
		{
			Arrays.stream(prototypeDescriptors).forEach(this::initializePrototype);
		}

		void initializePrototype(LPrototypeDescriptor<?> prototypeDescriptor)
		{
			put(prototypeDescriptor.getPrototypeName(), prototypeDescriptor::getPrototype);
		}

		void initializeInstances(LInstanceDescriptor<?>... instanceDescriptor)
		{
			Arrays.stream(instanceDescriptor).forEach(this::initializeInstance);
		}

		void initializeInstance(LInstanceDescriptor<?> instanceDescriptor)
		{
			put(instanceDescriptor.getUnitName(), instanceDescriptor::getInstance);
		}
	}
}
