package app.domain.thirdstore

import scala.util.Random

class Third(var profile: ThirdProfile, var resource: Resource) {

  def refreshCredentials(): Unit = {
    profile.clientid = generateRandomString()
    profile.clientsecret = generateRandomString()
  }

  private def generateRandomString(): String = { // move this function to a trait?, an object?....
    val length = 10
    var text: String = ""

    for(_ <- 1 to length) {
      text = text + Random.nextPrintableChar
    }

    text
  }
}
