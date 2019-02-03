package builders

import test.builders.permissions.{BuilderAuthorizationsList, BuilderScope}
import app.domain.thirdstore.Resource
import app.domain.ownerstore.authorizations.Scope

object BuilderResource {

  def anyWithLiveToken(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      BuilderProfile.any(surname = withsurname),
      scope.getOrElse(BuilderScope.onlySurname()),
      Option(BuilderToken.anyLive())
    )
  }

  def anyWithExpiredToken(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      BuilderProfile.any(surname = withsurname),
      scope.getOrElse(BuilderScope.onlySurname()),
      Option(BuilderToken.anyExpired())
    )
  }

  def anyRevoked(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      BuilderProfile.any(surname = withsurname),
      scope.getOrElse(BuilderScope.onlySurname()),
      None
    )
  }
}

