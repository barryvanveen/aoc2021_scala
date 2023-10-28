package input

import scala.io.Source

object Util {
  private def toAbsolutePath(filename: String): String = {
    getClass.getClassLoader.getResource(filename).getPath
  }

  def readLines(filename: String): List[String] = {
    val bufferedSource = Source.fromFile(
      toAbsolutePath(filename)
    )
    val lines = bufferedSource.getLines.toList
    bufferedSource.close()
    lines
  }

  def readLinesAsInt(filename: String): List[Int] = {
    this.readLines(filename).map(_.toInt)
  }
}
