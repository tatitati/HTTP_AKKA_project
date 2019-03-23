package app.infrastructure.Persistence.third

import builders.BuildUuid
import test.builders.Faker

object BuildThirdPersistedModel {

  def any(
           withId: Option[Long] = Faker(Some(Faker.long()), None),
           withUUID: String = BuildUuid.any().toString,
           withName: String = Faker.text(),
           withCallback: String = Faker.text(),
           withHomepage: String = Faker.text(),
           withDescription: String = Faker.text(),
           withClientId: String = Faker.text(),
           withClientSecret: String = Faker.text()
         ): ThirdPersistModel = {
    ThirdPersistModel(
        withId,
        withUUID,
        withName,
        withCallback,
        withHomepage,
        withDescription,
        withClientId,
        withClientSecret
    )
  }

  def anyPersisted(
           withUUID: String = BuildUuid.any().toString,
           withName: String = Faker.text(),
           withCallback: String = Faker.text(),
           withHomepage: String = Faker.text(),
           withDescription: String = Faker.text(),
           withClientId: String = Faker.text(),
           withClientSecret: String = Faker.text()
         ): ThirdPersistModel = {
    any(
      withId = Faker(Some(Faker.int())),
      withUUID,
      withName,
      withCallback,
      withHomepage,
      withDescription,
      withClientId,
      withClientSecret
    )
  }

  def anyNoPersisted(
                    withUUID: String = BuildUuid.any().toString,
                    withName: String = Faker.text(),
                    withCallback: String = Faker.text(),
                    withHomepage: String = Faker.text(),
                    withDescription: String = Faker.text(),
                    withClientId: String = Faker.text(),
                    withClientSecret: String = Faker.text()
                  ): ThirdPersistModel = {
    any(
      withId = None,
      withUUID,
      withName,
      withCallback,
      withHomepage,
      withDescription,
      withClientId,
      withClientSecret
    )
  }
}
