package app.domain.owner

import app.domain.model.auth.AuthId
import app.domain.model.owner.{OwnerId, OwnerProfile, OwnerProfileMemento}
import com.github.nscala_time.time.Imports.DateTime

class Owner(
             val ownerId: OwnerId,
             var profile: OwnerProfile,
             private var auths: Vector[AuthId]
           ) {

  def equals(owner: Owner): Boolean = {
    ownerId.equals(owner.ownerId)
  }

  def getOwnerProfile: OwnerProfileMemento = profile.memento

  def setFirstname(firstname: String): Unit = profile.firstname = firstname
  def setSurname(surname: String): Unit = profile.surname = surname
  def setEmail(email: String): Unit = profile.email = email
  def confirmEmail(isConfirmed: Boolean): Unit = profile.emailconfirmed = isConfirmed
  def setDatebirth(datebirth: DateTime): Unit = profile.datebirth = datebirth

  def exist(authId: AuthId): Boolean = {
    auths.exists(authId.equals(_))
  }
}
