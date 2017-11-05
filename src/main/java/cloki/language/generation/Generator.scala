package cloki.language.generation

import cloki.language.parsing.LokiBaseListener

abstract class Generator[GENERATION_CONTEXT <: Generation#GenerationContext] extends LokiBaseListener
{
	val classLoader = new GenerationClassLoader

	protected implicit val generationContext:GENERATION_CONTEXT
}
