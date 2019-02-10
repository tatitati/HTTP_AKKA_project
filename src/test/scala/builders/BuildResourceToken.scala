package builders

import app.domain.{Scope, Token}
import app.domain.thirdstore.ResourceToken
import builders.authorizes.BuildScope

object BuildResourceToken {

  def withLiveToken(
                     withsurname: String = Faker.text(),
                     withScope: Option[Scope] = None
                   ): ResourceToken  = {
    new ResourceToken(
      ownerProfile  = BuildOwnerProfile.any(withSurname = withsurname),
      scope = withScope.getOrElse(BuildScope.any()),
      token = Option(BuildToken.anyLive())
    )
  }

  def withExpiredToken(
                        withsurname: String = Faker.text(),
                        withScope: Option[Scope] = None
                      ): ResourceToken  = {
    new ResourceToken(
      ownerProfile = BuildOwnerProfile.any(withSurname = withsurname),
      scope = withScope.getOrElse(BuildScope.any()),
      token = Option(BuildToken.anyExpired())
    )
  }

  def withRevokedToken(
                        withsurname: String = Faker.text(),
                        withScope: Option[Scope] = None
                      ): ResourceToken  = {
    new ResourceToken(
      BuildOwnerProfile.any(withSurname = withsurname),
      withScope.getOrElse(BuildScope.any()),
      None
    )
  }

  def withoutToken(
                    withsurname: String = Faker.text(),
                    withScope: Option[Scope] = None
                  ): ResourceToken  = {
    new ResourceToken(
      BuildOwnerProfile.any(withSurname = withsurname),
      withScope.getOrElse(BuildScope.any()),
      None
    )
  }

  def withToken(withToken: Token): ResourceToken  = {
    new ResourceToken(
      BuildOwnerProfile.any(),
      BuildScope.any(),
      Option(withToken)
    )
  }
}

