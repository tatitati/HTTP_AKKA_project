package test.builders

import app.domain.thirdstore.ThirdProfile

object BuildThirdProfile {
    def any(
             withName: String = Faker.text(),
             withClientid: String = Faker.text(),
             withClientsecret: String = Faker.text(),
             withCallback: String = Faker.text(),
             withHomepage: String = Faker.text(),
             withDescription: String = Faker.text()
           ): ThirdProfile = {

      new ThirdProfile(
          name = withName,
          clientid = withClientid,
          clientsecret = withClientsecret,
          callback = withCallback,
          homepage = withHomepage,
          description = withDescription
      )
    }
}
