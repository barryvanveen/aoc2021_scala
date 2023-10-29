package Day1

import input.InputFile
import input.Util.readLinesAsInt

object Main extends InputFile {
  def main(args: Array[String]): Unit = {
    val lines = readLinesAsInt(getInputFile(args))

    val answer1 = part1(lines)
    println(s"Part 1: $answer1")
    val answer2 = part2(lines)
    println(s"Part 2: $answer2")
  }

  def part1(lines: List[Int]): Int = {
    val increases = countListIncreases(lines)
    increases
  }

  def part2(lines: List[Int]): Int = {
    val increases = countListIncreases(
      lines.sliding(3).map(_.sum).toList
    )
    increases
  }

  private def countListIncreases(list: List[Int]): Int = {
    if (list.length < 2)
      return 0;

    list.sliding(2)
      .foldLeft(0)(
        (carry, list) => if (list.head.compare(list(1)) == -1) carry + 1 else carry
      )
  }
}
