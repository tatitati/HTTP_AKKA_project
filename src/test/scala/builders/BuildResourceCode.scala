package builders

import app.domain.{Scope, Token}
import app.domain.thirdstore.{Code, ResourceCode, ResourceToken}
import builders.authorizes.BuildScope

object BuildResourceCode {

  def anyLive(withCode: String = Faker.text()): ResourceCode  = {
    new ResourceCode(
      thirdProfile = BuildThirdProfile.any(),
      ownerProfile = BuildOwnerProfile.any(),
      scope = BuildScope.any(),
      code = BuildCode.anyLive(withCode = withCode)
    )
  }

  def anyExpired(withCode: String = Faker.text()): ResourceCode  = {
    new ResourceCode(
      thirdProfile = BuildThirdProfile.any(),
      ownerProfile = BuildOwnerProfile.any(),
      scope = BuildScope.any(),
      code = BuildCode.anyExpired(withCode = withCode)
    )
  }

  def any(withCode: Code): ResourceCode  = {
    new ResourceCode(
      thirdProfile = BuildThirdProfile.any(),
      BuildOwnerProfile.any(),
      BuildScope.any(),
      withCode
    )
  }
}

