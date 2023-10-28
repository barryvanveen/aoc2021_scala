package Day2

case class Position(
 horizontal: Int,
 depth: Int,
):
  def move(step: Step): Position = step.direction match
    case Direction.up => Position(this.horizontal, this.depth - step.distance)
    case Direction.down => Position(this.horizontal, this.depth + step.distance)
    case Direction.forward => Position(this.horizontal + step.distance, this.depth)

  def print(): Unit =
    println(s"horizontal: ${this.horizontal}, depth: ${this.depth}")

  def value: Int =
    this.horizontal * this.depth

