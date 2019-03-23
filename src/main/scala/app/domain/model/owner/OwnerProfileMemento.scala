package app.domain.model.owner

import com.github.nscala_time.time.Imports.DateTime

case class OwnerProfileMemento(
  firstname: String,
  surname: String,
  email: String,
  emailconfirmed: Boolean,
  datebirth: DateTime
)
