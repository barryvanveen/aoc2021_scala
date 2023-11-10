package Day3

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.prop.TableDrivenPropertyChecks.*
import org.scalatest.prop.TableFor2

class InputUtilsTest extends AnyFunSpec  {
  describe("booleanToInt") {
    it("it converts false to 0") {
      assert(InputUtils.booleanToInt(false) == 0)
    }

    it("it converts true to 1") {
      assert(InputUtils.booleanToInt(true) == 1)
    }
  }

  private val stringToIntCases =
    Table(
      ("input", "output"), // First tuple defines column names
      ("00", List(0, 0)),
      ("01234", List(0, 1, 2, 3, 4)),
      ("001100", List(0, 0, 1, 1, 0, 0)),
    )

  it("it converts a string to a list of ints") {
    forAll(stringToIntCases) { (input: String, output: List[Int]) =>
      assert(InputUtils.stringToIntList(input) == output)
    }
  }
}
