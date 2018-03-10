package loki.language.generation.java

import loki.language.generation.{Generation, GenerationClassLoader}

private[generation] object JavaGeneration extends Generation
{
	type GENERATION_CONTEXT = JavaGenerationContext
	type FRAME_STACK = JavaFrameStack
	type FRAME = JavaFrame

	class JavaGenerationContext(moduleName:String, classLoader:GenerationClassLoader)
		extends GenerationContext(moduleName, classLoader)
	{
		val code:StringBuilder = new StringBuilder

		override def createFrameStack = new JavaFrameStack
	}

	class JavaFrameStack extends FrameStack
	{
		def push():Unit = frames.push(new JavaFrame)
	}

	class JavaFrame extends Frame
}
