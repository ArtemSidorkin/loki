package loki.execution

import java.io.PrintStream

import loki.language.generation.BytecodeGenerator

object Execution
{
	@volatile
	private var _executor:Executor = null.asInstanceOf[Executor]

	def executor:Executor = _executor

	def init(
		rootModulePathname:String,
		force:Boolean = false,
		outputPrintStream:PrintStream = System.out,
		errorPrintStream:PrintStream = System.err
	):Unit =
		if (_executor == null || force) this.synchronized
		{
			if (_executor == null || force)
				_executor = new Executor(rootModulePathname, outputPrintStream, errorPrintStream, new BytecodeGenerator(_))
		}
}