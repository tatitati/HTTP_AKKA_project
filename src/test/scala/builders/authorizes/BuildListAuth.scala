package builders.authorizes

import app.domain.ownerstore.ListAuth
import builders.{BuildThird, BuildThirdProfile}

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
    val newlist = clientIds.map(clientId  => BuildAuth.any(
      withThird = BuildThird.any(
        withThirdProfile = BuildThirdProfile.any(
          withClientid = clientId
        )
      )
    ))

    new ListAuth(newlist)
  }
}
