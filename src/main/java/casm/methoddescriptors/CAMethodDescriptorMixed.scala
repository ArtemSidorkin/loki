package casm.methoddescriptors

import casm.consts.CAConstInternalDescriptors
import org.objectweb.asm.Type

case class CAMethodDescriptorMixed(mixedDescriptor:(Seq[Either[Class[_], String]], Option[Either[Class[_], String]]))
	extends CAMethodDescriptor
{
	override private[casm] val untypedDescriptor =
		mixedDescriptor._1.foldLeft("(")((dscrptrCllctr, clsOrClsDscrptr) =>
			if (clsOrClsDscrptr.isLeft) s"$dscrptrCllctr${Type getDescriptor clsOrClsDscrptr.left.get}"
			else s"$dscrptrCllctr${clsOrClsDscrptr.right.get}"
		) + ")" +
		mixedDescriptor._2.foldLeft(CAConstInternalDescriptors.VOID)((_, clsOrClsDscrptr) =>
			if (clsOrClsDscrptr.isLeft) Type getDescriptor clsOrClsDscrptr.left.get else clsOrClsDscrptr.right.get
		)
}
