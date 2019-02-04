package builders.authorizes

import app.domain.ownerstore.auth.{Auth, Scope}
import app.domain.thirdstore.Third
import builders.BuilderThird

object BuilderAuth {

  def any(
           third: Third = BuilderThird.any(),
           scope: Scope = BuilderScope.onlySurname()
         ): Auth = {
    new Auth(third, scope)
  }

  def anyAuthorizationWithClientId(clientId: String): Auth = {
    new Auth(
      BuilderThird.anyWithClientId(clientId),
      BuilderScope.onlySurname()
    )
  }
}
