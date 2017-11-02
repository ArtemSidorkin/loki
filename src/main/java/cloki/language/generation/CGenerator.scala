package cloki.language.generation

import cloki.language.parsing.LokiBaseListener

abstract class CGenerator[GENERATION_CONTEXT <: CGeneration#CGenerationContext] extends LokiBaseListener
{
	val classLoader = new CClassLoader

	protected implicit val generationContext:GENERATION_CONTEXT
}
