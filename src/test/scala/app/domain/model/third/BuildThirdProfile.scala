package test.app.domain.third

import app.domain.third.ThirdProfile
import test.builders.Faker

object BuildThirdProfile {
    def any(
             withName: String = Faker.text(),
             withCallback: String = Faker.text(),
             withHomepage: String = Faker.text(),
             withDescription: String = Faker.text()
           ): ThirdProfile = {

      new ThirdProfile(
          name = withName,
          callback = withCallback,
          homepage = withHomepage,
          description = withDescription
      )
    }

  def specific(): ThirdProfile = {
    new ThirdProfile(
      name = "whatever",
      callback = "callback",
      homepage = "homepage",
      description = "my description"
    )
  }

}
