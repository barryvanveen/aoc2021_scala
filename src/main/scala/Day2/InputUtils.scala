package Day2

object InputUtils:
  def inputToStep(input: String): Step =
    Step(
      Direction.valueOf(input.substring(0, input.indexOf(' '))),
      input.substring(input.indexOf(' ')+1).toInt
    )
