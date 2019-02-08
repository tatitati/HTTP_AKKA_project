 package app.domain.ownerstore

class Auths(private var auths: Vector[Auth]) {

  def count() :Int = auths.size

  def existThird(clientId: String): Boolean = { // should be this private?, when a user is going to check if he has granted access to an especial third (I cannot imagine any scenario)
    auths.exists(
      map => map.clientId() == clientId
    )
  }

  def removeThird(clientId: String): Unit = {
    auths = auths.filterNot(
      map => map.clientId() == clientId
    )
  }

  def addThird(auth: Auth): Unit = {
    existThird(auth.clientId()) match {
      case false => auths = auths :+ auth
      case true =>
    }
  }

  def find(clientId: String): Option[Auth] = { 
    val result: Vector[Auth] = auths.filter(auth => auth.clientId() == clientId)

    result.isEmpty match {
      case false => Option(result.head)
      case true => None
    }
  }
}
