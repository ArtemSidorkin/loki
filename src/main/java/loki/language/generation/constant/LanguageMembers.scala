package loki.language.generation.constant

private[generation] object LanguageMembers
{
	val TYPE__METHOD__CREATE_ANONYMOUS = "createAnonymous"

	val UNIT_CONTEXT__METHOD__GET_VARIABLE = "getVariable"
	val UNIT_CONTEXT__METHOD__SET_VARIABLE = "setVariable"

	val UNIT__FIELD__UNIT_CONTEXT = "unitContext"
	val UNIT__METHOD__INIT__CALL_PARAMETER__CONTEXT = "unitContext"
	val UNIT__METHOD__ADD_PARENT = "addParent"
	val UNIT__METHOD__GET_SUPER_MEMBER = "getSuperMember"
	val UNIT__METHOD__GET_MEMBER = "getMember"
	val UNIT__METHOD__SET_MEMBER = "setMember"
	val UNIT__METHOD__GET_INDEXED_ITEM = "getIndexedItem"
	val UNIT__METHOD__SET_INDEXED_ITEM = "setIndexedItem"
	val UNIT__METHOD__SET_PARAMETER_NAMES = "setParameterNames"
	val UNIT__METHOD__CALL__PARAMETER__HOST = "host"
	def UNIT__METHOD__CALL__PARAMETER__PARAMETERS = "parameters" //why def?
	val UNIT__METHOD__CALL__PARAMETER__CONTEXT = "unitContext"
	val UNIT__METHOD__CALL = "call"
	val UNIT__METHOD__CALL_MEMBER = "callMember"
	val UNIT__METHOD__CHECK_CALL_PARAMETER = "checkCallParameter"
	val UNIT__METHOD__TO_BOOLEAN = "toBoolean"
	val UNIT__METHOD__TO_STRING = "toString"

	val UNARY_OPERATOR_BANG = "!_"
	val UNARY_OPERATOR_MINUS = "-_"

	val OPERATOR_STAR = "*"
	val OPERATOR_SLASH = "/"
	val OPERATOR_PLUS = "+"
	val OPERATOR_MINUS = "-"

	val OPERATOR_EQUALS_EQUALS = "=="
	val OPERATOR_BANG_EQUALS = "!="
	val OPERATOR_GREATER_THAN_EQUALS = ">="
	val OPERATOR_GREATER_THAN = ">"
	val OPERATOR_LESS_THAN_EQUALS = "<="
	val OPERATOR_LESS_THAN = "<"

	val OPERATOR_AMPERSAND_AMPERSAND = "&&"
	val OPERATOR_PIPE_PIPE = "||"
}