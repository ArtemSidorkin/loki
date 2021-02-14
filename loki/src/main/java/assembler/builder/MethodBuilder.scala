package assembler.builder

import assembler.Utils
import assembler.constant.{InternalDescriptors, Modifier}
import assembler.methoddescriptor.{MethodDescriptor, MethodInvocationDescriptor}
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree._

import scala.collection.mutable

class MethodBuilder private[builder](modifier:Modifier, val name:String, descriptor:String)
{
	private[builder] val methodNode = new MethodNode(modifier.code, name, descriptor, null, null)

	private val objectStackCounter = new ObjectStackCounter(this)

	private[assembler] def this(modifier:Modifier, methodDescriptor:MethodDescriptor) =
		this(modifier, methodDescriptor.name, methodDescriptor.untypedSignature)

	def ldc(any:Any):this.type =
	{
		methodNode.instructions.add(new LdcInsnNode(any))
		incrementObjectStackCounter()
		this
	}


	def aload(variableIndex:Int):this.type =
	{
		methodNode.instructions.add(new VarInsnNode(Opcodes.ALOAD, variableIndex))
		incrementObjectStackCounter()
		this
	}

	def aloadthis():this.type =
	{
		methodNode.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0))
		incrementObjectStackCounter()
		this
	}

	def aastore():this.type =
	{
		methodNode.instructions.add(new InsnNode(Opcodes.AASTORE))
		decreaseObjectStackCounter(3)
		this
	}

	def astore(variableIndex:Int):this.type =
	{
		methodNode.instructions.add(new VarInsnNode(Opcodes.ASTORE, variableIndex))
		decrementObjectStackCounter()
		this
	}

	def pop():this.type =
	{
		methodNode.instructions.add(new InsnNode(Opcodes.POP))
		decrementObjectStackCounter()
		this
	}

	def dup():this.type =
	{
		methodNode.instructions.add(new InsnNode(Opcodes.DUP))
		incrementObjectStackCounter()
		this
	}

	def swap():this.type =
	{
		methodNode.instructions.add(new InsnNode(Opcodes.SWAP))
		this
	}

	def ifeq(labelNode:LabelNode):this.type =
	{
		methodNode.instructions.add(new JumpInsnNode(Opcodes.IFEQ, labelNode))
		decrementObjectStackCounter()
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

	def getstatic(ownerClass:Class[_], name:String, `class`:Class[_]):this.type =
		getstatic(Utils getClassInternalName ownerClass, name, Utils getClassInternalName `class`)

	def getstatic(ownerClassInternalName:String, name:String, classInternalName:String):this.type =
	{
		methodNode
			.instructions
			.add(
				new FieldInsnNode(
					Opcodes.GETSTATIC, ownerClassInternalName, name, Utils getClassDescriptor classInternalName
				)
			)

		incrementObjectStackCounter()

		this
	}

	def invokevirtual(methodInvocationDescriptor:MethodInvocationDescriptor):this.type =
		invokevirtual(
			methodInvocationDescriptor.ownerClassInternalName,
			methodInvocationDescriptor.name,
			methodInvocationDescriptor.untypedSignature,
			methodInvocationDescriptor.consumedStackObjectCount,
			isInterfaceMethod = false
		)

	def invokevirtual(
		methodOwnerClassInternalName:String,
		methodName:String,
		methodSignature:String,
		consumedStackObjectCount:Int,
		isInterfaceMethod:Boolean
	):this.type =
	{
		methodNode
			.instructions
			.add(
				new MethodInsnNode(
					Opcodes.INVOKEVIRTUAL, methodOwnerClassInternalName, methodName, methodSignature, isInterfaceMethod
				)
			)

		if (consumedStackObjectCount > 0) decreaseObjectStackCounter(consumedStackObjectCount)
		else if (consumedStackObjectCount < 0) increaseObjectStackCounter(-consumedStackObjectCount)

		this
	}

	def invokeinit(methodInvocationDescriptor:MethodInvocationDescriptor):this.type =
		invokeinit(
			methodInvocationDescriptor.ownerClassInternalName,
			methodInvocationDescriptor.untypedSignature,
			methodInvocationDescriptor.consumedStackObjectCount
		)

	def invokeinit(
		initMethodOwnerClassInternalName:String, initMethodSignature:String, consumedStackObjectCount:Int
	):this.type =
	{
		methodNode
			.instructions
			.add(
				new MethodInsnNode(
					Opcodes.INVOKESPECIAL,
					initMethodOwnerClassInternalName,
					InternalDescriptors.INIT_METHOD,
					initMethodSignature,
					false
				)
			)

		if (consumedStackObjectCount > 0) decreaseObjectStackCounter(consumedStackObjectCount)
		else if (consumedStackObjectCount < 0) increaseObjectStackCounter(-consumedStackObjectCount)

		this
	}

	def invokestatic(methodInvocationDescriptor:MethodInvocationDescriptor):this.type =
		invokestatic(
			methodInvocationDescriptor.ownerClassInternalName,
			methodInvocationDescriptor.name,
			methodInvocationDescriptor.untypedSignature,
			methodInvocationDescriptor.consumedStackObjectCount
		)

	def invokestatic(
		methodOwnerClassInternalName:String,
		methodName:String,
		methodSignature:String,
		consumedStackObjectCount:Int
	):this.type =
	{
		methodNode
			.instructions
			.add(
				new MethodInsnNode(
					Opcodes.INVOKESTATIC, methodOwnerClassInternalName, methodName, methodSignature, false
				)
			)

		if (consumedStackObjectCount > 0) decreaseObjectStackCounter(consumedStackObjectCount)
		else if (consumedStackObjectCount < 0) increaseObjectStackCounter(-consumedStackObjectCount)

		this
	}

	def `new`(`class`:Class[_]):this.type =
	{
		`new`(Utils.getClassInternalName(`class`))

		this
	}

	def `new`(classInternalName:String):this.type =
	{
		methodNode.instructions.add(new TypeInsnNode(Opcodes.NEW, classInternalName))

		incrementObjectStackCounter()

		this
	}

	def anewarray(arrayClass:Class[_]):this.type =
	{
		anewarray(Utils.getClassInternalName(arrayClass))

		this
	}

	def anewarray(arrayClassInternalName:String):this.type =
	{
		methodNode.instructions.add(new TypeInsnNode(Opcodes.ANEWARRAY, arrayClassInternalName))

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

	def incrementObjectStackCounter():this.type =
	{
		objectStackCounter.increment()
		this
	}

	def decrementObjectStackCounter():this.type =
	{
		objectStackCounter.decrement()
		this
	}

	def increaseObjectStackCounter(count:Int):this.type =
	{
		objectStackCounter.increase(count)
		this
	}

	def decreaseObjectStackCounter(count:Int):this.type =
	{
		objectStackCounter.decrease(count)
		this
	}

	def pushFrame():this.type =
	{
		objectStackCounter.push()
		this
	}

	def popFrame():this.type =
	{
		objectStackCounter.pop()
		this
	}
}

private class ObjectStackCounter(method:MethodBuilder)
{
	private val counters = mutable.Stack[Int](0)

	def increment():Unit = increase(1)
	def decrement():Unit = decrease(1)
	def decrease(count:Int):Unit = counters(0) -= count
	def increase(count:Int):Unit = counters(0) += count
	def push():Unit = counters.push(0)

	def pop()
	{
		while (counters.head > 0) method.pop()

		counters.pop()
	}
}