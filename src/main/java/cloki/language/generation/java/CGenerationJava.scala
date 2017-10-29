package cloki.language.generation.java

import cloki.language.generation.{CClassLoader, CGeneration}

private[generation] object CGenerationJava extends CGeneration
{
	type GENERATION_CONTEXT = CGenerationContextJava
	type FRAME_STACK = CFrameStackJava
	type FRAME = CFrameJava

	class CGenerationContextJava(moduleName:String, classLoader:CClassLoader)
		extends CGenerationContext(moduleName, classLoader)
	{
		val code:StringBuilder = new StringBuilder

		override def createFrameStack = new CFrameStackJava
	}

	class CFrameStackJava extends CFrameStack
	{
		def push():Unit = frames.push(new CFrameJava)
	}

	class CFrameJava extends CFrame
}
