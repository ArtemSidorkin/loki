package loki.language.preprocessing.commands

private[preprocessing] trait PreprocessingCommand
{
	def apply(code:StringBuilder):Unit
}
