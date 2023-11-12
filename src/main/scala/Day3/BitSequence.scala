package Day3

case class BitSequence(
  seq: Vector[Int]
):
  def binaryValue(): Int =
    seq.reverse.zipWithIndex.map((a: (Int, Int)) => (a._1 * math.pow(2, a._2)).toInt).sum

  def apply(bit: Int): Int =
    seq.apply(bit)

  def length(): Int =
    seq.length

object BitSequence:
  def apply(input: String) =
    new BitSequence(input.toCharArray.map(_.toInt - '0').toVector)
