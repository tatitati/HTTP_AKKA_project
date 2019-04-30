package domain.test.model.thirdapp

import domain.model.thirdapp.ThirdappProfile
import domain.test.builders.Faker

object BuildThirdappProfile {

  def any(
         withName: String = Faker.text(),
         withDomain: String = Faker.text(),
         withDescription: String = Faker.text(),
         withHomepage: String = Faker.text(),
         withUrlCallback: String = Faker.text()
         ): ThirdappProfile = {

    ThirdappProfile(
      name = withName,
      domain = withDomain,
      description = withDescription,
      homepage = withHomepage,
      urlcallback =  withUrlCallback
    )
  }
}
