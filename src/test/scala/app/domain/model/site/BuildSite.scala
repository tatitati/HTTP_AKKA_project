package test.app.domain.model.site

import app.domain.model.site.{Site, SiteCredentials, SiteId, SiteProfile}

object BuildSite {

  def any(
           withSiteId: SiteId = BuildSiteId.any(),
           withCredentials: SiteCredentials = BuildSiteCredentials.any(),
           withProfile: SiteProfile = BuildSiteProfile.any()
         ): Site = {

    new Site(
      siteId = withSiteId,
      credentials = withCredentials,
      profile = withProfile
    )
  }


}
