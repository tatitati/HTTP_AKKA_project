package domain.test.model.thirdapp

import domain.model.thirdapp.ThirdappCredentials
import domain.test.builders.Faker

object BuildThirdappCredentials {

  def any(
           withClientid: String = Faker.text(),
           withClientsecret: String = Faker.text()
         ): ThirdappCredentials = {

    ThirdappCredentials(withClientid, withClientsecret)
  }

  def specific(): ThirdappCredentials = {
    ThirdappCredentials(
      clientId = "client_id",
      clientSecret = "client_secret"
    )
  }
}
