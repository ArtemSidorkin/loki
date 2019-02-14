package loki.language.generation

import loki.language.generation.classbuilder.FrameClassBuilder
import loki.util.IdGenerator

import scala.collection.mutable
;

class BytecodeFrameStack
{
	protected val frames:mutable.ArrayStack[BytecodeFrame] = new mutable.ArrayStack[BytecodeFrame]()
	private val frameIdGenerator = new IdGenerator

	def apply(frameIndex:Int):BytecodeFrame = frames(frameIndex)

	def size: Int = frames.size

	def pop():Unit = frames.pop()
	def top:BytecodeFrame = frames.top
	def preTop:BytecodeFrame = frames.tail.head

	def push(classFrame:FrameClassBuilder):Unit = frames.push(new BytecodeFrame(classFrame, frameIdGenerator()))

	def push(classFrameCreator: (Long => FrameClassBuilder))
	{
		val id = frameIdGenerator()

		frames.push(new BytecodeFrame(classFrameCreator(id), id))
	}
}
