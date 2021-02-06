package loki.util

import java.util.concurrent.atomic.AtomicLong

//TODO: make fixed class names for units
class IdGenerator
{
	private val idCounter = new AtomicLong()

	def apply():Long = idCounter.incrementAndGet()
}

object IdGenerator extends IdGenerator
