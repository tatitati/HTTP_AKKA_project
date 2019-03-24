package app.domain.third

import java.util.UUID

import app.domain.{IdentifiableInPersistence, RandomTextGenerator}

case class Third(
                  val Uuid: UUID,
                  private var profile: ThirdProfile,
                  private var credentials: ThirdCredentials)
  extends IdentifiableInPersistence with RandomTextGenerator {

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

  def equals(third: Third): Boolean = {
    this.Uuid.equals(third.Uuid)
  }
}
