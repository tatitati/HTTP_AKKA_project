package app.infrastructure.persistence.thirdapp

import test.app.domain.model.third.BuildThirdId
import test.builders.{BuildUuid, Faker}

object BuildThirdappPersistentModel {

  def any(
           withSurrogateId: Option[Long] = Faker(Some(Faker.long()), None),
           withId: String = BuildUuid.any().toString,
           withThirdId: String = BuildThirdId.any().toString,
           withClientId: String = Faker.text(),
           withClientSecret: String = Faker.text(),
           withName: String = Faker.text(),
           withDomain: String = Faker.text(),
           withDescription: String = Faker.text(),
         ): ThirdappPersistentModel = {
    ThirdappPersistentModel(
      withSurrogateId,
      withId,
      withThirdId,
      withClientId,
      withClientSecret,
      withName,
      withDomain,
      withDescription
    )
  }

  def anyPersisted(
                    withId: String = BuildUuid.any().toString,
                    withThirdId: String = BuildThirdId.any().toString,
                    withClientId: String = Faker.text(),
                    withClientSecret: String = Faker.text(),
                    withName: String = Faker.text(),
                    withDomain: String = Faker.text(),
                    withDescription: String = Faker.text(),
                  ): ThirdappPersistentModel = {
    ThirdappPersistentModel(
      Some(Faker.long()),
      withId,
      withThirdId,
      withClientId,
      withClientSecret,
      withName,
      withDomain,
      withDescription
    )
  }
//
//  def anyNoPersisted(
//                      withUUID: String = BuildUuid.any().toString,
//                      withName: String = Faker.text(),
//                      withCallback: String = Faker.text(),
//                      withHomepage: String = Faker.text(),
//                      withDescription: String = Faker.text()
//                    ): ThirdappPersistentModel = {
//    any(
//      withId = None,
//      withUUID,
//      withName,
//      withCallback,
//      withHomepage,
//      withDescription
//    )
//  }
}

