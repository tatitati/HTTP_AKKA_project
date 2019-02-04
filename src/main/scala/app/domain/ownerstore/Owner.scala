package app.domain.ownerstore

import app.domain.Profile
import app.domain.ownerstore.auth.{Auth, Scope}
import com.github.nscala_time.time.Imports._

class Owner(private var profile: Profile, val authorizationsList: AuthList) {

  def firstname: String = profile.firstname
  def setFirstname(newfirstname: String): Unit = {
    profile = profile.copy(firstname = newfirstname)
  }

  def surname: String = profile.surname
  def setSurname(newsurname: String): Unit = {
    profile = profile.copy(surname = newsurname)
  }

  def email: String = profile.email
  def setEmail(newemail: String): Unit = {
    profile = profile.copy(email = newemail)
  }

  def datebirth: DateTime = profile.datebirth
  def setDatebirth(newdatebirth: DateTime) = {
    profile = profile.copy(datebirth = newdatebirth)
  }

  def emailconfirmed: Boolean = profile.emailconfirmed

  def countThirds(): Int = authorizationsList.count()

  def has(clientId: String): Boolean = authorizationsList.existThird(clientId)

  def revoke(clientId: String): Unit = authorizationsList.removeThird(clientId)

  def grant(mapThirdToPerm: Auth): Unit = authorizationsList.addThird(mapThirdToPerm)

  def find(clientId: String): Option[Auth] = authorizationsList.find(clientId)
}
