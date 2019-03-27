package app.domain.third

import app.domain.model.IdentifiableInPersistence
import app.domain.model.third.ThirdId
import scala.util.Random

case class Third(
                  val id: ThirdId,
                  private var profile: ThirdProfile,
                  private var credentials: ThirdCredentials)
  extends IdentifiableInPersistence {

  def getProfile: ThirdProfile = profile
  def getCredentials: ThirdCredentials = credentials
  def equals(third: Third): Boolean = {
    this.id.equals(third.id)
  }

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

  private def makeRandomText(length: Int = 10): String = {
    Random.alphanumeric take length mkString
  }
}
