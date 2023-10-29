package Day2

case class PositionWithAim(
 horizontal: Int,
 depth: Int,
 aim: Int,
):
  def move(step: Step): PositionWithAim = step.direction match
    case Direction.down => PositionWithAim(this.horizontal, this.depth, this.aim + step.distance)
    case Direction.up => PositionWithAim(this.horizontal, this.depth, this.aim - step.distance)
    case Direction.forward => PositionWithAim(this.horizontal + step.distance, this.depth + (this.aim * step.distance), this.aim)

  def print(): Unit =
    println(s"horizontal: ${this.horizontal}, depth: ${this.depth}")

  def value: Int =
    this.horizontal * this.depth

