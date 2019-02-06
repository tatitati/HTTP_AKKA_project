package builders

import app.domain.thirdstore.{Resource, Third, ThirdProfile}

object BuildThird {
    def any(
           withThirdProfile: ThirdProfile = BuildThirdProfile.any(),
           withReource: Resource = BuildResource.withLiveToken()
        ): Third = {

      new Third(withThirdProfile, withReource)

    }
}
