package app.domain.model.user

import com.github.nscala_time.time.Imports.DateTime

case class UserProfileMemento(
  firstname: String,
  surname: String,
  email: String,
  emailconfirmed: Boolean,
  datebirth: DateTime
)
