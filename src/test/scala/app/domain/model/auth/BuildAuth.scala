package test.app.domain.model.auth

import app.domain.model.auth._
import app.domain.model.user.UserId
import app.domain.model.third.ThirdId
import test.builders.BuildUuid

import scala.util.Random

object BuildAuth {

  def any(
           withId: AuthId = AuthId(BuildUuid.any()),
           withThird: ThirdId = ThirdId(BuildUuid.any()),
           withUserId: UserId = UserId(text()),
           withScope: AuthScope = BuildScope.any(),
           withToken: Token = BuildToken.any()
         ): Auth = {
    new Auth(
      id = withId,
      thirdId = withThird,
      userId = withUserId,
      scope = withScope,
      token = withToken
    )
  }

  private def text(length: Int = 10): String = {
    val value = for(i <- 1 to length) yield { Random.nextPrintableChar() }
    value.mkString
  }
}
