package app.domain.owner

import com.github.nscala_time.time.Imports.DateTime

class OwnerProfile(
               var firstname: String,
               var surname: String,
               var email: String,
               var emailconfirmed: Boolean,
               var datebirth: DateTime
             ) {

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
