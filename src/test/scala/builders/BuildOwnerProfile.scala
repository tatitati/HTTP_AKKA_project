package builders

import app.domain.ownerstore.OwnerProfile
import com.github.nscala_time.time.Imports.{DateTime, _}

object BuildOwnerProfile {

  def any(
           withFirstname: String = AnyFrom.text(),
           withSurname: String = AnyFrom.text(),
           withEmail: String = AnyFrom.text(),
           withEmailConfirmed: Boolean = AnyFrom.boolean(),
           withDatebirth: DateTime = AnyFrom.date()
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
