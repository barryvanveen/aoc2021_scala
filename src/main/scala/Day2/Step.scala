package Day2

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

object Step:
  def apply(input: String) =
    new Step(
      Direction.valueOf(input.substring(0, input.indexOf(' '))),
      input.substring(input.indexOf(' ') + 1).toInt
    )
