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
      token = BuildToken.anyLive()
    )
  }

  def withExpiredToken(
                        withsurname: String = Faker.text(),
                        withScope: Option[Scope] = None
                      ): ResourceToken  = {
    new ResourceToken(
      ownerProfile = BuildOwnerProfile.any(withSurname = withsurname),
      scope = withScope.getOrElse(BuildScope.any()),
      token = BuildToken.anyExpired()
    )
  }

  def withToken(withToken: Token): ResourceToken  = {
    new ResourceToken(
      BuildOwnerProfile.any(),
      BuildScope.any(),
      withToken
    )
  }
}

