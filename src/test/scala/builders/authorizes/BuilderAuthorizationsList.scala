package builders.authorizes

import app.domain.ownerstore.authorizations.AuthorizationsList

object BuilderAuthorizationsList {

  def any(): AuthorizationsList = {
    new AuthorizationsList(
      List(
        BuilderAuthorization.any(),
        BuilderAuthorization.any()
      )
    )
  }

  def anyListWithClientIds(clientIds: List[String]): AuthorizationsList = {
    val newlist = clientIds.map(clientId  => BuilderAuthorization.anyAuthorizationWithClientId(clientId))

    new AuthorizationsList(newlist)
  }
}
