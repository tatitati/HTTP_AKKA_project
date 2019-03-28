package app.infrastructure.Persistence.owner

import com.github.nscala_time.time.Imports.DateTime

case class UserPersistentModel(
  id: Option[Long] = None,
  firstname: String,
  surname: String,
  email: String,
  isEmailConfirmed: Boolean,
  datebirth: DateTime
)
