package app.domain.model.site

import app.domain.model.IdentifiableInPersistence
import scala.util.Random

class Site(
            private var siteId: SiteId,
            private var credentials: SiteCredentials,
            private var profile: SiteProfile)
  extends IdentifiableInPersistence {

  def getCredentials = credentials
  def getProfile = profile

  def refreshCredentials(): Unit = {
    credentials = SiteCredentials(
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
