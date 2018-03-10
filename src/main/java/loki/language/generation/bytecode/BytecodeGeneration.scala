package loki.language.generation.bytecode

import loki.language.generation.bytecode.classbuilder.FrameClassBuilder
import loki.language.generation.{Generation, GenerationClassLoader}
import loki.util.IdGenerator

private[bytecode] object BytecodeGeneration extends Generation
{
	type GENERATION_CONTEXT = BytecodeGenerationContext
	type FRAME_STACK = BytecodeFrameStack
	type FRAME = BytecodeFrame
	type ID = Long

	private val frameIdGenerator = new IdGenerator

	class BytecodeGenerationContext(programName:String, classLoader:GenerationClassLoader)
		extends GenerationContext(programName, classLoader)
	{
		override def createFrameStack = new BytecodeFrameStack
	}

	class BytecodeFrameStack extends FrameStack
	{
		def push(classFrame:FrameClassBuilder):Unit = frames.push(new BytecodeFrame(classFrame, frameIdGenerator()))

		def push(classFrameCreator: (ID => FrameClassBuilder))
		{
			val id = frameIdGenerator()

			frames.push(new BytecodeFrame(classFrameCreator(id), id))
		}
	}

	class BytecodeFrame(val classFrame:FrameClassBuilder, val id:ID) extends Frame
}

