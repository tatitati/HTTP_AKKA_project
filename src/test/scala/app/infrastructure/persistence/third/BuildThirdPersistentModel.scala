package test.app.infrastructure.persistence.third

import app.infrastructure.persistence.third.ThirdPersistentModel
import test.builders.{BuildUuid, Faker}

object BuildThirdPersistentModel {

  def any(
           withId: Option[Long] = Faker(Some(Faker.long()), None),
           withUUID: String = BuildUuid.any().toString,
           withName: String = Faker.text(),
           withCallback: String = Faker.text(),
           withHomepage: String = Faker.text(),
           withDescription: String = Faker.text()
         ): ThirdPersistentModel = {
    ThirdPersistentModel(
        withId,
        withUUID,
        withName,
        withCallback,
        withHomepage,
        withDescription
    )
  }

  def anyPersisted(
           withUUID: String = BuildUuid.any().toString,
           withName: String = Faker.text(),
           withCallback: String = Faker.text(),
           withHomepage: String = Faker.text(),
           withDescription: String = Faker.text()
         ): ThirdPersistentModel = {
    any(
      withId = Faker(Some(Faker.int())),
      withUUID,
      withName,
      withCallback,
      withHomepage,
      withDescription
    )
  }

  def anyNoPersisted(
                    withUUID: String = BuildUuid.any().toString,
                    withName: String = Faker.text(),
                    withCallback: String = Faker.text(),
                    withHomepage: String = Faker.text(),
                    withDescription: String = Faker.text()
                  ): ThirdPersistentModel = {
    any(
      withId = None,
      withUUID,
      withName,
      withCallback,
      withHomepage,
      withDescription
    )
  }
}
