package app.domain.owner

import app.domain.resource.{Scope, Token}
import app.domain.third.Third

class Auth(
            private val givenToThird: Third,
            private val withScope: Scope,
            private val throughToken: Option[Token]
  ) {

  def thirdName(): String = givenToThird.profile.name
  def thirdHomepage(): String = givenToThird.profile.homepage
  def thirdClientId(): String = givenToThird.credentials.clientId
  def thirdDescription(): String = givenToThird.profile.description

  def canThirdReadFirstname: Boolean = withScope.firstname
  def canThirdReadSurname: Boolean = withScope.surname
  def canThirdReadEmail: Boolean = withScope.email
}
