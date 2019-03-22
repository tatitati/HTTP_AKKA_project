package app.domain.owner

import builders.BuildSurrogateId
import com.github.nscala_time.time.Imports.DateTime
import test.builders.Faker

object BuildOwnerProfile {

  def any(
           withSurrogateId: Option[Long] =  BuildSurrogateId.any(),
           withFirstname: String = Faker.text(),
           withSurname: String = Faker.text(),
           withEmail: String = Faker.text(),
           withEmailConfirmed: Boolean = Faker.boolean(),
           withDatebirth: DateTime = Faker.date()
         ): OwnerProfile = {

    val ownerProfile  = new OwnerProfile(
      firstname = withFirstname,
      surname = withSurname,
      email = withEmail,
      emailconfirmed = withEmailConfirmed,
      datebirth = withDatebirth
    )

    if (withSurrogateId != None) {
      ownerProfile.setSurrogateId(withSurrogateId)
    }


    ownerProfile
  }

  def specific(): OwnerProfile = {
    val ownerProfile = new OwnerProfile(
      email = "email",
      emailconfirmed = true,
      firstname = "firstname",
      surname = "surname",
      datebirth = new DateTime("1900-03-10")
    )

    ownerProfile.setSurrogateId(Some(34))

    ownerProfile
  }
}
