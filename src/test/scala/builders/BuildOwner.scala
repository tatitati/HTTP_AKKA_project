package builders

import app.domain.ownerstore.{Auths, Owner, OwnerProfile}
import builders.authorizes.BuildListAuth

object BuildOwner {
    def any(
             withProfile: OwnerProfile = BuildOwnerProfile.any(),
             withAuthorizationsList: Auths = BuildListAuth.any()
           ):Owner  = {
      new Owner(withProfile, withAuthorizationsList)
    }
}
