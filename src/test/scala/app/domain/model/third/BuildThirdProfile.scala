package test.app.domain.third

import app.domain.third.ThirdProfile
import test.builders.Faker

object BuildThirdProfile {
    def any(
             withName: String = Faker.text(),
             withDescription: String = Faker.text()
           ): ThirdProfile = {

      new ThirdProfile(
          name = withName,
          description = withDescription
      )
    }

  def specific(): ThirdProfile = {
    new ThirdProfile(
      name = "whatever",
      description = "my description"
    )
  }

}
