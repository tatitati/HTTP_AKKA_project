package app.domain.model.app

import app.domain.model.IdentifiableInPersistence

import scala.util.Random

class App(
         private var credentials: AppCredentials,
         private var profile: AppProfile)
  extends IdentifiableInPersistence {

  def getCredentials = credentials
  def getProfile = profile

  def refreshCredentials(): Unit = {
    credentials = AppCredentials(
      clientId = makeRandomText(),
      clientSecret = makeRandomText()
    )
  }

  def updateName(name: String): Unit = {
    profile = profile.copy(name = name)
  }

  def updateDescription(description: String): Unit = {
    profile = profile.copy(description = description)
  }

  private def makeRandomText(length: Int = 10): String = {
    Random.alphanumeric take length mkString
  }
}
