package builders.infrastructure

import app.infrastructure.Persistence.resource.ScopePersistedModel
import test.builders.Faker

object BuildScopePersistedModel {
  def any(
           withId: Option[Long] = Faker(Some(Faker.int()), None),
           withFirstname: Boolean = Faker.boolean,
           withSurname: Boolean = Faker.boolean,
           withEmail: Boolean = Faker.boolean
     ): ScopePersistedModel = {
    ScopePersistedModel(
      id = withId,
      firstname = withFirstname,
      surname = withSurname,
      email = withEmail
    )
  }

  def anyWithOnlyEmail(withId: Option[Long] = Faker(Some(Faker.int()), None)): ScopePersistedModel = {
    any(
      withId = withId,
      withFirstname = false,
      withSurname = false,
      withEmail = true
    )
  }
}
