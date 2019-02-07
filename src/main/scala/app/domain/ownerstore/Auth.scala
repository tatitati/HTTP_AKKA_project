package app.domain.ownerstore

import app.domain.{Scope, Token}
import app.domain.thirdstore.ThirdProfile

class Auth(
            private val thirdProfile: ThirdProfile,
            private val scope: Scope,
            private val token: Option[Token]
  ) {

  def name(): String = thirdProfile.name
  def homepage(): String = thirdProfile.homepage
  def clientId(): String = thirdProfile.clientid
  def description(): String = thirdProfile.description

  def canFirstname: Boolean = scope.firstname
  def canSurname: Boolean = scope.surname
  def canEmail: Boolean = scope.email
}
