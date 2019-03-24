package app.domain.model.auth

import app.domain.model.IdentifiableInPersistence
import app.domain.model.user.UserId
import app.domain.model.third.ThirdId

class Auth(
            val id: AuthId,
            private val thirdId: ThirdId,
            private val userId: UserId,
            private val scope: AuthScope,
            private var token: Token
  ) extends IdentifiableInPersistence {

  def equals(auth: Auth): Boolean = {
    id.equals(auth.id)
  }

  def canReadFirstname: Boolean = token.isLive match {
    case true => scope.firstname
    case _ => false
  }

  def canReadSurname: Boolean = token.isLive match {
    case true => scope.surname
    case _ => false
  }

  def canReadEmail: Boolean = token.isLive match {
    case true => scope.email
    case _ => false
  }
}
