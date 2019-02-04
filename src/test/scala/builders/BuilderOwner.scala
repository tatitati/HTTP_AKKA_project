package builders

import app.domain.Profile
import app.domain.ownerstore.Owner
import builders.authorizes.BuilderAuthorizationsList

object BuilderOwner {
    def any(
             profile: Profile = BuilderProfile.any()
           ):Owner  = {
      new Owner(profile, BuilderAuthorizationsList.any())
    }
}
