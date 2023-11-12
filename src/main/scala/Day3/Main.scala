package Day3

import input.InputFile
import input.Util.readLines

import scala.collection.AbstractSeq

implicit class BoolOps (private val b: Boolean) extends AnyVal {
  @inline final def asInt: Int = if (b) 1 else 0
}

object Main extends InputFile {
  def main(args: Array[String]): Unit = {
    val input = readLines(getInputFile(args))

    val value1 = part1(input)
    println(s"Part 1: $value1")
    val value2 = part2(input)
    println(s"Part 2: $value2")
  }

  def part1(input: List[String]): Int = {
    val booleans = input.map(InputUtils.stringToIntList).transpose

    val length = booleans.last.length
    val ones = booleans.map(_.filter(_ == 1).sum)

    val majority = math.ceil(length.toDouble / 2.0)
    val gammaRate = ones.map((a: Int) => (a > majority).asInt)
    val epsilonRate = gammaRate.map((a: Int) => (!(a == 1)).asInt)

    booleanListToBinaryValue(gammaRate) * booleanListToBinaryValue(epsilonRate)
  }

  def booleanListToBinaryValue(in: AbstractSeq[Int]): Int = {
    // go from right to left
    // multiply each number (0 or 1) with it's 2-power
    // sum all parts
    in.reverse.zipWithIndex.map((a: (Int, Int)) => (a._1 * math.pow(2, a._2)).toInt).sum
  }

  def part2(input: List[String]): Int = {
    val wordLength = input.last.length

    var oxygenValues = BitSequences(input)
    for
      i <- 0 to wordLength
      if oxygenValues.size() > 1
    do
      oxygenValues = oxygenValues.filterOxygenValues(i)

    var co2Values = BitSequences(input)
      for
        i <- 0 to wordLength
        if co2Values.size() > 1
      do
        co2Values = co2Values.filterCo2Values(i)

    oxygenValues.apply(0).binaryValue() * co2Values.apply(0).binaryValue()
  }
}
