package test.builders

import app.domain.owner.OwnerProfile
import com.github.nscala_time.time.Imports.{DateTime, _}

object BuildOwnerProfile {

  def any(
           withFirstname: String = Faker.text(),
           withSurname: String = Faker.text(),
           withEmail: String = Faker.text(),
           withEmailConfirmed: Boolean = Faker.boolean(),
           withDatebirth: DateTime = Faker.date()
         ): OwnerProfile = {

    new OwnerProfile(
      firstname = withFirstname,
      surname = withSurname,
      email = withEmail,
      emailconfirmed = withEmailConfirmed,
      datebirth = withDatebirth
    )
  }

  def specific(): OwnerProfile = {
    new OwnerProfile(
      email = "email",
      emailconfirmed = true,
      firstname = "firstname",
      surname = "surname",
      datebirth = new DateTime("1900-03-10")
    )
  }
}
