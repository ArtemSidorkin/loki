package loki.language.preprocessing.reasoner

import loki.language.preprocessing.CodeLine

private[preprocessing] trait Reasoner
{
	def apply():collection.Seq[CodeLine]
}
