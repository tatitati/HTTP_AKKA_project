package test.app.domain.model.thirdapp

import app.domain.model.thirdapp.ThirdappProfile
import test.builders.Faker

object BuildThirdappProfile {

  def any(
         withName: String = Faker.text(),
         withDomain: String = Faker.text(),
         withDescription: String = Faker.text()
         ): ThirdappProfile = {

    ThirdappProfile(
      name = withName,
      domain = withDomain,
      description = withDescription
    )
  }
}
