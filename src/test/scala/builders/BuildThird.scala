package builders

import app.domain.thirdstore.{ResourceByToken, Third, ThirdProfile}

object BuildThird {
    def any(
           withThirdProfile: ThirdProfile = BuildThirdProfile.any(),
           withReource: ResourceByToken = BuildResourceByToken.withLiveToken()
        ): Third = {

      new Third(withThirdProfile, withReource)

    }
}
