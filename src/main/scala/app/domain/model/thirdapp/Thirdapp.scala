package app.domain.model.thirdapp

import app.domain.model.IdentifiableInPersistence
import app.domain.model.third.ThirdId
import scala.util.Random

class Thirdapp(
                private var siteId: ThirdappId,
                private var thirdId: ThirdId,
                private var credentials: ThirdappCredentials,
                private var profile: ThirdappProfile)
  extends IdentifiableInPersistence {

  def getCredentials = credentials
  def getProfile = profile

  def refreshCredentials(): Unit = {
    credentials = ThirdappCredentials(
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
