package app.domain.thirdstore

import app.domain.RandomTextGenerator

case class Third(val profile: ThirdProfile) extends RandomTextGenerator {

  def refreshCredentials(): Third = {
    val updatedProfile = profile.copy(
      clientid = makeRandomText(),
      clientsecret = makeRandomText()
    )

    this.copy(profile = updatedProfile)
  }

  def setProfile(thirdProfile: ThirdProfile): Third = {
    this.copy(profile = thirdProfile)
  }
}
