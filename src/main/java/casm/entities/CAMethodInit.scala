package casm.entities

import casm.consts.{CAConstInternalDescriptors, CAConstModifier}
import casm.methoddescriptors.CAMethodDescriptor

class CAMethodInit private[casm](modifier:CAConstModifier, descriptor:String)
	extends CAMethod(modifier, CAConstInternalDescriptors.METHOD_INIT, descriptor)
{
	private[casm] def this(modifier:CAConstModifier, descriptor:CAMethodDescriptor) =
		this(modifier, descriptor.untypedDescriptor)
}
