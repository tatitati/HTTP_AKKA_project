package builders

import app.domain.Profile
import app.domain.ownerstore.{AuthorizationsList, Owner}
import builders.authorizes.BuilderAuthorizationsList

object BuilderOwner {
    def any(
             profile: Profile = BuilderProfile.any(),
             authorizationsList: AuthorizationsList = BuilderAuthorizationsList.any()
           ):Owner  = {
      new Owner(profile, authorizationsList)
    }
}
