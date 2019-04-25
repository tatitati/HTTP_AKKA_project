package app.domain.model.user

import com.github.nscala_time.time.Imports.DateTime

case class UserProfile(
    val email: String,
    val firstname: String,
    val surname: String,
    val datebirth: DateTime
)