package app.domain.thirdstore

class Third(var profile: ThirdProfile, var resource: Resource) extends RandomTextGenerator {

  def refreshCredentials(): Unit = {
    profile.clientid = generateRandomString()
    profile.clientsecret = generateRandomString()
  }
}
