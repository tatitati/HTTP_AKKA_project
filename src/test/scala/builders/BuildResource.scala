package builders

import app.domain.Scope
import app.domain.thirdstore.Resource
import builders.authorizes.BuildScope

object BuildResource {

  def withLiveToken(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      ownerProfile  = BuildOwnerProfile.any(withSurname = withsurname),
      scope = scope.getOrElse(BuildScope.onlySurname()),
      token = Option(BuildToken.anyLive())
    )
  }

  def withExpiredToken(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      ownerProfile = BuildOwnerProfile.any(withSurname = withsurname),
      scope = scope.getOrElse(BuildScope.onlySurname()),
      token = Option(BuildToken.anyExpired())
    )
  }

  def withRevokedToken(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      BuildOwnerProfile.any(withSurname = withsurname),
      scope.getOrElse(BuildScope.onlySurname()),
      None
    )
  }

  def withoutToken(withsurname: String = "any surname", scope: Option[Scope] = None): Resource  = {
    new Resource(
      BuildOwnerProfile.any(withSurname = withsurname),
      scope.getOrElse(BuildScope.onlySurname()),
      None
    )
  }
}

