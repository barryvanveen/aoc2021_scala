package Day1

import scala.io.Source
import input.Util

object Main {
  def main(args: Array[String]): Unit = {
    val lines = input.Util.readLinesAsInt("day1_example.txt")

    part1(lines)
    part2(lines)
  }

  private def part1(lines: List[Int]): Unit = {
    val increases = countListIncreases(lines)
    println(s"Part 1: ${increases}")
  }

  private def part2(lines: List[Int]): Unit = {
    val increases = countListIncreases(
      lines.sliding(3).map(_.sum).toList
    )
    println(s"Part 2: ${increases}")
  }

  private def countListIncreases(list: List[Int]): Int = {
    list.sliding(2)
      .foldLeft(0)(
        (carry, list) => if (list.head.compare(list(1)) == -1) carry + 1 else carry
      )
  }

  private def readLinesAsInt(filename: String): List[Int] = {
    val filePath = getClass.getClassLoader.getResource(filename).getPath
    val bufferedSource = Source.fromFile(filePath)
    val lines = bufferedSource.getLines.toList.map(_.toInt)
    bufferedSource.close();
    lines
  }
}
