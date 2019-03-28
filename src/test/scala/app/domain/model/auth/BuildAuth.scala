package test.app.domain.model.auth

import app.domain.model.Scope
import app.domain.model.auth._
import app.domain.model.user.UserId
import app.domain.model.third.ThirdId
import test.app.domain.model.BuildScope
import test.app.domain.model.third.BuildThirdId
import test.app.domain.model.user.BuildUserId
import test.builders.{BuildUuid, Faker}

object BuildAuth {

  def any(
           withSurrogateId: Option[Long] = None,
           withId: AuthId = AuthId(BuildUuid.any()),
           withThird: ThirdId = ThirdId(BuildUuid.any()),
           withUserId: UserId = UserId(Faker.text()),
           withScope: Scope = BuildScope.any(),
           withToken: AuthToken = BuildToken.any()
         ): Auth = {
    val auth = new Auth(
      id = withId,
      thirdId = withThird,
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
      id = BuildAuthId.specific1(),
      thirdId = BuildThirdId.specific2(),
      userId = BuildUserId.specific1(),
      scope = BuildScope.onlyEmailAndFirstname(),
      token = BuildToken.specific()
    )
  }
}
