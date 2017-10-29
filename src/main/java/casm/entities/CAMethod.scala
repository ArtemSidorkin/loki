package casm.entities

import casm.CAUtils
import casm.consts.{CAConstInternalDescriptors, CAConstModifier}
import casm.methoddescriptors.CAMethodDescriptor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree._

import scala.collection.mutable

class CAMethod private[casm](modifier:CAConstModifier, val name:String, descriptor:String)
{
	private[casm] val methodNode = new MethodNode(modifier.modifierCode, name, descriptor, null, null)
	private val objectStackCounter = new CAObjectStackCounter(this)

	private[casm] def this(modifier:CAConstModifier, name:String, descriptor:CAMethodDescriptor) =
		this(modifier, name, descriptor.untypedDescriptor)

	def aconstnull():this.type =
	{
		methodNode.instructions.add(new InsnNode(Opcodes.ACONST_NULL))
		this
	}

	def aconsttrue():this.type =
	{
		methodNode.instructions.add(new InsnNode(Opcodes.ICONST_1))
		this
	}

	def lconst1():this.type =
	{
		methodNode.instructions.add(new InsnNode(Opcodes.LCONST_1))
		this
	}

	def ldc(any:Any):this.type =
	{
		methodNode.instructions.add(new LdcInsnNode(any))
		this
	}


	def aload(variableIndex:Int):this.type =
	{
		methodNode.instructions.add(new VarInsnNode(Opcodes.ALOAD, variableIndex))
		this
	}

	def aloadthis():this.type =
	{
		methodNode.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0))
		this
	}

	def aaload():this.type =
	{
		methodNode.instructions.add(new InsnNode(Opcodes.AALOAD))
		this
	}

	def aastore():this.type =
	{
		methodNode.instructions.add(new InsnNode(Opcodes.AASTORE))
		this
	}

	def astore(variableIndex:Int):this.type =
	{
		methodNode.instructions.add(new VarInsnNode(Opcodes.ASTORE, variableIndex))
		this
	}


	def pop():this.type =
	{
		methodNode.instructions.add(new InsnNode(Opcodes.POP))
		this
	}

	def dup():this.type =
	{
		methodNode.instructions.add(new InsnNode(Opcodes.DUP))
		this
	}

	def ifeq(labelNode:LabelNode):this.type =
	{
		methodNode.instructions.add(new JumpInsnNode(Opcodes.IFEQ, labelNode))
		this
	}

	def ifne(labelNode:LabelNode):this.type =
	{
		methodNode.instructions.add(new JumpInsnNode(Opcodes.IFNE, labelNode))
		this
	}

	def goto(labelNode:LabelNode):this.type =
	{
		methodNode.instructions.add(new JumpInsnNode(Opcodes.GOTO, labelNode))
		this
	}

	def label(labelNode:LabelNode):this.type =
	{
		methodNode.instructions.add(labelNode)
		this
	}

	def getfield(fieldOwnerClass:Class[_], fieldName:String, fieldClass:Class[_]):this.type =
		getfield(CAUtils getClassInternalName fieldOwnerClass, fieldName, CAUtils getClassInternalName fieldClass)

	def getfield(fieldOwnerClass:Class[_], fieldName:String, fieldClassInternalName:String):this.type =
		getfield(CAUtils getClassInternalName fieldOwnerClass, fieldName, fieldClassInternalName)

	def getfield(fieldOwnerClassInternalName:String, fieldName:String, fieldClass:Class[_]):this.type =
		getfield(fieldOwnerClassInternalName, fieldName, CAUtils getClassInternalName fieldClass)

	def getfield(fieldOwnerClassInternalName:String, fieldName:String, fieldClassInternalName:String):this.type =
	{
		methodNode.instructions.add(
			new FieldInsnNode
			(
				Opcodes.GETFIELD,
				fieldOwnerClassInternalName,
				fieldName,
				CAUtils getClassDescriptor fieldClassInternalName
			)
		)
		this
	}

	def getstatic(fieldOwnerClass:Class[_], fieldName:String, fieldClass:Class[_]):this.type =
		getstatic(CAUtils getClassInternalName fieldOwnerClass, fieldName, CAUtils getClassInternalName fieldClass)

	def getstatic(fieldOwnerClass:Class[_], fieldName:String, fieldClassInternalName:String):this.type =
		getstatic(CAUtils getClassInternalName fieldOwnerClass, fieldName, fieldClassInternalName)

	def getstatic(fieldOwnerClassInternalName:String, fieldName:String, fieldClass:Class[_]):this.type =
		getstatic(fieldOwnerClassInternalName, fieldName, CAUtils getClassInternalName fieldClass)

	def getstatic(fieldOwnerClassInternalName:String, fieldName:String, fieldClassInternalName:String):this.type =
	{
		methodNode.instructions.add(
			new FieldInsnNode
			(
				Opcodes.GETSTATIC,
				fieldOwnerClassInternalName,
				fieldName,
				CAUtils getClassDescriptor fieldClassInternalName
			)
		)
		this
	}

	def putfield(fieldOwnerClass:Class[_], fieldName:String, fieldClass:Class[_]):this.type =
		putfield(CAUtils getClassInternalName fieldOwnerClass, fieldName, CAUtils getClassDescriptor fieldClass)

	def putfield(fieldOwnerClass:Class[_], fieldName:String, fieldDescriptor:String):this.type =
		putfield(CAUtils getClassInternalName fieldOwnerClass, fieldName, fieldDescriptor)

	def putfield(fieldOwnerClassInternalName:String, fieldName:String, fieldClass:Class[_]):this.type =
		putfield(fieldOwnerClassInternalName, fieldName, CAUtils getClassDescriptor fieldClass)

	def putfield(fieldOwnerClassInternalName:String, fieldName:String, fieldDescriptor:String):this.type =
	{
		methodNode.instructions.add(
			new FieldInsnNode(Opcodes.PUTFIELD, fieldOwnerClassInternalName, fieldName, fieldDescriptor)
		)
		this
	}

	def invokevirtual(
		methodOwnerClass:Class[_], methodName:String, methodDescriptor:CAMethodDescriptor
	):this.type = invokevirtual(
		CAUtils getClassInternalName methodOwnerClass,
		methodName,
		methodDescriptor.untypedDescriptor,
		methodOwnerClass.isInterface
	)

	def invokevirtual(methodOwnerClass:Class[_], methodName:String, methodDescriptor:String):this.type =
		invokevirtual(
			CAUtils getClassInternalName methodOwnerClass, methodName, methodDescriptor, methodOwnerClass.isInterface
		)

	def invokevirtual(
		methodOwnerClassInternalName:String,
		methodName:String,
		methodDescriptor:CAMethodDescriptor,
		isInterfaceMethod:Boolean
	):this.type = invokevirtual(
		methodOwnerClassInternalName,
		methodName,
		methodDescriptor.untypedDescriptor,
		isInterfaceMethod
	)

	def invokevirtual(
		methodOwnerClassInternalName:String, methodName:String, methodDescriptor:String, isInterfaceMethod:Boolean
	):this.type =
	{
		methodNode.instructions.add(
			new MethodInsnNode
			(
				Opcodes.INVOKEVIRTUAL,
				methodOwnerClassInternalName,
				methodName,
				methodDescriptor,
				isInterfaceMethod
			)
		)
		this
	}

	def invokeinit(initOwnerClass:Class[_], initMethodDescriptor:CAMethodDescriptor):this.type =
		invokeinit(CAUtils getClassInternalName initOwnerClass, initMethodDescriptor.untypedDescriptor)

	def invokeinit(initOwnerClass:Class[_], initMethodDescriptor:String):this.type =
		invokeinit(CAUtils getClassInternalName initOwnerClass, initMethodDescriptor)
	
	def invokeinit(initOwnerClassInternalName:String, initMethodDescriptor:CAMethodDescriptor):this.type =
		invokeinit(initOwnerClassInternalName, initMethodDescriptor.untypedDescriptor)
	
	def invokeinit(initOwnerClassInternalName:String, initMethodDescriptor:String):this.type =
	{
		methodNode.instructions.add(
			new MethodInsnNode
			(
				Opcodes.INVOKESPECIAL,
				initOwnerClassInternalName,
				CAConstInternalDescriptors.METHOD_INIT,
				initMethodDescriptor,
				false
			)
		)
		this
	}

	def invokestatic(methodOwnerClass:Class[_], methodName:String, methodDescriptor:String):this.type =
		invokestatic(CAUtils getClassInternalName methodOwnerClass, methodName, methodDescriptor)

	def invokestatic(
		methodOwnerClass:Class[_], methodName:String, methodDescriptor:CAMethodDescriptor
	):this.type =
		invokestatic(CAUtils getClassInternalName methodOwnerClass, methodName, methodDescriptor.untypedDescriptor)

	def invokestatic(methodOwnerClassInternalName:String, methodName:String, methodDescriptor:String):this.type =
	{
		methodNode.instructions.add(
			new MethodInsnNode
			(
				Opcodes.INVOKESTATIC,
				methodOwnerClassInternalName,
				methodName,
				methodDescriptor,
				false
			)
		)
		this
	}

	def `new`(classInternalName:String):this.type =
	{
		methodNode.instructions.add(new TypeInsnNode(Opcodes.NEW, classInternalName))
		this
	}

	def `new`(`class`:Class[_]):this.type =
	{
		methodNode.instructions.add(new TypeInsnNode(Opcodes.NEW, CAUtils getClassInternalName `class`))
		this
	}

	def anewarray(arrayClass:Class[_]):this.type =
	{
		methodNode.instructions.add(new TypeInsnNode(Opcodes.ANEWARRAY, CAUtils getClassInternalName arrayClass))
		this
	}

	def aReturn():this.type =
	{
		methodNode.instructions.add(new InsnNode(Opcodes.ARETURN))
		this
	}

	def `return`():this.type =
	{
		methodNode.instructions.add(new InsnNode(Opcodes.RETURN))
		this
	}

	def incrementObjectCounter():this.type =
	{
		objectStackCounter.increment()
		this
	}

	def decrementObjectCounter():this.type =
	{
		objectStackCounter.decrement()
		this
	}

	def pushFrame():this.type =
	{
		objectStackCounter.push()
		this
	}

	def popFrame(rest:Int = 0):this.type =
	{
		objectStackCounter.pop(rest)
		this
	}
}

private class CAObjectStackCounter(method:CAMethod)
{
	private val counters = mutable.Stack[Int](0)

	def increment() = counters(0) += 1
	def decrement() = counters(0) -= 1

	def push() = counters.push(0)

	def pop(rest:Int) =
	{
		for (i <- 0 until counters.head - rest) method.pop()
		counters.pop()
	}
}