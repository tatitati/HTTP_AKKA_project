package app.domain.thirdstore

import scala.util.Random

trait RandomTextGenerator {
  protected def generateRandomString(length: Int = 10): String = { // move this function to a trait?, an object?....
    var text: String = ""

    for(_ <- 1 to length) {
      text = text + Random.nextPrintableChar
    }

    text
  }
}
