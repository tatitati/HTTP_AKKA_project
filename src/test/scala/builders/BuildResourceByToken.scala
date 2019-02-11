package builders

import app.domain.thirdstore.resourcestore.ResourceByToken
import app.domain.{Scope, Token}
import builders.authorizes.BuildScope

object BuildResourceByToken {

  def withLiveToken(
                     withsurname: String = Faker.text(),
                     withScope: Option[Scope] = None
                   ): ResourceByToken  = {
    new ResourceByToken(
      thirdProfile  = BuildThirdProfile.any(),
      ownerProfile  = BuildOwnerProfile.any(withSurname = withsurname),
      scope = withScope.getOrElse(BuildScope.any()),
      token = BuildToken.anyLive()
    )
  }

  def withExpiredToken(
                        withsurname: String = Faker.text(),
                        withScope: Option[Scope] = None
                      ): ResourceByToken  = {
    new ResourceByToken(
      thirdProfile  = BuildThirdProfile.any(),
      ownerProfile = BuildOwnerProfile.any(withSurname = withsurname),
      scope = withScope.getOrElse(BuildScope.any()),
      token = BuildToken.anyExpired()
    )
  }

  def withToken(withToken: Token): ResourceByToken  = {
    new ResourceByToken(
      thirdProfile  = BuildThirdProfile.any(),
      BuildOwnerProfile.any(),
      BuildScope.any(),
      withToken
    )
  }
}

