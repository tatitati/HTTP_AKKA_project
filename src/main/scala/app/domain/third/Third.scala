package app.domain.third

import app.domain.RandomTextGenerator

case class Third(val profile: ThirdProfile, val credentials: ThirdCredentials) extends RandomTextGenerator {

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
