package builders

import app.domain.ownerstore.{Auths, Owner, OwnerProfile}
import builders.authorizes.BuildListAuth

object BuildOwner {
    def any(
             withProfile: OwnerProfile = BuildOwnerProfile.any(),
             withAuths: Auths = BuildListAuth.any()
           ):Owner  = {
      new Owner(withProfile, withAuths)
    }
}
