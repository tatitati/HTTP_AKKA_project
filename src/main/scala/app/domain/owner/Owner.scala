package app.domain.owner

case class Owner(val profile: OwnerProfile, val listAuth: Auths) {

  def countThirds(): Int = listAuth.count()

  def revoke(clientId: String): Owner = {
    val updatedList = listAuth.removeAuth(clientId)
    this.copy(listAuth = updatedList)
  }

  def grant(auth: Auth): Owner = {
    val updatedList = listAuth.addAuth(auth)
    this.copy(listAuth = updatedList)
  }

  def find(clientId: String): Option[Auth] = listAuth.findAuth(clientId)

  def setProfile(profile: OwnerProfile): Owner = {
    this.copy(profile = profile)
  }
}
