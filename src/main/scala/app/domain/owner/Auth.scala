package app.domain.owner

import app.domain.resource.{Scope, Token}
import app.domain.third.{Third, ThirdProfile, ThirdProfileMemento}

class Auth(
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
