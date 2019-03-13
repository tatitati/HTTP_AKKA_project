package app.domain.third

import app.domain.{IdentifiableInPersistence, RandomTextGenerator}

case class Third(private var profile: ThirdProfile, private var credentials: ThirdCredentials) extends IdentifiableInPersistence with RandomTextGenerator {

  def getCredentials: ThirdCredentials = credentials
  def getProfile: ThirdProfileMemento = profile.memento

  def refreshCredentials(): Unit = {
    credentials = ThirdCredentials(
      clientId = makeRandomText(),
      clientSecret = makeRandomText()
    )
  }

  def updateName(withName: String): Unit = {
    profile.updateName(withName)
  }

  def updateCallbackUrl(withCallback: String): Unit = {
    profile.updateCallbackUrl(withCallback)
  }

  def updateHomepage(withHomepage: String): Unit = {
    profile.updateHomepage(withHomepage)
  }

  def updateDescription(withDescription: String): Unit = {
    profile.updateDescription(withDescription)
  }
}
