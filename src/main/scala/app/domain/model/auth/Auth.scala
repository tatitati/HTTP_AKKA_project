package app.domain.model.auth

import app.domain.model.IdentifiableInPersistence
import app.domain.model.user.UserId
import app.domain.model.third.ThirdId

class Auth(
            val authId: AuthId,
            private val thirdId: ThirdId,
            private val userId: UserId,
            private val scope: AuthScope,
            private var token: Token
  ) extends IdentifiableInPersistence {

  def equals(auth: Auth): Boolean = {
    authId.equals(auth.authId)
  }

  def canReadFirstname: Boolean = scope.firstname
  def canReadSurname: Boolean = scope.surname
  def canReadEmail: Boolean = scope.email
}
