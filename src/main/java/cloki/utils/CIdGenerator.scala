package cloki.utils

import java.util.concurrent.atomic.AtomicLong

class CIdGenerator
{
	private val idCounter = new AtomicLong()

	def apply() = idCounter.incrementAndGet()
}

object CIdGenerator extends CIdGenerator
