package builders

import app.domain.Profile
import app.domain.ownerstore.Owner
import app.domain.ownerstore.authorizations.AuthorizationsList
import builders.authorizes.BuilderAuthorizationsList

object BuilderOwner {
    def any(
             profile: Profile = BuilderProfile.any(),
             authorizationsList: AuthorizationsList = BuilderAuthorizationsList.any()
           ):Owner  = {
      new Owner(profile, authorizationsList)
    }
}
