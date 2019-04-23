package test.app.domain.model.thirdapp

import app.domain.model.thirdapp.{Thirdapp, ThirdappCredentials, ThirdappId, ThirdappProfile}
import app.domain.model.third.ThirdId
import test.app.domain.model.third.BuildThirdId

object BuildThirdapp {

  def any(
           withSiteId: ThirdappId = BuildThirdappId.any(),
           withThirdId: ThirdId = BuildThirdId.any(),
           withCredentials: ThirdappCredentials = BuildThirdappCredentials.any(),
           withProfile: ThirdappProfile = BuildThirdappProfile.any()
         ): Thirdapp = {

    new Thirdapp(
      thirdappId = withSiteId,
      thirdId = withThirdId,
      credentials = withCredentials,
      profile = withProfile
    )
  }
}
