package builders

import app.domain.{Scope, Token}
import app.domain.thirdstore.{Code, ResourceCode, ResourceToken}
import builders.authorizes.BuildScope

object BuildResourceCode {

  def withLiveCode(
                     withsurname: String = Faker.text(),
                     withScope: Option[Scope] = None
                   ): ResourceCode  = {
    new ResourceCode(
      ownerProfile  = BuildOwnerProfile.any(withSurname = withsurname),
      scope = withScope.getOrElse(BuildScope.any()),
      code = BuildCode.anyLive()
    )
  }

  def withExpiredCode(
                        withsurname: String = Faker.text(),
                        withScope: Option[Scope] = None
                      ): ResourceCode  = {
    new ResourceCode(
      ownerProfile = BuildOwnerProfile.any(withSurname = withsurname),
      scope = withScope.getOrElse(BuildScope.any()),
      code = BuildCode.anyExpired()
    )
  }

  def withCode(withCode: Code): ResourceCode  = {
    new ResourceCode(
      BuildOwnerProfile.any(),
      BuildScope.any(),
      withCode
    )
  }
}

