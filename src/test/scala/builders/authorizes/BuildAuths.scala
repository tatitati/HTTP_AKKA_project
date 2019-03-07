package builders.authorizes

import app.domain.ownerstore.Auths
import test.builders.{BuildThird, BuildThirdCredentials, BuildThirdProfile}
import test.builders.authorizes.BuildAuth

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
          withThird = BuildThird.any(
            withCredentials = BuildThirdCredentials.any(
              withClientid = id
            )
          )
    )).to[Vector]

    new Auths(newlist)
  }
}
