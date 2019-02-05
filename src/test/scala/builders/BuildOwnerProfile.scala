package builders

import app.domain.ownerstore.OwnerProfile
import com.github.nscala_time.time.Imports.{DateTime, _}

object BuildOwnerProfile {

  private val date = DateTime.now.withYear(2030).withMonth(8).withDay(20)

  def any(
           withFirstname: String = "any firstname",
           withSurname: String = "then surname",
           withEmail: String = "whatever@email.com",
           withEmailConfirmed: Boolean = true,
           withDatebirth: DateTime = date
         ): OwnerProfile = {

    new OwnerProfile(
      firstname = withFirstname,
      surname = withSurname,
      email = withEmail,
      emailconfirmed = withEmailConfirmed,
      datebirth = withDatebirth
    )
  }
}
