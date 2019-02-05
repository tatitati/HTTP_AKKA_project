package app.domain.ownerstore

import app.domain.{Scope, Token}
import app.domain.thirdstore.Third

class Auth(
            private val third: Third,
            private val scope: Scope,
            val token: Option[Token]
  ) {

  def name(): String = third.profile.name
  def homepage(): String = third.profile.homepage
  def clientId(): String = third.profile.clientid
  def description(): String = third.profile.description

  def canAccessToFirstname(): Boolean = scope.firstname
  def canAccessToSurname(): Boolean = scope.surname
  def canAccessEmail(): Boolean = scope.email


}
