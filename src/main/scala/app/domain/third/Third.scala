package app.domain.third

import app.domain.{Id, RandomTextGenerator}

case class Third(id: Option[Long], val profile: ThirdProfile, val credentials: ThirdCredentials) extends Id with RandomTextGenerator {

  def refreshCredentials(): Third = {
    val updatedCredentials = credentials.copy(
      clientId = makeRandomText(),
      clientSecret = makeRandomText()
    )

    this.copy(credentials = updatedCredentials)
  }

  def setProfile(thirdProfile: ThirdProfile): Third = {
    this.copy(profile = thirdProfile)
  }
}
