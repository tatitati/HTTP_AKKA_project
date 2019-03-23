package app.domain.auth

import app.domain.IdentifiableInPersistence
import app.domain.owner.OwnerId
import app.domain.third.ThirdId

class Auth(
            val authId: AuthId,
            private val thirdId: ThirdId,
            private val ownerId: OwnerId,
            private val scope: Scope,
            private var token: Token
  ) extends IdentifiableInPersistence {

  def equals(auth: Auth): Boolean = {
    this.authId.equals(auth.authId)
  }

  def canReadFirstname: Boolean = scope.firstname
  def canReadSurname: Boolean = scope.surname
  def canReadEmail: Boolean = scope.email
}
