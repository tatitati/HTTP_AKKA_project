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

  def withClientIds(clientIds: String*): Auths = {
    val newlist = clientIds.map(id  =>
      BuildAuth.any(
          withThirdProfile = BuildThirdProfile.any(
            withClientid = id
          )
    )).to[Vector]

    new Auths(newlist)
  }
}
