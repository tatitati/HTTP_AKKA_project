package test.builders.infrastructure

import app.infrastructure.Persistence.third.ThirdPersistModel
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
         ): ThirdPersistModel = {
    ThirdPersistModel(
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
           withName: String = Faker.text(),
           withCallback: String = Faker.text(),
           withHomepage: String = Faker.text(),
           withDescription: String = Faker.text(),
           withClientId: String = Faker.text(),
           withClientSecret: String = Faker.text()
         ): ThirdPersistModel = {
    ThirdPersistModel(
      Faker(Some(Faker.number())),
      withName,
      withCallback,
      withHomepage,
      withDescription,
      withClientId,
      withClientSecret
    )
  }

  def anyNoPersisted(
                    withName: String = Faker.text(),
                    withCallback: String = Faker.text(),
                    withHomepage: String = Faker.text(),
                    withDescription: String = Faker.text(),
                    withClientId: String = Faker.text(),
                    withClientSecret: String = Faker.text()
                  ): ThirdPersistModel = {
    ThirdPersistModel(
      None,
      withName,
      withCallback,
      withHomepage,
      withDescription,
      withClientId,
      withClientSecret
    )
  }
}
