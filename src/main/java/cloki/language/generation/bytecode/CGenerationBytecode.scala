package cloki.language.generation.bytecode

import cloki.language.generation.bytecode.classes.CClassFrame
import cloki.language.generation.{Generation, GenerationClassLoader}
import cloki.util.IdGenerator

private[bytecode] object CGenerationBytecode extends Generation
{
	type GENERATION_CONTEXT = CGenerationContextBytecode
	type FRAME_STACK = CFrameStackBytecode
	type FRAME = CFrameBytecode
	type ID = Long

	private val frameIdGenerator = new IdGenerator

	class CGenerationContextBytecode(programName:String, classLoader:GenerationClassLoader)
		extends GenerationContext(programName, classLoader)
	{
		override def createFrameStack = new CFrameStackBytecode
	}

	class CFrameStackBytecode extends FrameStack
	{
		def push(classFrame:CClassFrame):Unit = frames.push(new CFrameBytecode(classFrame, frameIdGenerator()))

		def push(classFrameCreator: (ID => CClassFrame))
		{
			val id = frameIdGenerator()
			frames.push(new CFrameBytecode(classFrameCreator(id), id))
		}
	}

	class CFrameBytecode(val classFrame:CClassFrame, val id:ID) extends Frame
}

