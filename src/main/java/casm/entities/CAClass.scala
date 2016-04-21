package casm.entities

import java.io.{BufferedWriter, OutputStream, OutputStreamWriter, PrintWriter}

import casm.CAUtils
import casm.consts.{CAConstJavaVersion, CAConstModifier}
import casm.methoddescriptors.CAMethodDescriptor
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.tree.{MethodNode, FieldNode, ClassNode}
import org.objectweb.asm.util.TraceClassVisitor

class CAClass
(
	val javaVersion:CAConstJavaVersion,
	val modifier:CAConstModifier,
	val internalName:String,
	val descriptor:String,
	val parentClassInternalName:String
)
{
	def this(
		javaVersion:CAConstJavaVersion, modifier:CAConstModifier, internalName:String, parentClass:Class[_]
	) = this(
		javaVersion,
		modifier,
		internalName,
		CAUtils getClassDescriptor internalName,
		CAUtils getClassInternalName parentClass
	)

	private val classNode = new ClassNode

	{
		classNode.version = javaVersion.javaVersionCode
		classNode.access = modifier.modifierCode
		classNode.signature = descriptor
		classNode.name = internalName
		classNode.superName = parentClassInternalName
	}

	def addField(fieldModifier:CAConstModifier, fieldName:String, fieldClass:Class[_]):this.type =
	{
		classNode.fields.asInstanceOf[java.util.List[FieldNode]].add(new CAField(fieldModifier, fieldName, fieldClass).fieldNode)
		this
	}

	def addField(fieldModifier:CAConstModifier, fieldName:String, fieldDescriptor:String):this.type =
	{
		classNode.fields.asInstanceOf[java.util.List[FieldNode]].add(new CAField(fieldModifier, fieldName, fieldDescriptor).fieldNode)
		this
	}

	def addMethod(methodModifier:CAConstModifier, methodName:String, methodDescriptor:CAMethodDescriptor) =
	{
		val mthd = new CAMethod(methodModifier, methodName, methodDescriptor)
		classNode.methods.asInstanceOf[java.util.List[MethodNode]].add(mthd.methodNode)
		mthd
	}

	def addMethod(methodModifier:CAConstModifier, methodName:String, methodDescriptor:String) =
	{
		val mthd = new CAMethod(methodModifier, methodName, methodDescriptor)
		classNode.methods.asInstanceOf[java.util.List[MethodNode]].add(mthd.methodNode)
		mthd
	}

	def addMethodInit(initMethodModifier:CAConstModifier, initMethodDescriptor:CAMethodDescriptor) =
	{
		val mthdInit = new CAMethodInit(initMethodModifier, initMethodDescriptor)
		classNode.methods.asInstanceOf[java.util.List[MethodNode]].add(mthdInit.methodNode)
		mthdInit
	}

	def addMethodInit(initMethodModifier:CAConstModifier, initMethodDescriptor:String) =
	{
		val mthdInit = new CAMethodInit(initMethodModifier, initMethodDescriptor)
		classNode.methods.asInstanceOf[java.util.List[MethodNode]].add(mthdInit.methodNode)
		mthdInit
	}

	def toBytecode(bytecodeTracingOutputStream:Option[OutputStream]) =
	{
		val clsWrtr = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS)
		bytecodeTracingOutputStream map (btcdTrcngOtptStrm =>
		{
			val trcClsVstr = new TraceClassVisitor(
				clsWrtr, new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))
			)
			classNode.accept(trcClsVstr)
		}) getOrElse (classNode.accept(clsWrtr))
		clsWrtr.toByteArray
	}
}
