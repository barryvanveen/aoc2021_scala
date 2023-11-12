package Day3

case class BitSequences(
  seq: Vector[BitSequence]
)

object BitSequences:
  def apply(input: List[String]): BitSequences =
      BitSequences(input.map(BitSequence.apply).toVector)

extension (in: BitSequences)
  private def countOnes(bit: Int): Int =
    in.seq.map((a: BitSequence) => a.apply(bit)).sum

  private def halfSize(): Double =
    in.seq.size / 2.toDouble

  def size(): Int =
    in.seq.size

  def oxygenFilter(bit: Int): Int =
    (in.countOnes(bit) >= halfSize()).asInt

  def filterOxygenValues(bit: Int): BitSequences =
    in.copy(in.seq.filter((a: BitSequence) => a.apply(bit) == oxygenFilter(bit)))

  private def co2Filter(bit: Int): Int =
    (in.countOnes(bit) < halfSize()).asInt

  def filterCo2Values(bit: Int): BitSequences =
    in.copy(in.seq.filter((a: BitSequence) => a.apply(bit) == co2Filter(bit)))

  def apply(i: Int): BitSequence =
    in.seq.apply(i)
