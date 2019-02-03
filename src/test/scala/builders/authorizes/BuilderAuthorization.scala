package builders.authorizes

import app.domain.ownerstore.authorizations.Authorization
import builders.BuilderThird

object BuilderAuthorization {

  def any(): Authorization = {
    new Authorization(
      BuilderThird.any(),
      BuilderScope.onlySurname()
    )
  }

  def anyAuthorizationWithClientId(clientId: String): Authorization = {
    new Authorization(
      BuilderThird.anyWithClientId(clientId),
      BuilderScope.onlySurname()
    )
  }
}
