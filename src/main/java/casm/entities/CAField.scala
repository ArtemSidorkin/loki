package casm.entities

import casm.CAUtils
import casm.consts.CAConstModifier
import org.objectweb.asm.tree.FieldNode

class CAField private[casm](modifier:CAConstModifier, name:String, descriptor:String)
{
	private[casm] val fieldNode = new FieldNode(modifier.modifierCode, name, descriptor,  null, null)

	private[casm] def this(modifier:CAConstModifier, name:String, `class`:Class[_]) =
		this(modifier, name, CAUtils getClassDescriptor `class`)
}
