package app.domain

import scala.util.Random

trait RandomTextGenerator {
  protected def makeRandomText(length: Int = 10): String = {
    Random.alphanumeric take length mkString
  }
}
