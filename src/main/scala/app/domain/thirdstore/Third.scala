package app.domain.thirdstore

import app.domain.RandomTextGenerator

class Third(var profile: ThirdProfile) extends RandomTextGenerator { // the resource is not needed anymore here

  def refreshCredentials(): Unit = {
    profile.clientid = makeRandomText()
    profile.clientsecret = makeRandomText()
  }
}
