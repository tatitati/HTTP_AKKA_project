package app.domain.thirdstore

class Third(var profile: ThirdProfile, var resource: ResourceToken) extends RandomTextGenerator {

  def refreshCredentials(): Unit = {
    profile.clientid = generateRandomString()
    profile.clientsecret = generateRandomString()
  }
}
