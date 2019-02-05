package builders

import app.domain.Scope
import app.domain.thirdstore.Resource
import builders.authorizes.BuildScope

object BuildResource {

  def anyWithLiveToken(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      ownerProfile  = BuildOwnerProfile.any(surname = withsurname),
      scope = scope.getOrElse(BuildScope.onlySurname()),
      token = Option(BuildToken.anyLive())
    )
  }

  def anyWithExpiredToken(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      ownerProfile = BuildOwnerProfile.any(surname = withsurname),
      scope = scope.getOrElse(BuildScope.onlySurname()),
      token = Option(BuildToken.anyExpired())
    )
  }

  def anyRevoked(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      BuildOwnerProfile.any(surname = withsurname),
      scope.getOrElse(BuildScope.onlySurname()),
      None
    )
  }

  def anyWithoutToken(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      BuildOwnerProfile.any(surname = withsurname),
      scope.getOrElse(BuildScope.onlySurname()),
      None
    )
  }
}

