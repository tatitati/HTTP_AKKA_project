package builders

import app.domain.thirdstore.{Resource, Third, ThirdProfile}

object BuildThird {
    def any(
           withThirdProfile: ThirdProfile = BuildThirdProfile.any(),
           withReource: Resource = BuildResource.anyWithLiveToken()
        ): Third = {

      new Third(withThirdProfile, withReource)

    }
}
