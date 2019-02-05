package builders.authorizes

import app.domain.Scope
import app.domain.ownerstore.Auth
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
