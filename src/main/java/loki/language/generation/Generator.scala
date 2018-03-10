package loki.language.generation

import loki.language.parsing.LokiBaseListener

abstract class Generator[GENERATION_CONTEXT <: Generation#GenerationContext] extends LokiBaseListener
{
	val classLoader = new GenerationClassLoader
}
