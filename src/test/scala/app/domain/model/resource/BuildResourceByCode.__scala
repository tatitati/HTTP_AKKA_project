package app.domain.resource

import app.domain.auth.Scope
import app.domain.code.Code
import app.domain.owner.{BuildOwnerProfile, OwnerProfile}
import app.domain.third.{BuildThird, BuildThirdCredentials, BuildThirdProfile, Third}
import builders.BuildUuid

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
        withUUID = BuildUuid.uuidOne(),
        withThirdProfile = BuildThirdProfile.specific(),
        withCredentials = BuildThirdCredentials.specific()
      ),
      withOwnerProfile = BuildOwnerProfile.specific(),
      withScope = BuildScope.onlyEmailAndFirstname(),
      withCode = BuildCode.specific()
    )
  }
}
