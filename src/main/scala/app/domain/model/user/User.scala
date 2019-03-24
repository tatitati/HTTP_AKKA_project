package app.domain.user

import app.domain.model.auth.AuthId
import app.domain.model.user.{UserId, UserProfile, UserProfileMemento}
import com.github.nscala_time.time.Imports.DateTime

class User(
            val id: UserId,
            var profile: UserProfile,
            private var auths: Vector[AuthId]
           ) {

  def equals(owner: User): Boolean = {
    id.equals(owner.id)
  }

  def getProfileMemento: UserProfileMemento = profile.memento

  def updateFirstname(firstname: String): Unit = profile.firstname = firstname
  def updateSurname(surname: String): Unit = profile.surname = surname
  def updateEmail(email: String): Unit = {
    profile.email = email
  }
  def confirmEmail(isConfirmed: Boolean): Unit = profile.emailconfirmed = isConfirmed
  def setDatebirth(datebirth: DateTime): Unit = profile.datebirth = datebirth

  def exist(authId: AuthId): Boolean = {
    auths.exists(authId.equals(_))
  }
}
