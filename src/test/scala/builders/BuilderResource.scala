package builders

import app.domain.thirdstore.Resource
import app.domain.ownerstore.authorizations.Scope
import builders.authorizes.BuilderScope

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

  def anyWithoutToken(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      BuilderProfile.any(surname = withsurname),
      scope.getOrElse(BuilderScope.onlySurname()),
      None
    )
  }
}

