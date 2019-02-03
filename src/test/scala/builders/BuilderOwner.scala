package builders

import app.domain.ownerstore.Owner
import builders.authorizes.BuilderAuthorizationsList

object BuilderOwner {
    def any():Owner  = {
      new Owner(BuilderProfile.any(), BuilderAuthorizationsList.any())
    }
}
