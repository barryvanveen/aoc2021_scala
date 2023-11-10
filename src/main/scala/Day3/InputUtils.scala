package Day3

object InputUtils:
  def stringToIntList(in: String): List[Int] = {
    // convert to individual characters
    // then substract '0' from the char value to get correct integer values
    in.toCharArray.map(_.toInt - '0').toList
  }
  
  def inputToBitSequences(input: List[String]): BitSequences =
    BitSequences(input.map(inputToBitSequence).toVector)

  private def inputToBitSequence(input: String): BitSequence =
    BitSequence(input.toCharArray.map(_.toInt - '0').toVector)

  def booleanToInt(in: Boolean): Int = {
    if (in) 1 else 0
  }
