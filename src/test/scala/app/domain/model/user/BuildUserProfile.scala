package test.app.domain.user

import app.domain.model.user.UserProfile
import com.github.nscala_time.time.Imports.DateTime
import test.builders.{BuildDate, Faker}

object BuildUserProfile {

  def any(
           withFirstname: String =  Faker.text(),
           withSurname: String = Faker.text(),
           withEmail: String = Faker.text(),
           withDatebirth: DateTime = BuildDate.any()
         ): UserProfile = {

    new UserProfile(
      firstname = withFirstname,
      surname = withSurname,
      email = withEmail,
      datebirth = withDatebirth
    )
  }

  def specific(): UserProfile = {
    new UserProfile(
      email = "email",
      firstname = "firstname",
      surname = "surname",
      datebirth = new DateTime("1900-03-10")
    )
  }
}
