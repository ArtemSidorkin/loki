package assembler.builder

import java.io.{BufferedWriter, OutputStream, OutputStreamWriter, PrintWriter}

import assembler.Utils
import assembler.constant.{JavaVersion, Modifier}
import assembler.methoddescriptor.MethodDescriptor
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.tree.{ClassNode, FieldNode, MethodNode}
import org.objectweb.asm.util.TraceClassVisitor

class ClassBuilder(
	val javaVersion:JavaVersion,
	val modifier:Modifier,
	val internalName:String,
	val descriptor:String,
	val parentClassInternalName:String
)
{
	private val classNode = new ClassNode

	def this(javaVersion:JavaVersion, modifier:Modifier, internalName:String, parentClass:Class[_]) =
		this(
			javaVersion,
			modifier,
			internalName,
			Utils getClassDescriptor internalName,
			Utils getClassInternalName parentClass
		)


	{
		classNode.version = javaVersion.javaVersionCode
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

	def addMethod(methodModifier:Modifier, name:String, descriptor:String):MethodBuilder =
	{
		val methodBuilder = new MethodBuilder(methodModifier, name, descriptor)
		classNode.methods.asInstanceOf[java.util.List[MethodNode]].add(methodBuilder.methodNode)
		methodBuilder
	}

	def addInitMethod(modifier:Modifier, methodDescriptor:MethodDescriptor):InitMethodBuilder =
	{
		val initMethodBuilder = new InitMethodBuilder(modifier, methodDescriptor)
		classNode.methods.asInstanceOf[java.util.List[MethodNode]].add(initMethodBuilder.methodNode)
		initMethodBuilder
	}

	def addMethodInit(modifier:Modifier, descriptor:String):MethodBuilder =
	{
		val initMethodBuilder = new InitMethodBuilder(modifier, descriptor)
		classNode.methods.asInstanceOf[java.util.List[MethodNode]].add(initMethodBuilder.methodNode)
		initMethodBuilder
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
