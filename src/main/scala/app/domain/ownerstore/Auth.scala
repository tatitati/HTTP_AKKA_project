package app.domain.ownerstore

import app.domain.thirdstore.MementoThird

class Auth(mementoThird: MementoThird, private val scope: Scope) {

  def name(): String = mementoThird.name
  def homepage(): String = mementoThird.homepage
  def clientId(): String = mementoThird.clientId
  def description(): String = mementoThird.description

  def canAccessToFirstname(): Boolean = scope.firstname
  def canAccessToSurname(): Boolean = scope.surname
  def canAccessEmail(): Boolean = scope.email
}
