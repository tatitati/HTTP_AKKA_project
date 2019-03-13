package test.builders.infrastructure

import app.infrastructure.repository.third.ThirdPersistedModel
import test.builders.Faker

object BuildThirdPersistedModel {

  def any(
           withId: Option[Long] = Faker(Some(Faker.number()), None),
           withName: String = Faker.text(),
           withCallback: String = Faker.text(),
           withHomepage: String = Faker.text(),
           withDescription: String = Faker.text(),
           withClientId: String = Faker.text(),
           withClientSecret: String = Faker.text()
         ): ThirdPersistedModel = {
    ThirdPersistedModel(
        withId,
        withName,
        withCallback,
        withHomepage,
        withDescription,
        withClientId,
        withClientSecret
    )
  }

  def anyPersisted(
           withId: Option[Long] = Faker(Some(Faker.number())),
           withName: String = Faker.text(),
           withCallback: String = Faker.text(),
           withHomepage: String = Faker.text(),
           withDescription: String = Faker.text(),
           withClientId: String = Faker.text(),
           withClientSecret: String = Faker.text()
         ): ThirdPersistedModel = {
    ThirdPersistedModel(
      withId,
      withName,
      withCallback,
      withHomepage,
      withDescription,
      withClientId,
      withClientSecret
    )
  }

  def anyNoPersisted(
                    withId: Option[Long] = None,
                    withName: String = Faker.text(),
                    withCallback: String = Faker.text(),
                    withHomepage: String = Faker.text(),
                    withDescription: String = Faker.text(),
                    withClientId: String = Faker.text(),
                    withClientSecret: String = Faker.text()
                  ): ThirdPersistedModel = {
    ThirdPersistedModel(
      withId,
      withName,
      withCallback,
      withHomepage,
      withDescription,
      withClientId,
      withClientSecret
    )
  }
}
