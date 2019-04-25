package test.app.infrastructure.persistence.user

import app.domain.model.BuildSurrogateId
import app.infrastructure.persistence.owner.UserPersistentModel
import com.github.nscala_time.time.Imports.DateTime
import test.builders.{BuildDate, Faker}

object BuildUserPersistentModel {

  def any(
           withSurrogateId: Option[Long] =  BuildSurrogateId.any(),
           withFirstname: String = Faker.text(),
           withSurname: String = Faker.text(),
           withEmail: String = Faker.text(),
           withIsEmailConfirmed: Boolean = Faker.boolean(),
           withDateBirth: DateTime = BuildDate.any(),
           withRegisteredDateTime: DateTime = BuildDate.any()
         ): UserPersistentModel = {
    UserPersistentModel(
      withSurrogateId,
      withFirstname,
      withSurname,
      withEmail,
      withIsEmailConfirmed,
      withDateBirth,
      withRegisteredDateTime
    )
  }

  def anyPersisted(
                    withSurrogateId: Option[Long] =  BuildSurrogateId.anyPersisted(),
                    withFirstname: String = Faker.text(),
                    withSurname: String = Faker.text(),
                    withEmail: String = Faker.text(),
                    withIsEmailConfirmed: Boolean = Faker.boolean(),
                    withDateBirth: DateTime = BuildDate.any(),
                    withRegisteredDateTime: DateTime = BuildDate.any()
                  ): UserPersistentModel = {
    UserPersistentModel(
      withSurrogateId,
      withFirstname,
      withSurname,
      withEmail,
      withIsEmailConfirmed,
      withDateBirth,
      withRegisteredDateTime
    )
  }

  def anyNoPersisted(
                      withFirstname: String = Faker.text(),
                      withSurname: String = Faker.text(),
                      withEmail: String = Faker.text(),
                      withIsEmailConfirmed: Boolean = Faker.boolean(),
                      withDateBirth: DateTime = BuildDate.any(),
                      withRegisteredDateTime: DateTime = BuildDate.any()
                    ): UserPersistentModel = {
    UserPersistentModel(
      None,
      withFirstname,
      withSurname,
      withEmail,
      withIsEmailConfirmed,
      withDateBirth,
      withRegisteredDateTime
    )
  }
}
