package builders

import app.domain.Profile
import app.domain.ownerstore.{ListAuth, Owner}
import builders.authorizes.BuildListAuth

object BuildOwner {
    def any(
             profile: Profile = BuildProfile.any(),
             authorizationsList: ListAuth = BuildListAuth.any()
           ):Owner  = {
      new Owner(profile, authorizationsList)
    }
}
