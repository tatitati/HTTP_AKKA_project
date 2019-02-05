package builders

import app.domain.ownerstore.{ListAuth, Owner, OwnerProfile}
import builders.authorizes.BuildListAuth

object BuildOwner {
    def any(
             withProfile: OwnerProfile = BuildOwnerProfile.any(),
             withAuthorizationsList: ListAuth = BuildListAuth.any()
           ):Owner  = {
      new Owner(withProfile, withAuthorizationsList)
    }
}
