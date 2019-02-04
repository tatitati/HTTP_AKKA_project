package builders.authorizes

import app.domain.ownerstore.AuthList

object BuilderAuthList {

  def any(): AuthList = {
    new AuthList(
      List(
        BuilderAuth.any(),
        BuilderAuth.any()
      )
    )
  }

  def anyListWithClientIds(clientIds: List[String]): AuthList = {
    val newlist = clientIds.map(clientId  => BuilderAuth.anyAuthorizationWithClientId(clientId))

    new AuthList(newlist)
  }
}
