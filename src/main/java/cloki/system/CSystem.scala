package cloki.system

object CSystem
{
	sealed class OS
	object WINDOWS extends OS
	object UNIX extends OS

	val OS:OS = if ((System getProperty "os.name").toLowerCase startsWith "win") WINDOWS else UNIX
	val SOURCE_FILE_EXTENSION = "cloki"
}
