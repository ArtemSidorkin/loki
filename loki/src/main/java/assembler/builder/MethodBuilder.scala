package assembler.builder

import assembler.InternalDescriptors.INIT_METHOD
import assembler.Utils
import assembler.Utils.{getClassDescriptor, getClassInternalName}
import assembler.methoddescriptor.{MethodDescriptor, MethodInvocationDescriptor}
import org.objectweb.asm.Opcodes.{AASTORE, ALOAD, ANEWARRAY, ARETURN, ASTORE, DUP, GETSTATIC, GOTO, IFEQ, INVOKESPECIAL, INVOKESTATIC, INVOKEVIRTUAL, NEW, POP, RETURN, SWAP}
import org.objectweb.asm.tree.{AbstractInsnNode, FieldInsnNode, InsnNode, JumpInsnNode, LabelNode, LdcInsnNode, MethodInsnNode, MethodNode, TypeInsnNode, VarInsnNode}

import scala.collection.mutable

class MethodBuilder private[builder](val modifier:Modifier, val descriptor:MethodDescriptor)
{
	private[builder] val methodNode =
		new MethodNode(modifier.code, descriptor.name, descriptor.untypedSignature, null, null)

	private val operandStackCounter = new OperandStackCounter(this)

	def ldc(any:Any):this.type =
	{
		addInstructionNode(new LdcInsnNode(any))

		incrementOperandStackCounter()

		this
	}

	def aload(variableIndex:Int):this.type =
	{
		addInstructionNode(new VarInsnNode(ALOAD, variableIndex))

		incrementOperandStackCounter()

		this
	}

	def aloadthis():this.type =
	{
		addInstructionNode(new VarInsnNode(ALOAD, 0))

		incrementOperandStackCounter()

		this
	}

	def aastore():this.type =
	{
		addInstructionNode(new InsnNode(AASTORE))

		decreaseOperandStackCounter(3)

		this
	}

	def astore(variableIndex:Int):this.type =
	{
		addInstructionNode(new VarInsnNode(ASTORE, variableIndex))

		decrementOperandStackCounter()

		this
	}

	def `new`(`class`:Class[_]):this.type =
	{
		`new`(getClassInternalName(`class`))

		this
	}

	def `new`(classInternalName:String):this.type =
	{
		addInstructionNode(new TypeInsnNode(NEW, classInternalName))

		incrementOperandStackCounter()

		this
	}

	def anewarray(arrayClass:Class[_]):this.type =
	{
		anewarray(getClassInternalName(arrayClass))

		this
	}

	def anewarray(arrayClassInternalName:String):this.type =
	{
		addInstructionNode(new TypeInsnNode(ANEWARRAY, arrayClassInternalName))

		this
	}

	def pop():this.type =
	{
		addInstructionNode(new InsnNode(POP))
		decrementOperandStackCounter()
		this
	}

	def dup():this.type =
	{
		addInstructionNode(new InsnNode(DUP))
		incrementOperandStackCounter()
		this
	}

	def swap():this.type =
	{
		addInstructionNode(new InsnNode(SWAP))
		this
	}

	def ifeq(labelNode:LabelNode):this.type =
	{
		addInstructionNode(new JumpInsnNode(IFEQ, labelNode))
		decrementOperandStackCounter()
		this
	}

	def goto(labelNode:LabelNode):this.type =
	{
		addInstructionNode(new JumpInsnNode(GOTO, labelNode))
		this
	}

	def label(labelNode:LabelNode):this.type =
	{
		addInstructionNode(labelNode)
		this
	}

	def aReturn():this.type =
	{
		addInstructionNode(new InsnNode(ARETURN))

		this
	}

	def `return`():this.type =
	{
		addInstructionNode(new InsnNode(RETURN))
		this
	}

	def getstatic(ownerClass:Class[_], name:String, `class`:Class[_]):this.type =
		getstatic(getClassInternalName(ownerClass), name, getClassInternalName(`class`))

	def getstatic(ownerClassInternalName:String, name:String, classInternalName:String):this.type =
	{
		addInstructionNode(
			new FieldInsnNode(GETSTATIC, ownerClassInternalName, name, getClassDescriptor(classInternalName))
		)

		incrementOperandStackCounter()

		this
	}

	def invokevirtual(methodInvocationDescriptor:MethodInvocationDescriptor):this.type =
		invokevirtual(
			methodInvocationDescriptor.ownerClassInternalName,
			methodInvocationDescriptor.name,
			methodInvocationDescriptor.untypedSignature,
			methodInvocationDescriptor.consumedStackOperandCount,
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
		addInstructionNode(
			new MethodInsnNode(
				INVOKEVIRTUAL, methodOwnerClassInternalName, methodName, methodSignature, isInterfaceMethod
			)
		)

		decreaseOperandStackCounter(consumedStackObjectCount)

		this
	}

	def invokeinit(methodInvocationDescriptor:MethodInvocationDescriptor):this.type =
		invokeinit(
			methodInvocationDescriptor.ownerClassInternalName,
			methodInvocationDescriptor.untypedSignature,
			methodInvocationDescriptor.consumedStackOperandCount
		)

	def invokeinit(
		initMethodOwnerClassInternalName:String, initMethodSignature:String, consumedStackObjectCount:Int
	):this.type =
	{
		addInstructionNode(
			new MethodInsnNode(INVOKESPECIAL, initMethodOwnerClassInternalName, INIT_METHOD, initMethodSignature, false)
		)

		decreaseOperandStackCounter(consumedStackObjectCount)

		this
	}

	def invokestatic(methodInvocationDescriptor:MethodInvocationDescriptor):this.type =
		invokestatic(
			methodInvocationDescriptor.ownerClassInternalName,
			methodInvocationDescriptor.name,
			methodInvocationDescriptor.untypedSignature,
			methodInvocationDescriptor.consumedStackOperandCount
		)

	def invokestatic(
		methodOwnerClassInternalName:String,
		methodName:String,
		methodSignature:String,
		consumedStackObjectCount:Int
	):this.type =
	{
		addInstructionNode(
			new MethodInsnNode(INVOKESTATIC, methodOwnerClassInternalName, methodName, methodSignature, false)
		)

		decreaseOperandStackCounter(consumedStackObjectCount)

		this
	}

	def incrementOperandStackCounter():this.type =
	{
		operandStackCounter.increment()
		this
	}

	def decrementOperandStackCounter():this.type =
	{
		operandStackCounter.decrement()
		this
	}

	def increaseOperandStackCounter(count:Int):this.type =
	{
		operandStackCounter.increase(count)
		this
	}

	def decreaseOperandStackCounter(count:Int):this.type =
	{
		operandStackCounter.decrease(count)
		this
	}

	def pushFrame():this.type =
	{
		operandStackCounter.push()
		this
	}

	def popFrame():this.type =
	{
		operandStackCounter.pop()
		this
	}

	private def addInstructionNode(instruction:AbstractInsnNode):Unit = methodNode.instructions.add(instruction)
}

object MethodBuilder
{
	def initMethodBuilder(modifier:Modifier, descriptor:MethodDescriptor):MethodBuilder =
		new MethodBuilder(modifier, descriptor)
}

private class OperandStackCounter(method:MethodBuilder)
{
	private val counters = mutable.Stack[Int](0)

	def increment():Unit = increase(1)

	def decrement():Unit = decrease(1)

	def decrease(count:Int):Unit = counters(0) -= count

	def increase(count:Int):Unit = counters(0) += count

	def push():Unit = counters.push(0)

	def pop():Unit =
	{
		while (counters.head > 0) method.pop()

		counters.pop()
	}
}