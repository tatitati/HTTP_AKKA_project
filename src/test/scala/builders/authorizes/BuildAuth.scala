package builders.authorizes

import app.domain.ownerstore.{Auth, Scope}
import app.domain.thirdstore.Third
import builders.BuildThird

object BuildAuth {

  def any(
           third: Third = BuildThird.any(),
           scope: Scope = BuildScope.onlySurname()
         ): Auth = {
    new Auth(third.exportMemento(), scope)
  }

  def anyAuthorizationWithClientId(clientId: String): Auth = {
    new Auth(
      BuildThird.anyWithClientId(clientId).exportMemento(),
      BuildScope.onlySurname()
    )
  }
}
