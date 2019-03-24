package test.app.domain.user

import app.domain.model.user.UserProfile
import test.builders.BuildSurrogateId
import com.github.nscala_time.time.Imports.DateTime
import test.builders.Faker

object BuildUserProfile {

  def any(
           withSurrogateId: Option[Long] =  BuildSurrogateId.any(),
           withFirstname: String =  Faker.text(),
           withSurname: String = Faker.text(),
           withEmail: String = Faker.text(),
           withEmailConfirmed: Boolean = Faker.boolean(),
           withDatebirth: DateTime = Faker.date()
         ): UserProfile = {

    new UserProfile(
      firstname = withFirstname,
      surname = withSurname,
      email = withEmail,
      emailconfirmed = withEmailConfirmed,
      datebirth = withDatebirth
    )
  }

  def specific(): UserProfile = {
    new UserProfile(
      email = "email",
      emailconfirmed = true,
      firstname = "firstname",
      surname = "surname",
      datebirth = new DateTime("1900-03-10")
    )
  }
}
