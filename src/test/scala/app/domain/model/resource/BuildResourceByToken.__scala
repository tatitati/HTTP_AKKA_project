package app.domain.resource

import app.domain.auth.{Scope, Token}
import app.domain.owner.BuildOwnerProfile
import app.domain.third.BuildThirdProfile
import test.builders.Faker

object BuildResourceByToken {

  def withLiveToken(
                     withsurname: String = Faker.text(),
                     withScope: Option[Scope] = None
                   ): ResourceByToken  = {
    new ResourceByToken(
      thirdProfile  = BuildThirdProfile.any().memento,
      ownerProfile  = BuildOwnerProfile.any(withSurname = withsurname).memento,
      scope = withScope.getOrElse(BuildScope.any()),
      token = BuildToken.anyLive()
    )
  }

  def withExpiredToken(
                        withsurname: String = Faker.text(),
                        withScope: Option[Scope] = None
                      ): ResourceByToken  = {
    new ResourceByToken(
      thirdProfile  = BuildThirdProfile.any().memento,
      ownerProfile = BuildOwnerProfile.any(withSurname = withsurname).memento,
      scope = withScope.getOrElse(BuildScope.any()),
      token = BuildToken.anyExpired()
    )
  }

  def withToken(withToken: Token): ResourceByToken  = {
    new ResourceByToken(
      thirdProfile  = BuildThirdProfile.any().memento,
      BuildOwnerProfile.any().memento,
      BuildScope.any(),
      withToken
    )
  }
}
