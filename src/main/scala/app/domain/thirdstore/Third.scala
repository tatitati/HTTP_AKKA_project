package app.domain.thirdstore

import scala.util.Random

class Third(var profile: ThirdProfile) {

  def refreshCredentials(): Unit = {
    profile.clientid = generateRandomString()
    profile.clientsecret = generateRandomString()
  }

  private def generateRandomString(): String = {
    val length = 10
    var text: String = ""

    for(_ <- 1 to length) {
      text = text + Random.nextPrintableChar
    }

    text
  }
}
