package Day2

import input.InputFile
import input.Util.readLines

object Main extends InputFile {
  def main(args: Array[String]): Unit = {
    val steps = readLines(getInputFile(args))
      .map(InputUtils.inputToStep)

    part1(steps)
  }

  private def part1(steps: List[Step]): Unit = {
    val end = steps.foldLeft(Position(0, 0))(
      (currentPosition, nextStep) => currentPosition.move(nextStep)
    )
    println(s"Part 1: ${end.value}")
  }

  private def part2(lines: List[Int]): Unit = {
    println(s"Part 2: ???")
  }
}
