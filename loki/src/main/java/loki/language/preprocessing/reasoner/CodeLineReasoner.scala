package loki.language.preprocessing.reasoner
import loki.language.preprocessing.CodeLine
import loki.language.preprocessing.constant.ControlCharacters

private[preprocessing] class CodeLineReasoner(code:String) extends Reasoner
{
	override def apply():collection.Seq[CodeLine] = code.split(ControlCharacters.NEW_LINE).map(new CodeLine(_))
}

private[preprocessing] object CodeLineReasoner
{
	def apply(code:String) = new CodeLineReasoner(code)()
}