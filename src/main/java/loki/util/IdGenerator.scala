package loki.util

import java.util.concurrent.atomic.AtomicLong

class IdGenerator
{
	private val idCounter = new AtomicLong()

	def apply():Long = idCounter.incrementAndGet()
}

object IdGenerator extends IdGenerator
