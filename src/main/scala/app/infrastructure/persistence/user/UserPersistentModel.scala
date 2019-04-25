package app.infrastructure.persistence.owner

import com.github.nscala_time.time.Imports.DateTime

case class UserPersistentModel(
  id: Option[Long] = None,
  firstname: String,
  surname: String,
  email: String,
  datebirth: DateTime,
  registeredDateTime: DateTime,
  isEmailConfirmed: Boolean
)
