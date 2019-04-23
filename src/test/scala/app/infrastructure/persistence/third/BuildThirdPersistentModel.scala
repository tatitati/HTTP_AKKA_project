package test.app.infrastructure.persistence.third

import app.infrastructure.persistence.third.ThirdPersistentModel
import test.builders.{BuildUuid, Faker}

object BuildThirdPersistentModel {

  def any(
           withSurrogateId: Option[Long] = Faker(Some(Faker.long()), None),
           withId: String = BuildUuid.any().toString,
           withName: String = Faker.text(),
           withCallback: String = Faker.text(),
           withHomepage: String = Faker.text(),
           withDescription: String = Faker.text()
         ): ThirdPersistentModel = {
    ThirdPersistentModel(
        withSurrogateId,
        withId,
        withName,
        withCallback,
        withHomepage,
        withDescription
    )
  }

  def anyPersisted(
            withId: String = BuildUuid.any().toString,
            withName: String = Faker.text(),
            withCallback: String = Faker.text(),
            withHomepage: String = Faker.text(),
            withDescription: String = Faker.text()
         ): ThirdPersistentModel = {
    any(
      withSurrogateId = Faker(Some(Faker.int())),
      withId,
      withName,
      withCallback,
      withHomepage,
      withDescription
    )
  }

  def anyNoPersisted(
            withId: String = BuildUuid.any().toString,
            withName: String = Faker.text(),
            withCallback: String = Faker.text(),
            withHomepage: String = Faker.text(),
            withDescription: String = Faker.text()
          ): ThirdPersistentModel = {
    any(
      withSurrogateId = None,
      withId,
      withName,
      withCallback,
      withHomepage,
      withDescription
    )
  }
}
