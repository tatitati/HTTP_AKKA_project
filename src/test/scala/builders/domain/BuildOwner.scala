package builders.domain

import app.domain.owner.{Auths, Owner, OwnerProfile}

object BuildOwner {
    def any(
             withProfile: OwnerProfile = BuildOwnerProfile.any(),
             withAuths: Auths = BuildAuths.any()
           ):Owner  = {
      new Owner(withProfile, withAuths)
    }
}
