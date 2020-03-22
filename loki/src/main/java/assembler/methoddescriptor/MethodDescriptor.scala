package assembler.methoddescriptor

trait MethodDescriptor
{
	val methodName:Option[String]
	private[assembler] val untypedDescriptor:String
}