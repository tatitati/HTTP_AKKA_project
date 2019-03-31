package test.app.domain.model.auth

import app.domain.model.Scope
import app.domain.model.app.{AppId, BuildAppId}
import app.domain.model.auth._
import app.domain.model.user.UserId
import test.app.domain.model.BuildScope
import test.app.domain.model.user.BuildUserId

object BuildAuth {

  def any(
           withSurrogateId: Option[Long] = None,
           withId: AuthId = BuildAuthId.any(),
           withAppId: AppId = BuildAppId.any(),
           withUserId: UserId = BuildUserId.any(),
           withScope: Scope = BuildScope.any(),
           withToken: AuthToken = BuildToken.any()
         ): Auth = {
    val auth = new Auth(
      authId = withId,
      appId = withAppId,
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
      appId = BuildAppId.specific2(),
      userId = BuildUserId.specific1(),
      scope = BuildScope.onlyEmailAndFirstname(),
      token = BuildToken.specific()
    )
  }
}
