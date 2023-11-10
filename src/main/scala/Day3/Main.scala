package Day3

import input.InputFile
import input.Util.readLines

import scala.collection.AbstractSeq

object Main extends InputFile {
  def main(args: Array[String]): Unit = {
    val input = readLines(getInputFile(args))

    val value1 = part1(input)
    println(s"Part 1: $value1")
    val value2 = part2(input)
    println(s"Part 2: $value2")
  }

  def part1(input: List[String]): Int = {
    val booleans = input.map(stringToIntList).transpose

    val length = booleans.last.length
    val ones = booleans.map(_.filter(_ == 1).sum)

    val majority = math.ceil(length.toDouble / 2.0)
    val gammaRate = ones.map((a: Int) => booleanToInt(a > majority))
    val epsilonRate = gammaRate.map((a: Int) => booleanToInt(!(a == 1)))

    booleanListToBinaryValue(gammaRate) * booleanListToBinaryValue(epsilonRate)
  }

  def stringToIntList(in: String): List[Int] = {
    // convert to individual characters
    // then substract '0' from the char value to get correct integer values
    in.toCharArray.map(_.toInt - '0').toList
  }

  def booleanListToBinaryValue(in: AbstractSeq[Int]): Int = {
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

  def stringToIntVector(in: String): Vector[Int] = {
    // convert to individual characters
    // then substract '0' from the char value to get correct integer values
    in.toCharArray.map(_.toInt - '0').toVector
  }

  def part2(input: List[String]): Int = {
    val booleans = input.map(stringToIntVector).toVector
    val wordLength = booleans.apply(0).length

    var oxygenValues = booleans;
    var co2Values = booleans;

    for i <- 0 to wordLength
      if oxygenValues.size > 1 || co2Values.size > 1
    do
      oxygenValues = filterOxygenValues(oxygenValues, i)
      co2Values = filterCo2Values(co2Values, i)

    booleanListToBinaryValue(oxygenValues.apply(0)) * booleanListToBinaryValue(co2Values.apply(0))
  }

  def onesInBit(in: Vector[Vector[Int]], bit: Int): Int = {
    // transpose to get rows, take first row and sum all the 1's
    in.transpose.slice(bit, bit+1).flatten.sum
  }

  def filterOxygenValues(in: Vector[Vector[Int]], bit: Int): Vector[Vector[Int]] = {
    if (in.size == 1)
      return in

    val majority = booleanToInt(onesInBit(in, bit).toDouble >= in.size / 2.toDouble)
    in.filter((a: Vector[Int]) => a.apply(bit) == majority)
  }

  def filterCo2Values(in: Vector[Vector[Int]], bit: Int): Vector[Vector[Int]] = {
    if (in.size == 1)
      return in

    val minority = booleanToInt(onesInBit(in, bit).toDouble < in.size / 2.toDouble)
    in.filter((a: Vector[Int]) => a.apply(bit) == minority)
  }
}
