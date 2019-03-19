package test.builders.infrastructure

import app.infrastructure.Persistence.owner.OwnerProfilePersistModel
import app.infrastructure.Persistence.third.ThirdPersistModel
import test.builders.Faker
import com.github.nscala_time.time.Imports.DateTime

object BuildOwnerProfilePersistedModel {

  def any(
           withId: Option[Long] = Faker(Some(Faker.number()), None),
           withFirstname: String = Faker.text(),
           withSurname: String = Faker.text(),
           withEmail: String = Faker.text(),
           withIsEmailConfirmed: Boolean = Faker.boolean(),
           withDateBirth: DateTime = Faker.date()
         ): OwnerProfilePersistModel = {
    OwnerProfilePersistModel(
      withId,
      withFirstname,
      withSurname,
      withEmail,
      withIsEmailConfirmed,
      withDateBirth
    )
  }

  def anyPersisted(
                    withFirstname: String = Faker.text(),
                    withSurname: String = Faker.text(),
                    withEmail: String = Faker.text(),
                    withIsEmailConfirmed: Boolean = Faker.boolean(),
                    withDateBirth: DateTime = Faker.date()
                  ): OwnerProfilePersistModel = {
    OwnerProfilePersistModel(
      Faker(Some(Faker.number())),
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
