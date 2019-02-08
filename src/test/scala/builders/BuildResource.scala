package builders

import app.domain.{Scope, Token}
import app.domain.thirdstore.Resource
import builders.authorizes.BuildScope

object BuildResource {

  def withLiveToken(
                     withsurname: String = Faker.text(),
                     withScope: Option[Scope] = None
                   ): Resource  = {
    new Resource(
      ownerProfile  = BuildOwnerProfile.any(withSurname = withsurname),
      scope = withScope.getOrElse(BuildScope.any()),
      token = Option(BuildToken.anyLive())
    )
  }

  def withExpiredToken(
                        withsurname: String = Faker.text(),
                        withScope: Option[Scope] = None
                      ): Resource  = {
    new Resource(
      ownerProfile = BuildOwnerProfile.any(withSurname = withsurname),
      scope = withScope.getOrElse(BuildScope.any()),
      token = Option(BuildToken.anyExpired())
    )
  }

  def withRevokedToken(
                        withsurname: String = Faker.text(),
                        withScope: Option[Scope] = None
                      ): Resource  = {
    new Resource(
      BuildOwnerProfile.any(withSurname = withsurname),
      withScope.getOrElse(BuildScope.any()),
      None
    )
  }

  def withoutToken(
                    withsurname: String = Faker.text(),
                    withScope: Option[Scope] = None
                  ): Resource  = {
    new Resource(
      BuildOwnerProfile.any(withSurname = withsurname),
      withScope.getOrElse(BuildScope.any()),
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

