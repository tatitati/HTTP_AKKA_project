package domain.test.model.user

import domain.model.user.UserCredentials
import domain.test.builders.Faker

object BuildUserCredentials {
  def any(
         withEmail: String = Faker.text(),
         withHashPassword: String = Faker.text()
         ): UserCredentials = {
      UserCredentials(withEmail, withHashPassword)
  }
}
