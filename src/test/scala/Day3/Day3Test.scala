package Day3

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.prop.TableDrivenPropertyChecks.*

class Day3Test extends AnyFunSpec  {
  describe("Part 1") {
    val stringToIntCases =
      Table(
        ("input", "output"), // First tuple defines column names
        ("00", List(0, 0)),
        ("01234", List(0, 1, 2, 3, 4)),
        ("001100", List(0, 0, 1, 1, 0, 0)),
      )

    it("it converts a string to a list of ints") {
      forAll(stringToIntCases) { (input: String, output: List[Int]) =>
        assert(Day3.Main.stringToIntList(input) == output)
      }
    }

    val booleanListToBinaryIntCases =
      Table(
        ("input", "output"), // First tuple defines column names
        (List(0, 0, 0), 0),
        (List(1, 0, 0), 4),
        (List(1, 1, 1), 7),
        (List(1, 0, 1, 1, 0), 22),
      )

    it("it converts a list of binary ints to the binary value") {
      forAll(booleanListToBinaryIntCases) { (input: List[Int], output: Int) =>
        assert(Day3.Main.booleanListToBinaryValue(input) == output)
      }
    }

    it("finds the correct majority/minory values within a boolean array") {
      val input = List(
        "00100",
        "11110",
        "10110",
        "10111",
        "10101",
        "01111",
        "00111",
        "11100",
        "10000",
        "11001",
        "00010",
        "01010",
      )

      Day3.Main.part1(input) match
        case Some(i) => assert(i == 198)
        case None => throw AssertionError("Part 1 did not return an integer")
    }
  }
}
