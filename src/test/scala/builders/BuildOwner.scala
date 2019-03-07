package test.builders

import app.domain.owner.{Auths, Owner, OwnerProfile}
import builders.authorizes.BuildAuths

object BuildOwner {
    def any(
             withProfile: OwnerProfile = BuildOwnerProfile.any(),
             withAuths: Auths = BuildAuths.any()
           ):Owner  = {
      new Owner(withProfile, withAuths)
    }
}
