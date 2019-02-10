package builders

import app.domain.thirdstore.{ResourceToken, Third, ThirdProfile}

object BuildThird {
    def any(
           withThirdProfile: ThirdProfile = BuildThirdProfile.any(),
           withReource: ResourceToken = BuildResourceToken.withLiveToken()
        ): Third = {

      new Third(withThirdProfile, withReource)

    }
}
