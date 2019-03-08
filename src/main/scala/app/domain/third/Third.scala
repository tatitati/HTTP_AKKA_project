package app.domain.third

import app.domain.{Id, RandomTextGenerator}

case class Third(id: Option[Long], val profile: ThirdProfile, private var credentials: ThirdCredentials) extends Id with RandomTextGenerator {

  def getCredentials: ThirdCredentials = credentials

  def refreshCredentials(): Unit = {
    credentials = ThirdCredentials(
      clientId = makeRandomText(),
      clientSecret = makeRandomText()
    )
  }

  def updateProfile(thirdProfile: ThirdProfile): Third = {
    this.copy(profile = thirdProfile)
  }
}
