package app.domain.model.app

import test.builders.Faker

object BuildAppProfile {

  def any(
         withName: String = Faker.text(),
         withDomain: String = Faker.text(),
         withDescription: String = Faker.text()
         ): AppProfile = {

    AppProfile(
      name = withName,
      domain = withDomain,
      description = withDescription
    )
  }
}
