package input

trait InputFile {
  def getInputFile(args: Array[String]): String =
    val filename = s"${getClass.getPackageName.toLowerCase}"

    if (args.contains("--example"))
      return s"${filename}_example.txt"

    s"$filename.txt"
}
