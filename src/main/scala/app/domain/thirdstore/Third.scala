package app.domain.thirdstore

class Third(var profile: ThirdProfile, var resource: ResourceByToken) extends RandomTextGenerator { // the resource is not needed anymore here

  def refreshCredentials(): Unit = {
    profile.clientid = makeRandomText()
    profile.clientsecret = makeRandomText()
  }
}
