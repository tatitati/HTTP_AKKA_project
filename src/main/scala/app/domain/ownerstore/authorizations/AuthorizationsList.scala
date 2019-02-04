package app.domain.ownerstore.authorizations

class AuthorizationsList(private var list: List[Authorization]) {

  def count() :Int = {
    list.size
  }

  def existThird(clientId: String): Boolean = {
    list.exists(
      map => map.clientId() == clientId
    )
  }

  def removeThird(clientId: String): Unit = {
    list = list.filterNot(
      map => map.clientId() == clientId
    )
  }

  def addThird(authorization: Authorization): Unit = {
    existThird(authorization.clientId()) match {
      case false => list = list ::: List(authorization)
      case true =>
    }
  }

  def scope(clientId: String): Option[Scope] = {
    val result: List[Authorization] = list.filter(auth => auth.clientId() == clientId)

    result.isEmpty match {
      case false => Option(result.head.scope)
      case true => None
    }
  }
}
