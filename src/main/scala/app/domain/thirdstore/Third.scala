package app.domain.thirdstore

import scala.util.Random

class Third(
             val name: String,
             private var clientid: String,
             private var clientsecret: String,
             val callback: String,
             val homepage: String,
             val description: String
  ) {

  def getclientid: String = clientid
  def getclientsecret: String = clientsecret

  def refreshCredentials(): Unit = {
    clientid = generateRandomString()
    clientsecret = generateRandomString()
  }

  private def generateRandomString(): String = {
    val length = 10
    var text: String = ""

    for(a <- 1 to length) {
      text = text + Random.nextPrintableChar
    }

    text
  }
}
