package builders.authorizes

import app.domain.ownerstore.Auths
import builders.BuildThirdProfile

object BuildAuths {

  def any(): Auths = {
    new Auths(
      Vector(
        BuildAuth.any(),
        BuildAuth.any()
      )
    )
  }

  def withClientIds(clientIds: List[String]): Auths = {
    val newlist = clientIds.map(clientId  =>
      BuildAuth.any(
          withThirdProfile = BuildThirdProfile.any(
            withClientid = clientId
          )
    )).to[Vector]

    new Auths(newlist)
  }
}
