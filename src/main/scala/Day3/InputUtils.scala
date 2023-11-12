package Day3

object InputUtils:
  def stringToIntList(in: String): List[Int] = {
    // convert to individual characters
    // then substract '0' from the char value to get correct integer values
    in.toCharArray.map(_.toInt - '0').toList
  }
