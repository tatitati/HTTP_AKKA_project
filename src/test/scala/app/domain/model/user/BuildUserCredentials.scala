package app.domain.model.user

import test.builders.Faker

object BuildUserCredentials {
  def any(
         withEmail: String = Faker.text(),
         withHashPassword: String = Faker.text()
         ): UserCredentials = {
      UserCredentials(withEmail, withHashPassword)
  }
}
