package app.domain.ownerstore.authorization

import app.domain.thirdstore.Third

class Authorization(val third: Third, val scope: Scope) {

  def name(): String = third.name
  def homepage(): String = third.homepage
  def clientId(): String = third.clientid

  def canAccessToFirstname(): Boolean = scope.firstname
  def canAccessToSurname(): Boolean = scope.surname
  def canAccessEmail(): Boolean = scope.email
}
