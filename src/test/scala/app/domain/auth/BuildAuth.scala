package test.app.domain.auth

import app.domain.auth.{Auth, AuthId, Scope, Token}
import app.domain.owner.OwnerId
import app.domain.third.ThirdId
import builders.BuildUuid
import test.builders.Faker

object BuildAuth {

  def any(
           withId: AuthId = AuthId(BuildUuid.any()),
           withThird: ThirdId = ThirdId(BuildUuid.any()),
           withOwnerId: OwnerId = OwnerId(Faker.text()),
           withScope: Scope = BuildScope.any(),
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
