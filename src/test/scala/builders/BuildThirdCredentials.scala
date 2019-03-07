package test.builders

import app.domain.thirdstore.ThirdCredentials

object BuildThirdCredentials {
  def any(): ThirdCredentials = {
    ThirdCredentials(Faker.text(), Faker.text())
  }
}
