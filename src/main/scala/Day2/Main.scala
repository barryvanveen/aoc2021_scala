package Day2

import input.Util.{readLines, readLinesAsInt}

case class Position(
   horizontal: Int,
  depth: Int,
):
  def move(step: Position): Position =
    Position(
      this.horizontal + step.horizontal,
      this.depth + step.depth
    )
  def print(): Unit =
    println(s"horizontal: ${this.horizontal}, depth: ${this.depth}")
  def value: Int =
    this.horizontal * this.depth

enum Direction:
  case forward, down, up;

case class Step(
  direction: Direction,
  distance: Int,
):
  def toPosition: Position = this.direction match
    case Direction.up => Position(0, -1 * this.distance)
    case Direction.down => Position(0, this.distance)
    case Direction.forward => Position(this.distance, 0)
  def print: Unit =
    println(s"${this.direction.toString} ${this.distance}")

object InputUtils:
  def inputToStep(input: String): Step =
    Step(
      Direction.valueOf(input.substring(0, input.indexOf(' '))),
      input.substring(input.indexOf(' ')+1).toInt
    )

object Main {
  def main(args: Array[String]): Unit = {
    val steps = readLines("day2.txt")
      .map(InputUtils.inputToStep)

    part1(steps)
//    part2(lines)
  }

  private def part1(steps: List[Step]): Unit = {
//    val increases = countListIncreases(lines)
    val end = steps.map(_.toPosition).foldLeft(Position(0, 0))(
        (currentPosition, nextStep) => currentPosition.move(nextStep)
      )
    end.print
    println(s"Part 1: ${end.value}")
  }

  private def part2(lines: List[Int]): Unit = {
//    val increases = countListIncreases(
//      lines.sliding(3).map(_.sum).toList
//    )
    println(s"Part 2: ???")
  }

}
