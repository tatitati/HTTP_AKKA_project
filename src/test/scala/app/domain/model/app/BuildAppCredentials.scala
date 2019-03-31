package app.domain.model.app

import test.builders.Faker

object BuildAppCredentials {

  def any(
           withClientid: String = Faker.text(),
           withClientsecret: String = Faker.text()
         ): AppCredentials = {

    AppCredentials(withClientid, withClientsecret)
  }

  def specific(): AppCredentials = {
    AppCredentials(
      clientId = "client_id",
      clientSecret = "client_secret"
    )
  }
}
