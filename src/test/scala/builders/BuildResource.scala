package builders

import app.domain.thirdstore.Resource
import app.domain.ownerstore.auth.Scope
import builders.authorizes.BuildScope

object BuildResource {

  def anyWithLiveToken(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      BuildProfile.any(surname = withsurname),
      scope.getOrElse(BuildScope.onlySurname()),
      Option(BuildToken.anyLive())
    )
  }

  def anyWithExpiredToken(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      BuildProfile.any(surname = withsurname),
      scope.getOrElse(BuildScope.onlySurname()),
      Option(BuildToken.anyExpired())
    )
  }

  def anyRevoked(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      BuildProfile.any(surname = withsurname),
      scope.getOrElse(BuildScope.onlySurname()),
      None
    )
  }

  def anyWithoutToken(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      BuildProfile.any(surname = withsurname),
      scope.getOrElse(BuildScope.onlySurname()),
      None
    )
  }
}

