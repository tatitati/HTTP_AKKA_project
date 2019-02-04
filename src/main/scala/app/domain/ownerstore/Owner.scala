package app.domain.ownerstore

import app.domain.Profile
import app.domain.ownerstore.authorizations.{Authorization, AuthorizationsList, Scope}
import com.github.nscala_time.time.Imports._

class Owner(val profile: Profile, val authorizationsList: AuthorizationsList) {

  var firstname: String = profile.firstname
  var surname: String = profile.surname
  val email: String = profile.email
  var emailconfirmed: Boolean = profile.emailconfirmed
  val datebirth: DateTime = profile.datebirth

  def countThirds(): Int = {
    authorizationsList.count()
  }

  def has(clientId: String): Boolean = {
    authorizationsList.existThird(clientId)
  }

  def revoke(clientId: String): Unit = {
    authorizationsList.removeThird(clientId)
  }

  def grant(mapThirdToPerm: Authorization): Unit = {
    authorizationsList.addThird(mapThirdToPerm)
  }

  def  find(clientId: String): Option[Authorization] = {
    authorizationsList.find(clientId)
  }
}
