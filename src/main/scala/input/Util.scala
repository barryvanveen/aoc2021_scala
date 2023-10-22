package input

import scala.io.Source

object Util {
  private def toAbsolutePath(filename: String): String = {
    getClass.getClassLoader.getResource(filename).getPath
  }

  def readLinesAsInt(filename: String): List[Int] = {
    val bufferedSource = Source.fromFile(
      toAbsolutePath(filename)
    )
    val lines = bufferedSource.getLines.toList.map(_.toInt)
    bufferedSource.close();
    lines
  }
}
