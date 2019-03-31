package test.app.domain.model.auth

import app.domain.model.Scope
import app.domain.model.site.SiteId
import app.domain.model.auth._
import app.domain.model.user.UserId
import test.app.domain.model.BuildScope
import test.app.domain.model.site.BuildSiteId
import test.app.domain.model.user.BuildUserId

object BuildAuth {

  def any(
           withSurrogateId: Option[Long] = None,
           withId: AuthId = BuildAuthId.any(),
           withAppId: SiteId = BuildSiteId.any(),
           withUserId: UserId = BuildUserId.any(),
           withScope: Scope = BuildScope.any(),
           withToken: AuthToken = BuildToken.any()
         ): Auth = {
    val auth = new Auth(
      authId = withId,
      siteId = withAppId,
      userId = withUserId,
      scope = withScope,
      token = withToken
    )

    if(withSurrogateId != None) {
      auth.setSurrogateId(withSurrogateId)
    }

    auth
  }

  def specific(): Auth = {
    new Auth(
      authId = BuildAuthId.specific1(),
      siteId = BuildSiteId.specific2(),
      userId = BuildUserId.specific1(),
      scope = BuildScope.onlyEmailAndFirstname(),
      token = BuildToken.specific()
    )
  }
}
