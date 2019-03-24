package test.app.domain.model.auth

import app.domain.model.auth._
import app.domain.model.user.UserId
import app.domain.model.third.ThirdId
import builders.BuildUuid

object BuildAuth {

  def any(
           withId: AuthId = AuthId(BuildUuid.any()),
           withThird: ThirdId = ThirdId(BuildUuid.any()),
           withUserId: UserId = UserId(BuildUuid.any()),
           withScope: AuthScope = BuildScope.any(),
           withToken: Token = BuildToken.any()
         ): Auth = {
    new Auth(
      authId = withId,
      thirdId = withThird,
      userId = withUserId,
      scope = withScope,
      token = withToken
    )
  }
}
