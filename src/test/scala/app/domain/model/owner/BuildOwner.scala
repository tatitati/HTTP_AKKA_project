package app.domain.owner

import app.domain.model.auth.AuthId
import app.domain.model.owner.{OwnerId, OwnerProfile}
import test.app.domain.model.auth.BuildAuthId
import test.app.domain.model.owner.BuildOwnerId

object BuildOwner {
    def any(
             withOwnerId: OwnerId = BuildOwnerId.any(),
             withProfile: OwnerProfile = BuildOwnerProfile.any(),
             withAuths: Vector[AuthId] = Vector(BuildAuthId.any(), BuildAuthId.any())
           ):Owner  = {
      new Owner(withOwnerId, withProfile, withAuths)
    }
}
