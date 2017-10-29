package casm.methoddescriptors

import casm.consts.CAConstInternalDescriptors
import org.objectweb.asm.Type

case class CAMethodDescriptorTyped(typedDescriptor:(Seq[Class[_]], Option[Class[_]])) extends CAMethodDescriptor
{
	override private[casm] val untypedDescriptor =
		s"(${typedDescriptor._1.foldLeft("")((dscrptrCllctr, cls) => s"$dscrptrCllctr${Type getDescriptor cls}")})" +
		typedDescriptor._2.foldLeft(CAConstInternalDescriptors.VOID)((_, cls) => Type getDescriptor cls)
}
