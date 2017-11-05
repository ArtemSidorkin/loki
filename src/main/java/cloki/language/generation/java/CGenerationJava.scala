package cloki.language.generation.java

import cloki.language.generation.{Generation, GenerationClassLoader}

private[generation] object CGenerationJava extends Generation
{
	type GENERATION_CONTEXT = CGenerationContextJava
	type FRAME_STACK = CFrameStackJava
	type FRAME = CFrameJava

	class CGenerationContextJava(moduleName:String, classLoader:GenerationClassLoader)
		extends GenerationContext(moduleName, classLoader)
	{
		val code:StringBuilder = new StringBuilder

		override def createFrameStack = new CFrameStackJava
	}

	class CFrameStackJava extends FrameStack
	{
		def push():Unit = frames.push(new CFrameJava)
	}

	class CFrameJava extends Frame
}
