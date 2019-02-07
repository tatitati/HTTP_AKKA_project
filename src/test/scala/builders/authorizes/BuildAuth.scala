package builders.authorizes

import app.domain.{Scope, Token}
import app.domain.ownerstore.Auth
import app.domain.thirdstore.ThirdProfile
import builders.{BuildThirdProfile, BuildToken}

object BuildAuth {

  def any(
           withThirdProfile: ThirdProfile = BuildThirdProfile.any(),
           withScope: Scope = BuildScope.any,
           withToken: Option[Token] = Some(BuildToken.any())
         ): Auth = {
    new Auth(withThirdProfile, withScope, withToken)
  }
}
