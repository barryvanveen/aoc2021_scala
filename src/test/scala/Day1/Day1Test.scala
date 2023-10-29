package Day1

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.prop.TableDrivenPropertyChecks._

class Day1Test extends AnyFunSpec  {
  describe("Part 1") {
    val cases =
      Table(
        ("input", "output"), // First tuple defines column names
        (List(), 0),
        (List(1), 0),
        (List(1, 1), 0),
        (List(1, 0), 0),
        (List(1, 2), 1),
        (List(1, 3), 1),
        (List(1, 3, 2), 1),
        (List(1, 3, 3), 1),
        (List(1, 3, 4), 2),
        (List(1, 3, 4, 5), 3),
      )

    it("counts increases of different lists") {
      forAll(cases) { (input: List[Int], output: Int) =>
        val increases = Day1.Main.part1(input)

        assert(increases == output)
      }
    }
  }

  describe("Part 2") {
    val cases =
      Table(
        ("input", "output"), // First tuple defines column names
        // too few items
        (List(), 0),
        (List(1), 0),
        (List(1, 1), 0),
        (List(1, 0), 0),
        (List(1, 2), 0),
        (List(1, 2, 3), 0),
        // 2 triplets but not increasing
        (List(1, 1, 1, 1), 0),
        (List(1, 2, 3, 1), 0),
        // 2 triplets increasing
        (List(1, 2, 3, 3), 1),
        (List(1, 2, 3, 5), 1),
        // 3 triples
        (List(1, 1, 1, 1, 1), 0),
        (List(1, 1, 1, 1, 2), 1),
        (List(1, 1, 1, 2, 3), 2),
      )

    it("counts increases of different lists") {
      forAll(cases) { (input: List[Int], output: Int) =>
        val increases = Day1.Main.part2(input)

        assert(increases == output)
      }
    }
  }
}