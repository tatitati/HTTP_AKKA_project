package builders.authorizes

import app.domain.Scope
import app.domain.ownerstore.Auth
import app.domain.thirdstore.Third
import builders.BuildThird

object BuildAuth {

  def any(
           withThird: Third = BuildThird.any(),
           withScope: Scope = BuildScope.onlySurname()
         ): Auth = {
    new Auth(withThird, withScope)
  }

  def anyAuthorizationWithClientId(clientId: String): Auth = {
    new Auth(
      BuildThird.anyWithClientId(clientId),
      BuildScope.onlySurname()
    )
  }
}
