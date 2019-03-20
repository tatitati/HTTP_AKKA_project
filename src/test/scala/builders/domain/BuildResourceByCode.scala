package builders.domain

import app.domain.owner.OwnerProfile
import app.domain.resource.{Code, ResourceByCode, Scope}
import app.domain.third.Third

object BuildResourceByCode {

  def any(
           withThird: Third = BuildThird.any(),
           withOwnerProfile: OwnerProfile = BuildOwnerProfile.any(),
           withScope: Scope = BuildScope.any(),
           withCode: Code = BuildCode.anyLive()
         ): ResourceByCode  = {

    new ResourceByCode(withThird, withOwnerProfile, withScope, withCode)
  }

  def specific(): ResourceByCode = {
    any(
      BuildThird.any(
        withSurrogateId = Some(22),
        withThirdProfile = BuildThirdProfile.specific(),
        withCredentials = BuildThirdCredentials.specific()
      ),
      withOwnerProfile = BuildOwnerProfile.specific(),
      withScope = BuildScope.onlyEmailAndFirstname(),
      withCode = BuildCode.specific()
    )
  }
}
