package app.domain.ownerstore

case class Owner(val profile: OwnerProfile, val listAuth: Auths) {

  def countThirds(): Int = listAuth.count()

  def revoke(clientId: String): Unit = listAuth.removeThird(clientId) // add FP behaviour

  def grant(auth: Auth): Unit = listAuth.addThird(auth) // add FP behaviour

  def find(clientId: String): Option[Auth] = listAuth.find(clientId)

  def setProfile(profile: OwnerProfile): Owner = {
    this.copy(profile = profile)
  }
}
