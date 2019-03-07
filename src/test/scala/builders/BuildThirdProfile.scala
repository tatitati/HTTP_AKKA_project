package test.builders

import app.domain.thirdstore.ThirdProfile

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
}
