package builders.authorizes

import app.domain.ownerstore.auth.{Auth, Scope}
import app.domain.thirdstore.Third
import builders.BuildThird

object BuildAuth {

  def any(
           third: Third = BuildThird.any(),
           scope: Scope = BuildScope.onlySurname()
         ): Auth = {
    new Auth(third, scope)
  }

  def anyAuthorizationWithClientId(clientId: String): Auth = {
    new Auth(
      BuildThird.anyWithClientId(clientId),
      BuildScope.onlySurname()
    )
  }
}
