package builders.authorizes

import app.domain.ownerstore.Auths
import builders.{BuildThird, BuildThirdProfile}

object BuildListAuth {

  def any(): Auths = {
    new Auths(
      Vector(
        BuildAuth.any(),
        BuildAuth.any()
      )
    )
  }

  def anyListWithClientIds(clientIds: List[String]): Auths = {
    val newlist = clientIds.map(clientId  => BuildAuth.any(
      withThird = BuildThird.any(
        withThirdProfile = BuildThirdProfile.any(
          withClientid = clientId
        )
      )
    )).to[Vector]

    new Auths(newlist)
  }
}
