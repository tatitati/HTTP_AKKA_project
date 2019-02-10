package app.domain.thirdstore

import scala.util.Random

trait RandomTextGenerator {
  protected def generateRandomString(): String = { // move this function to a trait?, an object?....
    val length = 10
    var text: String = ""

    for(_ <- 1 to length) {
      text = text + Random.nextPrintableChar
    }

    text
  }
}
