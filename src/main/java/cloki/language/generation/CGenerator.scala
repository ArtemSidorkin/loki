package cloki.language.generation

import cloki.language.parsing.CLokiBaseListener

abstract class CGenerator[GENERATION_CONTEXT <: CGeneration#CGenerationContext] extends CLokiBaseListener
{
	val classLoader = new CClassLoader

	protected implicit val generationContext:GENERATION_CONTEXT
}
