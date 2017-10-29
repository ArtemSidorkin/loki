package cloki.test

import java.io.{OutputStream, PrintStream}

private[test] class TestOutputStream
	extends PrintStream(
		new OutputStream
		{
			override def write(int:Int):Unit = ()
		}
	)
{
	private val _content = new StringBuilder

	def content:String = _content.toString

	override def println():Unit = _content += '\n'

	override def println(any:Any)
	{
		if (_content.nonEmpty) _content += '\n'
		_content ++= any.toString
	}

	override def println(string:String):Unit = this.println(string.asInstanceOf[Any])
}
