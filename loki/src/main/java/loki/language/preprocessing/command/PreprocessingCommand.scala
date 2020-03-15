package loki.language.preprocessing.command

private[preprocessing] trait PreprocessingCommand
{
	def apply(code:StringBuilder):Unit
}
