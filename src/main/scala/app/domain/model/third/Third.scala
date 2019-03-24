package app.domain.third

import java.util.UUID
import app.domain.model.IdentifiableInPersistence
import scala.util.Random

case class Third(
                  val id: UUID,
                  private var profile: ThirdProfile,
                  private var credentials: Credentials)
  extends IdentifiableInPersistence {

  def getCredentials: Credentials = credentials
  def getProfileMemento: ThirdProfileMemento = profile.memento
  def equals(third: Third): Boolean = {
    this.id.equals(third.id)
  }

  def refreshCredentials(): Unit = {
    credentials = Credentials(
      clientId = makeRandomText(),
      clientSecret = makeRandomText()
    )
  }

  def updateName(withName: String): Unit = {
    profile.name = withName
  }

  def updateCallbackUrl(withCallback: String): Unit = {
    profile.callback = withCallback
  }

  def updateHomepage(withHomepage: String): Unit = {
    profile.homepage = withHomepage
  }

  def updateDescription(withDescription: String): Unit = {
    profile.description = withDescription
  }

  private def makeRandomText(length: Int = 10): String = {
    Random.alphanumeric take length mkString
  }
}
