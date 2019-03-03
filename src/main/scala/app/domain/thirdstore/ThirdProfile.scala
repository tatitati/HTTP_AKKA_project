package app.domain.thirdstore

case class ThirdProfile(
              name: String,
              clientid: String,
              clientsecret: String,
              callback: String,
              homepage: String,
              description: String
) {
  def setName(withName: String): ThirdProfile = {
    this.copy(name = withName)
  }

  def clientId(withClientId: String): ThirdProfile = {
    this.copy(clientid = withClientId)
  }

  def clientSecret(withClientSecret: String): ThirdProfile = {
    this.copy(clientsecret = withClientSecret)
  }

  def callBack(withCallback: String): ThirdProfile = {
    this.copy(callback = withCallback)
  }

  def homepage(withHomepage: String): ThirdProfile = {
    this.copy(homepage = withHomepage)
  }

  def description(withDescription: String): ThirdProfile = {
    this.copy(description = withDescription)
  }
}
