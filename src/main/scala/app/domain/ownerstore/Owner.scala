package app.domain.ownerstore

class Owner(var profile: OwnerProfile, val listAuth: ListAuth) {

  def countThirds(): Int = listAuth.count()

  def has(clientId: String): Boolean = listAuth.existThird(clientId)

  def revoke(clientId: String): Unit = listAuth.removeThird(clientId)

  def grant(mapThirdToPerm: Auth): Unit = listAuth.addThird(mapThirdToPerm)

  def find(clientId: String): Option[Auth] = listAuth.find(clientId)
}
