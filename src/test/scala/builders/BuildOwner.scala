package builders

import app.domain.ownerstore.{ListAuth, Owner, OwnerProfile}
import builders.authorizes.BuildListAuth

object BuildOwner {
    def any(
             profile: OwnerProfile = BuildOwnerProfile.any(),
             authorizationsList: ListAuth = BuildListAuth.any()
           ):Owner  = {
      new Owner(profile, authorizationsList)
    }
}
