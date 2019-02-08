package app.domain.ownerstore

class Owner(var profile: OwnerProfile, val listAuth: Auths) { // the user can modify the OwnerProfile. And every modification creates a new OwnerProfile

  def countThirds(): Int = listAuth.count()

  def exists(clientId: String): Boolean = listAuth.existThird(clientId)

  def revoke(clientId: String): Unit = listAuth.removeThird(clientId)

  def grant(auth: Auth): Unit = listAuth.addThird(auth)

  def find(clientId: String): Option[Auth] = listAuth.find(clientId)
}
