package app.domain.owner

import app.domain.IdentifiableInPersistence
import com.github.nscala_time.time.Imports.DateTime

class OwnerProfile (
              private var email: String,
              private var firstname: String,
              private var surname: String,
              private var emailconfirmed: Boolean,
              private var datebirth: DateTime
             ) extends IdentifiableInPersistence {

  def setFirstname(newfirstname: String): Unit = {
    firstname = newfirstname
  }

  def setSurname(newsurname: String): Unit = {
    surname = newsurname
  }

  def setEmail(newemail: String): Unit = {
    email = newemail
    emailconfirmed = false
  }

  def confirmEmail(): Unit = {
    emailconfirmed = true
  }

  def setDatebirth(newdatebirth: DateTime): Unit = {
    datebirth = newdatebirth
  }

  def equals(ownerProfile: OwnerProfile): Boolean = {
    email == ownerProfile.memento.email
  }

  def memento: OwnerProfileMemento = {
    OwnerProfileMemento(
      firstname,
      surname,
      email,
      emailconfirmed,
      datebirth
    )
  }
}
