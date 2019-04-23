package test.app.domain.model.site

import app.domain.model.site.{Site, SiteCredentials, SiteId, SiteProfile}
import app.domain.model.third.ThirdId
import test.app.domain.model.third.BuildThirdId

object BuildSite {

  def any(
           withSiteId: SiteId = BuildSiteId.any(),
           withThirdId: ThirdId = BuildThirdId.any(),
           withCredentials: SiteCredentials = BuildSiteCredentials.any(),
           withProfile: SiteProfile = BuildSiteProfile.any()
         ): Site = {

    new Site(
      siteId = withSiteId,
      thirdId = withThirdId,
      credentials = withCredentials,
      profile = withProfile
    )
  }
}
