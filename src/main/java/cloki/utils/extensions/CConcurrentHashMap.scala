package cloki.utils.extensions

import java.util.concurrent.ConcurrentHashMap

object CConcurrentHashMap
{
	implicit class CConcurrentHashMap[KEY, VALUE](concurrentHashMap:ConcurrentHashMap[KEY, VALUE])
	{
		def +=(items:(KEY, VALUE)*) = items foreach (itm => concurrentHashMap.put(itm._1, itm._2))

		def apply(key:KEY) =
		{
			val vl = concurrentHashMap.get(key)
			if (vl == null) throw new NoSuchElementException(s"""Key "$key" is not found!""")
			vl
		}

		def get(key:KEY) = Option(concurrentHashMap.get(key))

		def getOrElse(key:KEY, defaultValue: => VALUE) = get(key) getOrElse defaultValue
	}

	def apply[KEY, VALUE](concurrentHashMap:ConcurrentHashMap[KEY, VALUE]) =
		new CConcurrentHashMap(concurrentHashMap)
}
