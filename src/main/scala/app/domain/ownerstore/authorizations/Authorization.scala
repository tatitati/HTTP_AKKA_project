package app.domain.ownerstore.authorizations

import app.domain.thirdstore.Third

class Authorization(val third: Third, val scope: Scope) {

  def getClientId(): String = {
    third.clientid
  }

  def canAccessToFirstname(): Boolean = {
    return scope.firstname
  }

  def canAccessToSurname(): Boolean = {
    return scope.surname
  }

  def canAccessEmail(): Boolean = {
    return scope.email
  }
}
