package assembler.builder

import assembler.Utils.{getClassDescriptor, getClassInternalName}
import assembler.builder.MethodBuilder.initMethodBuilder
import assembler.methoddescriptor.MethodDescriptor
import org.objectweb.asm.tree.{ClassNode, FieldNode, MethodNode}
import org.objectweb.asm.util.TraceClassVisitor
import org.objectweb.asm.{ClassWriter, Opcodes}

import java.io.{BufferedWriter, OutputStream, OutputStreamWriter, PrintWriter}

class ClassBuilder(
	val modifier:Modifier, val internalName:String, val descriptor:String, val parentClassInternalName:String
)
{
	private val classNode = new ClassNode

	def this(modifier:Modifier, internalName:String, parentClass:Class[_]) =
		this(modifier, internalName, getClassDescriptor(internalName), getClassInternalName(parentClass))

	{
		classNode.version = Opcodes.V1_8
		classNode.access = modifier.code
		classNode.signature = descriptor
		classNode.name = internalName
		classNode.superName = parentClassInternalName
	}

	def addField(modifier:Modifier, name:String, `class`:Class[_]):this.type =
	{
		classNode
			.fields
			.asInstanceOf[java.util.List[FieldNode]]
			.add(new FieldBuilder(modifier, name, `class`).fieldNode)

		this
	}

	def addField(modifier:Modifier, name:String, descriptor:String):this.type =
	{
		classNode
			.fields
			.asInstanceOf[java.util.List[FieldNode]]
			.add(new FieldBuilder(modifier, name, descriptor).fieldNode)

		this
	}

	def addMethod(modifier:Modifier, methodDescriptor:MethodDescriptor):MethodBuilder =
	{
		val methodBuilder = new MethodBuilder(modifier, methodDescriptor)
		classNode.methods.asInstanceOf[java.util.List[MethodNode]].add(methodBuilder.methodNode)
		methodBuilder
	}

	def addInitMethod(modifier:Modifier, methodDescriptor:MethodDescriptor):MethodBuilder =
	{
		val _initMethodBuilder = initMethodBuilder(modifier, methodDescriptor)
		classNode.methods.asInstanceOf[java.util.List[MethodNode]].add(_initMethodBuilder.methodNode)
		_initMethodBuilder
	}

	def toBytecode(bytecodeTracingOutputStream:Option[OutputStream]):Array[Byte] =
	{
		val classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS)

		(
			bytecodeTracingOutputStream
				map (bytecodeTracingOutputStream_ =>
					classNode
						.accept(
							new TraceClassVisitor(
								classWriter,
								new PrintWriter(
									new BufferedWriter(new OutputStreamWriter(bytecodeTracingOutputStream_))
								)
							)
						)
				)
				getOrElse classNode.accept(classWriter)
		)

		classWriter.toByteArray
	}
}
