package app.domain.owner

case class Auths(private val auths: Vector[Auth]) {

  def count() :Int = auths.size

  private def existThird(clientId: String): Boolean = {
    auths.exists(
      map => map.thirdClientId() == clientId
    )
  }

  def removeAuth(clientId: String): Auths = {
    val listUpdated = auths.filterNot(
      map => map.thirdClientId() == clientId
    )

    this.copy(auths = listUpdated)
  }

  def addAuth(auth: Auth): Auths = {
    val listUpdated = existThird(auth.thirdClientId()) match {
      case false => auths :+ auth
      case true => auths
    }

    this.copy(auths = listUpdated)
  }

  def findAuth(clientId: String): Option[Auth] = {
    val result: Vector[Auth] = auths.filter(auth => auth.thirdClientId() == clientId)

    result.isEmpty match {
      case false => Option(result.head)
      case true => None
    }
  }
}
