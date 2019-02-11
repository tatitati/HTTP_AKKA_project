package builders

import app.domain.thirdstore.resourcestore.ResourceByCode
import builders.authorizes.BuildScope

object BuildResourceByCode {

  def any(): ResourceByCode  = {
    new ResourceByCode(
      thirdProfile = BuildThirdProfile.any(),
      BuildOwnerProfile.any(),
      BuildScope.any(),
      BuildCode.anyLive()
    )
  }
}

