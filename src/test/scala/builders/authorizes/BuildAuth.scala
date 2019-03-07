package test.builders.authorizes

import app.domain.{Scope, Token}
import app.domain.owner.Auth
import app.domain.third.{Third, ThirdProfile}
import builders.authorizes.BuildScope
import test.builders.{BuildThird, BuildThirdProfile, BuildToken}

object BuildAuth {

  def any(
           withThird: Third = BuildThird.any(),
           withScope: Scope = BuildScope.any,
           withToken: Option[Token] = Some(BuildToken.any())
         ): Auth = {
    new Auth(withThird, withScope, withToken)
  }
}
