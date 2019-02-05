package app.domain.thirdstore

import scala.util.Random

class Third(
             private var name: String,
             private var clientid: String,
             private var clientsecret: String,
             private var callback: String,
             private var homepage: String,
             private var description: String
  ) {

  def refreshCredentials(): Unit = {
    clientid = generateRandomString()
    clientsecret = generateRandomString()
  }

  def exportMemento(): MementoThird = {
    MementoThird(name, homepage, clientid, description)
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
