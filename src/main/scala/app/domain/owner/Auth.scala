package app.domain.owner

import app.domain.resource.{Scope, Token}
import app.domain.third.Third

class Auth(
            private val givenToThird: Third,
            private val withScope: Scope,
            private val throughToken: Option[Token]
  ) {

  def thirdName(): String = givenToThird.getProfile.name
  def thirdHomepage(): String = givenToThird.getProfile.homepage
  def thirdClientId(): String = givenToThird.getCredentials.clientId
  def thirdDescription(): String = givenToThird.getProfile.description

  def canThirdReadFirstname: Boolean = withScope.firstname
  def canThirdReadSurname: Boolean = withScope.surname
  def canThirdReadEmail: Boolean = withScope.email
}
