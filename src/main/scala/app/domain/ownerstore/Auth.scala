package app.domain.ownerstore

import app.domain.{Scope, Token}
import app.domain.thirdstore.{Third, ThirdProfile}

class Auth(
            private val third: Third,
            private val scope: Scope,
            private val token: Option[Token]
  ) {

  def name(): String = third.profile.name
  def homepage(): String = third.profile.homepage
  def clientId(): String = third.credentials.clientId
  def description(): String = third.profile.description

  def canFirstname: Boolean = scope.firstname
  def canSurname: Boolean = scope.surname
  def canEmail: Boolean = scope.email
}
