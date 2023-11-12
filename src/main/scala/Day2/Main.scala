package Day2

import input.InputFile
import input.Util.readLines

object Main extends InputFile {
  def main(args: Array[String]): Unit = {
    val input = readLines(getInputFile(args))

    val value1 = part1(input)
    println(s"Part 1: $value1")
    val value2 = part2(input)
    println(s"Part 2: $value2")
  }

  def part1(input: List[String]): Int = {
    // start at 0,0 and move through all steps, returning the value of the final position
    input.map(Step.apply).foldLeft(Position(0, 0))(
      (currentPosition, nextStep) => currentPosition.move(nextStep)
    ).value
  }

  def part2(input: List[String]): Int = {
    // start at 0,0 and move through all steps, returning the value of the final position
    input.map(Step.apply).foldLeft(PositionWithAim(0, 0, 0))(
      (currentPosition, nextStep) => currentPosition.move(nextStep)
    ).value
  }
}
