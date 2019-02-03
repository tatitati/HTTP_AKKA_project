package builders

import test.builders.permissions.BuilderAuthorizationsList
import app.domain.ownerstore.Owner

object BuilderOwner {
    def any():Owner  = {
      new Owner(BuilderProfile.any(), BuilderAuthorizationsList.any())
    }
}
