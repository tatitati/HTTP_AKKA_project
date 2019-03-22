package app.domain.auth

import app.domain.owner.OwnerEmail
import app.domain.third.ThirdUUID

class Auth(
            val uuid: AuthUUID,
            private val thirdUUID: ThirdUUID,
            private val ownerEmail: OwnerEmail,
            private val scope: Scope,
            private var token: Option[Token],
            private var code: Option[Code]
  ) {

  def canReadFirstname: Boolean = scope.firstname
  def canReadSurname: Boolean = scope.surname
  def canReadEmail: Boolean = scope.email
}
