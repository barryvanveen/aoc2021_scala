package Day3

case class BitSequence(
  seq: Vector[Int]
):

  def binaryValue(): Int =
    this.seq.reverse.zipWithIndex.map((a: (Int, Int)) => (a._1 * math.pow(2, a._2)).toInt).sum

  def apply(bit: Int): Int =
    this.seq.apply(bit)

  def length(): Int =
    this.seq.length
