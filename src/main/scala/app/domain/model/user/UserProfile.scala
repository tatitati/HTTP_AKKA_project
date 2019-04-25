package app.domain.model.user

import com.github.nscala_time.time.Imports.DateTime

case class UserProfile(
    val email: String, // the email can be changed by the user, so is not the identifier
    val firstname: String,
    val surname: String,
    val datebirth: DateTime
)