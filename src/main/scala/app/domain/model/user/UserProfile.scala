package app.domain.model.user

import com.github.nscala_time.time.Imports.DateTime

class UserProfile(
              var email: String,
              var firstname: String,
              var surname: String,
              var emailconfirmed: Boolean,
              var datebirth: DateTime
             ) {

  def memento: UserProfileMemento = {
    UserProfileMemento(
      firstname,
      surname,
      email,
      emailconfirmed,
      datebirth
    )
  }
}
