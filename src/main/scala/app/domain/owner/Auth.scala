package app.domain.owner

import java.util.UUID

import app.domain.resource.{Scope, Token}
import app.domain.third.{Third, ThirdProfileMemento}

class Auth(
            val uuid: UUID,
            private val givenToThird: Third,
            private val withScope: Scope,
            private val throughToken: Option[Token]
  ) {

  def getThirdProfile: ThirdProfileMemento = givenToThird.getProfile
  def thirdClientId(): String = givenToThird.getCredentials.clientId

  def canThirdReadFirstname: Boolean = withScope.firstname
  def canThirdReadSurname: Boolean = withScope.surname
  def canThirdReadEmail: Boolean = withScope.email
}
