package builders.authorizes

import app.domain.ownerstore.ListAuth

object BuildListAuth {

  def any(): ListAuth = {
    new ListAuth(
      List(
        BuildAuth.any(),
        BuildAuth.any()
      )
    )
  }

  def anyListWithClientIds(clientIds: List[String]): ListAuth = {
    val newlist = clientIds.map(clientId  => BuildAuth.anyAuthorizationWithClientId(clientId))

    new ListAuth(newlist)
  }
}
