package app.domain.ownerstore.auth

import app.domain.thirdstore.Third

class Auth(private val third: Third, val scope: Scope) {

  private val thirdmemento =   third.exportMemento()

  def name(): String = thirdmemento.name
  def homepage(): String = thirdmemento.homepage
  def clientId(): String = thirdmemento.clientId
  def description(): String = thirdmemento.description

  def canAccessToFirstname(): Boolean = scope.firstname
  def canAccessToSurname(): Boolean = scope.surname
  def canAccessEmail(): Boolean = scope.email
}
