package app.domain.model

import scala.util.Random

trait RandomTextGenerator {
  protected def makeRandomText(length: Int = 10): String = {
    Random.alphanumeric take length mkString
  }
}
