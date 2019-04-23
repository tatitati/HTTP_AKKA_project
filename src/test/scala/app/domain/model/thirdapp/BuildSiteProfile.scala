package test.app.domain.model.thirdapp

import app.domain.model.thirdapp.SiteProfile
import test.builders.Faker

object BuildSiteProfile {

  def any(
         withName: String = Faker.text(),
         withDomain: String = Faker.text(),
         withDescription: String = Faker.text()
         ): SiteProfile = {

    SiteProfile(
      name = withName,
      domain = withDomain,
      description = withDescription
    )
  }
}
