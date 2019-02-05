package builders.authorizes

import app.domain.{Scope, Token}
import app.domain.ownerstore.Auth
import app.domain.thirdstore.Third
import builders.{BuildThird, BuildToken}

object BuildAuth {

  def any(
           withThird: Third = BuildThird.any(),
           withScope: Scope = BuildScope.onlySurname(),
           withToken: Option[Token] = Some(BuildToken.anyLive())
         ): Auth = {
    new Auth(withThird, withScope, withToken)
  }

  def anyAuthorizationWithClientId(clientId: String): Auth = {
    new Auth(
      BuildThird.anyWithClientId(clientId),
      BuildScope.onlySurname(),
      Some(BuildToken.anyLive())
    )
  }
}
