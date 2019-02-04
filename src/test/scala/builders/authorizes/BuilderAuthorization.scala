package builders.authorizes

import app.domain.ownerstore.authorization.{Authorization, Scope}
import app.domain.thirdstore.Third
import builders.BuilderThird

object BuilderAuthorization {

  def any(
           third: Third = BuilderThird.any(),
           scope: Scope = BuilderScope.onlySurname()
         ): Authorization = {
    new Authorization(third, scope)
  }

  def anyAuthorizationWithClientId(clientId: String): Authorization = {
    new Authorization(
      BuilderThird.anyWithClientId(clientId),
      BuilderScope.onlySurname()
    )
  }
}
