package builders.domain

import app.domain.owner.Auths

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
