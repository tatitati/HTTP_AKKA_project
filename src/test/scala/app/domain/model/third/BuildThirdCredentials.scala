package app.domain.third

import test.builders.Faker

object BuildThirdCredentials {

  def any(
           withClientid: String = Faker.text(),
           withClientsecret: String = Faker.text()
         ): Credentials = {

    Credentials(withClientid, withClientsecret)
  }

  def specific(): Credentials = {
    Credentials(
      clientId = "client_id",
      clientSecret = "client_secret"
    )
  }
}
