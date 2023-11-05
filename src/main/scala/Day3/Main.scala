package Day3

import input.InputFile
import input.Util.readLines

object Main extends InputFile {
  def main(args: Array[String]): Unit = {
    val input = readLines(getInputFile(args))

    val value1 = part1(input)
    println(s"Part 1: $value1")
//    val value2 = part2(input)
//    println(s"Part 2: $value2")
  }

  def part1(input: List[String]): Option[Int] = {
    val booleans = input.map(stringToIntList).transpose

    val length = booleans.last.length
    if (booleans.exists(_.length != length))
      return None

    val ones = booleans.map(_.filter(_ == 1).sum)

    val majority = math.ceil(length.toDouble / 2.0)
    val gammaRate = ones.map((a: Int) => booleanToInt(a > majority))
    val epsilonRate = gammaRate.map((a: Int) => booleanToInt(!(a == 1)))

    Some(booleanListToBinaryValue(gammaRate) * booleanListToBinaryValue(epsilonRate))
  }

  def stringToIntList(in: String): List[Int] = {
    // convert to individual characters
    // then substract '0' from the char value to get correct integer values
    in.toCharArray.map(_.toInt - '0').toList
  }

  def booleanListToBinaryValue(in: List[Int]): Int = {
    // go from right to left
    // multiply each number (0 or 1) with it's 2-power
    // sum all parts
    in.reverse.zipWithIndex.map((a: (Int, Int)) => (a._1 * math.pow(2, a._2)).toInt).sum
  }

  def booleanToInt(in: Boolean): Int = {
    if (in) 1 else 0
  }

  def flipBoolean(in : Boolean): Boolean = {
    !in
  }

//  def part2(input: List[String]): Int = {
//
//  }
}
