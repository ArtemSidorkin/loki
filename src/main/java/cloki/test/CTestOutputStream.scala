package cloki.test

import java.io.{OutputStream, PrintStream}

private[test] class CTestOutputStream extends PrintStream(new OutputStream
{
	override def write(int:Int):Unit = ()
})
{
	private val _content = new StringBuilder

	def content = _content.toString

	override def println() = _content += '\n'

	override def println(any:Any)
	{
		if (_content.nonEmpty) _content += '\n'
		_content ++= any.toString
	}

	override def println(string:String):Unit = this.println(string.asInstanceOf[Any])
}
