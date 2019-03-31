package app.domain.model.app

import test.builders.Faker

object BuildAppProfile {

  def any(
         withDomain: String = Faker.text(),
         withDescription: String = Faker.text()
         ): AppProfile = {

    AppProfile(
      domain = withDomain,
      description = withDescription
    )
  }
}
