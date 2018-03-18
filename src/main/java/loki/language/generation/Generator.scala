package loki.language.generation

import loki.language.parsing.LokiBaseListener
import org.antlr.v4.runtime.tree.ErrorNode

abstract class Generator[GENERATION_CONTEXT <: Generation#GenerationContext] extends LokiBaseListener
{
	val classLoader = new GenerationClassLoader

	override def visitErrorNode(errorNode:ErrorNode):Unit = throw new IllegalStateException
}
