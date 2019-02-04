package app.domain.ownerstore

import app.domain.ownerstore.auth.Auth

class AuthList(private var list: List[Auth]) {

  def count() :Int = list.size

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

  def addThird(authorization: Auth): Unit = {
    existThird(authorization.clientId()) match {
      case false => list = list ::: List(authorization)
      case true =>
    }
  }

  def find(clientId: String): Option[Auth] = {
    val result: List[Auth] = list.filter(auth => auth.clientId() == clientId)

    result.isEmpty match {
      case false => Option(result.head)
      case true => None
    }
  }
}
