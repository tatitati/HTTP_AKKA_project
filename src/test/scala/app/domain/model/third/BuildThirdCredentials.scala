package test.app.domain.third

import app.domain.third.ThirdCredentials
import test.builders.Faker

object BuildThirdCredentials {

  def any(
           withClientid: String = Faker.text(),
           withClientsecret: String = Faker.text()
         ): ThirdCredentials = {

    ThirdCredentials(withClientid, withClientsecret)
  }

  def specific(): ThirdCredentials = {
    ThirdCredentials(
      clientId = "client_id",
      clientSecret = "client_secret"
    )
  }
}
