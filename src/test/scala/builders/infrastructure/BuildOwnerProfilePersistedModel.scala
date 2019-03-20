package test.builders.infrastructure

import app.infrastructure.Persistence.owner.OwnerProfilePersistModel
import test.builders.{BuildSurrogateId, Faker}
import com.github.nscala_time.time.Imports.DateTime

object BuildOwnerProfilePersistedModel {

  def any(
           withSurrogateId: Option[Long] =  BuildSurrogateId.any(),
           withFirstname: String = Faker.text(),
           withSurname: String = Faker.text(),
           withEmail: String = Faker.text(),
           withIsEmailConfirmed: Boolean = Faker.boolean(),
           withDateBirth: DateTime = Faker.date()
         ): OwnerProfilePersistModel = {
    OwnerProfilePersistModel(
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
                  ): OwnerProfilePersistModel = {
    OwnerProfilePersistModel(
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
                    ): OwnerProfilePersistModel = {
    OwnerProfilePersistModel(
      None,
      withFirstname,
      withSurname,
      withEmail,
      withIsEmailConfirmed,
      withDateBirth
    )
  }
}
