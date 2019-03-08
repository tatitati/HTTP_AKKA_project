package app.domain.owner

import com.github.nscala_time.time.Imports.DateTime

class Owner(private var profile: OwnerProfile, private var listAuth: Auths) {

  def getOwnerProfile = OwnerProfileMemento(
    profile.firstname,
    profile.surname,
    profile.email,
    profile.emailconfirmed,
    profile.datebirth
  )
  def getListAuths = AuthsMemento(listAuth.getList)

  def countThirds(): Int = listAuth.count()
  def revoke(clientId: String): Unit = listAuth.removeAuth(clientId)
  def grant(auth: Auth): Unit = listAuth.addAuth(auth)
  def find(clientId: String): Option[Auth] = listAuth.findAuth(clientId)

  def setFirstname(firstname: String): Unit = profile.setFirstname(firstname)
  def setSurname(surname: String): Unit = profile.setSurname(surname)
  def setEmail(email: String): Unit = profile.setEmail(email)
  def confirmEmail(): Unit = profile.confirmEmail()
  def setDatebirth(datebirth: DateTime): Unit = profile.setDatebirth(datebirth)
}
