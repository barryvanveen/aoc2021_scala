package Day2

import input.InputFile
import input.Util.readLines

object Main extends InputFile {
  def main(args: Array[String]): Unit = {
    val input = readLines(getInputFile(args))

    val value1 = part1(input)
    println(s"Part 1: $value1")
  }

  def part1(input: List[String]): Int = {
    // start at 0,0 and move through all steps, returning the value of the final position
    input.map(InputUtils.inputToStep).foldLeft(Position(0, 0))(
      (currentPosition, nextStep) => currentPosition.move(nextStep)
    ).value
  }

  private def part2(lines: List[Int]): Unit = {
    println(s"Part 2: ???")
  }
}
