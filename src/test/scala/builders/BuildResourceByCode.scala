package test.builders

import app.domain.Scope
import app.domain.ownerstore.OwnerProfile
import app.domain.thirdstore.ThirdProfile
import app.domain.thirdstore.resourcestore.{Code, ResourceByCode}
import builders.authorizes.BuildScope

object BuildResourceByCode {

  def any(
           thirdProfile: ThirdProfile = BuildThirdProfile.any(),
           ownerProfile: OwnerProfile = BuildOwnerProfile.any(),
           scope: Scope = BuildScope.any(),
           code: Code = BuildCode.anyLive()
         ): ResourceByCode  = {

    new ResourceByCode(thirdProfile, ownerProfile, scope, code)
  }
}

