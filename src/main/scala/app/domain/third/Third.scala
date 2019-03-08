package app.domain.third

import app.domain.{Id, RandomTextGenerator}

case class Third(id: Option[Long], private var profile: ThirdProfile, private var credentials: ThirdCredentials) extends Id with RandomTextGenerator {

  def getCredentials: ThirdCredentials = credentials
  def getProfile: ThirdProfile = profile

  def refreshCredentials(): Unit = {
    credentials = ThirdCredentials(
      clientId = makeRandomText(),
      clientSecret = makeRandomText()
    )
  }

  def updateName(withName: String): Unit = {
    profile = profile.copy(name = withName)
  }

  def updateCallbackUrl(withCallback: String): Unit = {
    profile = profile.copy(callback = withCallback)
  }

  def updateHomepage(withHomepage: String): Unit = {
    profile = profile.copy(homepage = withHomepage)
  }

  def updateDescription(withDescription: String): Unit = {
    profile = profile.copy(description = withDescription)
  }
}
