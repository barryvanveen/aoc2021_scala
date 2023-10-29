package Day2

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.prop.TableDrivenPropertyChecks.*

class PositionTest extends AnyFunSpec  {
  describe("Position") {
    val moves =
      Table(
        ("input", "output"), // First tuple defines column names
        (Step(Direction.forward, 1), Position(1, 0)),
        (Step(Direction.forward, 2), Position(2, 0)),
        (Step(Direction.up, 1), Position(0, -1)),
        (Step(Direction.up, 2), Position(0, -2)),
        (Step(Direction.down, 1), Position(0, 1)),
        (Step(Direction.down, 2), Position(0, 2)),
      )

    it("it moves to the correct position") {
      forAll(moves) { (step: Step, output: Position) =>
        assert(Position(0, 0).move(step) == output)
      }
    }

    val positions =
      Table(
        ("input", "output"), // First tuple defines column names
        (Position(0, 0), 0),
        (Position(1, 0), 0),
        (Position(1, 1), 1),
        (Position(5, 1), 5),
        (Position(15, 10), 150),
        (Position(15, -10), -150),
      )

    it("it calculates the value") {
      forAll(positions) { (position: Position, output: Int) =>
        assert(position.value == output)
      }
    }
  }
}
