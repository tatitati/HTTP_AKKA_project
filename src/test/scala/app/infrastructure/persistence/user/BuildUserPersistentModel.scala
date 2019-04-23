package test.app.infrastructure.Persistence.user

import app.domain.model.BuildSurrogateId
import app.infrastructure.persistence.owner.UserPersistentModel
import com.github.nscala_time.time.Imports.DateTime
import test.builders.Faker

object BuildUserPersistentModel {

  def any(
           withSurrogateId: Option[Long] =  BuildSurrogateId.any(),
           withFirstname: String = Faker.text(),
           withSurname: String = Faker.text(),
           withEmail: String = Faker.text(),
           withIsEmailConfirmed: Boolean = Faker.boolean(),
           withDateBirth: DateTime = Faker.date()
         ): UserPersistentModel = {
    UserPersistentModel(
      withSurrogateId,
      withFirstname,
      withSurname,
      withEmail,
      withIsEmailConfirmed,
      withDateBirth
    )
  }

  def anyPersisted(
                    withSurrogateId: Option[Long] =  BuildSurrogateId.anyPersisted(),
                    withFirstname: String = Faker.text(),
                    withSurname: String = Faker.text(),
                    withEmail: String = Faker.text(),
                    withIsEmailConfirmed: Boolean = Faker.boolean(),
                    withDateBirth: DateTime = Faker.date()
                  ): UserPersistentModel = {
    UserPersistentModel(
      withSurrogateId,
      withFirstname,
      withSurname,
      withEmail,
      withIsEmailConfirmed,
      withDateBirth
    )
  }

  def anyNoPersisted(
                      withFirstname: String = Faker.text(),
                      withSurname: String = Faker.text(),
                      withEmail: String = Faker.text(),
                      withIsEmailConfirmed: Boolean = Faker.boolean(),
                      withDateBirth: DateTime = Faker.date()
                    ): UserPersistentModel = {
    UserPersistentModel(
      None,
      withFirstname,
      withSurname,
      withEmail,
      withIsEmailConfirmed,
      withDateBirth
    )
  }
}
