package assembler.builder

import assembler.Utils
import assembler.constant.Modifier
import org.objectweb.asm.tree.FieldNode

class FieldBuilder private[builder] (modifier:Modifier, name:String, descriptor:String)
{
	private[builder] val fieldNode = new FieldNode(modifier.code, name, descriptor,  null, null)

	private[builder] def this(modifier:Modifier, name:String, `class`:Class[_]) =
		this(modifier, name, Utils getClassDescriptor `class`)
}
