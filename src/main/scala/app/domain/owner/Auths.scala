package app.domain.owner

case class Auths(private var auths: Vector[Auth]) {

  def count() :Int = auths.size
  def getList: Vector[Auth] = auths
  def memento: AuthsMemento = AuthsMemento(auths)

  private def existThird(clientId: String): Boolean = {
    auths.exists(
      map => map.thirdClientId() == clientId
    )
  }

  def removeAuth(clientId: String): Unit = {
    auths = auths.filterNot(
      map => map.thirdClientId() == clientId
    )
  }

  def addAuth(auth: Auth): Unit = {
    auths = existThird(auth.thirdClientId()) match {
      case false => auths :+ auth
      case true => auths
    }
  }

  def findAuth(clientId: String): Option[Auth] = {
    val result: Vector[Auth] = auths.filter(auth => auth.thirdClientId() == clientId)

    result.isEmpty match {
      case false => Option(result.head)
      case true => None
    }
  }
}
