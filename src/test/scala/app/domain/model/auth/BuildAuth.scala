package test.app.domain.model.auth

import app.domain.model.auth._
import app.domain.model.owner.OwnerId
import app.domain.model.third.ThirdId
import builders.BuildUuid

object BuildAuth {

  def any(
           withId: AuthId = AuthId(BuildUuid.any()),
           withThird: ThirdId = ThirdId(BuildUuid.any()),
           withOwnerId: OwnerId = OwnerId(BuildUuid.any()),
           withScope: AuthScope = BuildScope.any(),
           withToken: Token = BuildToken.any()
         ): Auth = {
    new Auth(
      authId = withId,
      thirdId = withThird,
      ownerId = withOwnerId,
      scope = withScope,
      token = withToken
    )
  }
}
