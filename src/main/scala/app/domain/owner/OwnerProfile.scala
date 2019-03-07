package app.domain.owner

import com.github.nscala_time.time.Imports.DateTime

case class OwnerProfile(
               val firstname: String,
               val surname: String,
               val email: String,
               val emailconfirmed: Boolean,
               val datebirth: DateTime
             ) {

  def setFirstname(firstname: String): OwnerProfile = {
    this.copy(firstname = firstname)
  }

  def setSurname(surname: String): OwnerProfile = {
    this.copy(surname = surname)
  }

  def setEmail(email: String): OwnerProfile = {
    this.copy(email = email, emailconfirmed = false)
  }

  def confirmEmail(): OwnerProfile = {
    this.copy(emailconfirmed = true)
  }

  def setDatebirth(datebirth: DateTime): OwnerProfile = {
    this.copy(datebirth = datebirth)
  }
}
