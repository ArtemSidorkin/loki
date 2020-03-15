package assembler.builder

import assembler.constant.{InternalDescriptors, Modifier}
import assembler.methoddescriptor.MethodDescriptor

class InitMethodBuilder private[assembler](modifier:Modifier, descriptor:String)
	extends MethodBuilder(modifier, InternalDescriptors.INIT_METHOD, descriptor)
{
	private[assembler] def this(modifier:Modifier, descriptor:MethodDescriptor) =
		this(modifier, descriptor.untypedDescriptor)
}
