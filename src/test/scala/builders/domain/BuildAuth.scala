package builders.domain

import app.domain.owner.Auth
import app.domain.resource.{Scope, Token}
import app.domain.third.Third

object BuildAuth {

  def any(
           withThird: Third = BuildThird.any(),
           withScope: Scope = BuildScope.any(),
           withToken: Option[Token] = Some(BuildToken.any())
         ): Auth = {
    new Auth(withThird, withScope, withToken)
  }
}
