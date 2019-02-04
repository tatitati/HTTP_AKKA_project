package builders

import app.domain.Profile
import com.github.nscala_time.time.Imports.{DateTime, _}

object BuilderProfile {

  private val date = DateTime.now.withYear(2030).withMonth(8).withDay(20)

  def any(
           firstname: String = "any firstname",
           surname: String = "then surname",
           email: String = "whatever@email.com",
           emailconfirmed: Boolean = true,
           datebirth: DateTime = date
         ): Profile = {

    new Profile(
      firstname = firstname,
      surname = surname,
      email = email,
      emailconfirmed = emailconfirmed,
      datebirth = datebirth
    )
  }
}
