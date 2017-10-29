package cloki.utils

import java.util.concurrent.atomic.AtomicLong

class IdGenerator
{
	private val idCounter = new AtomicLong()

	def apply() = idCounter.incrementAndGet()
}

object IdGenerator extends IdGenerator
