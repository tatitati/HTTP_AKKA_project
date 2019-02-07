package builders

import app.domain.{Scope, Token}
import app.domain.thirdstore.Resource
import builders.authorizes.BuildScope

object BuildResource {

  def withLiveToken(
                     withsurname: String = AnyFrom.text(),
                     scope: Option[Scope] = None
                   ): Resource  = {
    new Resource(
      ownerProfile  = BuildOwnerProfile.any(withSurname = withsurname),
      scope = scope.getOrElse(BuildScope.any()),
      token = Option(BuildToken.anyLive())
    )
  }

  def withExpiredToken(
                        withsurname: String = AnyFrom.text(),
                        scope: Option[Scope] = None
                      ): Resource  = {
    new Resource(
      ownerProfile = BuildOwnerProfile.any(withSurname = withsurname),
      scope = scope.getOrElse(BuildScope.any()),
      token = Option(BuildToken.anyExpired())
    )
  }

  def withRevokedToken(
                        withsurname: String = AnyFrom.text(),
                        scope: Option[Scope] = None
                      ): Resource  = {
    new Resource(
      BuildOwnerProfile.any(withSurname = withsurname),
      scope.getOrElse(BuildScope.any()),
      None
    )
  }

  def withoutToken(
                    withsurname: String = AnyFrom.text(),
                    scope: Option[Scope] = None
                  ): Resource  = {
    new Resource(
      BuildOwnerProfile.any(withSurname = withsurname),
      scope.getOrElse(BuildScope.any()),
      None
    )
  }

  def withToken(withToken: Token): Resource  = {
    new Resource(
      BuildOwnerProfile.any(),
      BuildScope.any(),
      Option(withToken)
    )
  }
}

