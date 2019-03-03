 package app.domain.ownerstore

case class Auths(private val auths: Vector[Auth]) {

  def count() :Int = auths.size

  private def existThird(clientId: String): Boolean = {
    auths.exists(
      map => map.clientId() == clientId
    )
  }

  def removeThird(clientId: String): Auths = {
    val listUpdated = auths.filterNot(
      map => map.clientId() == clientId
    )

    this.copy(auths = listUpdated)
  }

  def addThird(auth: Auth): Auths = {
    val listUpdated = existThird(auth.clientId()) match {
      case false => auths :+ auth
      case true => auths
    }

    this.copy(auths = listUpdated)
  }

  def find(clientId: String): Option[Auth] = { 
    val result: Vector[Auth] = auths.filter(auth => auth.clientId() == clientId)

    result.isEmpty match {
      case false => Option(result.head)
      case true => None
    }
  }
}
