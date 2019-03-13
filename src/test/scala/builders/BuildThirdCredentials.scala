package test.builders

import app.domain.third.ThirdCredentials

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
