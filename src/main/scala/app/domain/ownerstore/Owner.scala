package app.domain.ownerstore

case class Owner(var profile: OwnerProfile, val listAuth: Auths) { // the user can modify the OwnerProfile. And every modification creates a new OwnerProfile

  def countThirds(): Int = listAuth.count()

  def revoke(clientId: String): Unit = listAuth.removeThird(clientId)

  def grant(auth: Auth): Unit = listAuth.addThird(auth)

  def find(clientId: String): Option[Auth] = listAuth.find(clientId)

  def setProfile(profile: OwnerProfile): Owner = {
    this.copy(profile = profile)
  }
}
