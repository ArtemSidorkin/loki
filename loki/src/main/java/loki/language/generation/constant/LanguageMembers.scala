package loki.language.generation.constant

private[generation] object LanguageMembers
{
	val JAVA_OBBJECT__METHOD__GET_CLASS = "getClass"

	val TYPE__METHOD__CREATE_ANONYMOUS = "createAnonymous"

	val UNIT_CONTEXT__METHOD__GET_VARIABLE = "getVariable"
	val UNIT_CONTEXT__METHOD__SET_VARIABLE = "setVariable"

	val UNIT__METHOD__GET_CAPTURED_UNIT_CONTEXT = "getCapturedUnitContext"
	val UNIT__METHOD__SET_TYPE = "setType"
	val UNIT__METHOD__ADD_PARENTS = "addParents"
	val UNIT__METHOD__GET_SUPER_MEMBER = "getSuperMember"
	val UNIT__METHOD__GET_MEMBER = "getMember"
	val UNIT__METHOD__SET_MEMBER = "setMember"
	val UNIT__METHOD__GET_INDEXED_ITEM = "getIndexedItem"
	val UNIT__METHOD__SET_INDEXED_ITEM = "setIndexedItem"
	val UNIT__METHOD__SET_PARAMETER_NAMES = "setParameterNames"
	val UNIT__METHOD__CALL = "call"
	val UNIT__METHOD__CALL_MEMBER = "callMember"
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
