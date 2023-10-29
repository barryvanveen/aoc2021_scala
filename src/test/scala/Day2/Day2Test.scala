package Day2

import org.scalatest.funspec.AnyFunSpec

class Day2Test extends AnyFunSpec  {
  describe("Part 1") {
    it("it calculates the value of the final position") {
      val input = List(
        "forward 5",
        "down 5",
        "forward 8",
        "up 3",
        "down 8",
        "forward 2",
      )

      assert(Day2.Main.part1(input) === 150)
    }
  }
}
