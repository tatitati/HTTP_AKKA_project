package app.domain.ownerstore.authorizations

class AuthorizationsList(private var list: List[Authorization]) {

  def count() :Int = {
    list.size
  }

  def existThird(clientId: String): Boolean = {
    list.exists(
      map => map.getClientId() == clientId
    )
  }

  def removeThird(clientId: String): Unit = {
    list = list.filterNot(
      map => map.getClientId() == clientId
    )
  }

  def addThird(authorization: Authorization): Unit = {
    existThird(authorization.getClientId()) match {
      case false => list = list ::: List(authorization)
      case true =>
    }
  }
}
