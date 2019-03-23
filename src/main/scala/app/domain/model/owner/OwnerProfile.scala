package app.domain.model.owner

import com.github.nscala_time.time.Imports.DateTime

class OwnerProfile (
              var email: String,
              var firstname: String,
              var surname: String,
              var emailconfirmed: Boolean,
              var datebirth: DateTime
             ) {

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
