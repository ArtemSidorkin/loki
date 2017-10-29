package cloki.system

object SystemConfiguration
{
	sealed class OS
	object WINDOWS extends OS
	object UNIX extends OS

	val OS:OS = if ((System getProperty "os.name").toLowerCase startsWith "win") WINDOWS else UNIX
	val SOURCE_FILE_EXTENSION = "cloki"
}
