package app.domain.user

import app.domain.model.IdentifiableInPersistence
import app.domain.model.user._
import com.github.nscala_time.time.Imports.DateTime

class User(
            val id: UserId,
            private var profile: UserProfile,
            val registeredDateTime: DateTime,
   ) extends IdentifiableInPersistence {

  def equals(owner: User): Boolean = id.equals(owner.id)

  def getProfile: UserProfile = profile

  def updateFirstname(firstname: String): Unit = {
    profile = profile.copy(firstname = firstname)
  }
  def updateSurname(surname: String): Unit = {
    profile = profile.copy(surname = surname)
  }
  def updateEmail(email: String): Unit = {
    profile = profile.copy(email = email, emailconfirmed = false)
  }
  def confirmEmail(): Unit = {
    profile = profile.copy(emailconfirmed = true)
  }

  def setDatebirth(datebirth: DateTime): Unit = {
    profile.copy(datebirth = datebirth)
  }
}
