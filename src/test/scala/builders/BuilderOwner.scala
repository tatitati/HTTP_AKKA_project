package builders

import app.domain.Profile
import app.domain.ownerstore.{AuthList, Owner}
import builders.authorizes.BuilderAuthList

object BuilderOwner {
    def any(
             profile: Profile = BuilderProfile.any(),
             authorizationsList: AuthList = BuilderAuthList.any()
           ):Owner  = {
      new Owner(profile, authorizationsList)
    }
}
