package test.builders

import app.domain.thirdstore.{Third, ThirdCredentials, ThirdProfile}

object BuildThird {
    def any(
           withThirdProfile: ThirdProfile = BuildThirdProfile.any(),
           withCredentials: ThirdCredentials = BuildThirdCredentials.any()
        ): Third = {

      new Third(withThirdProfile, withCredentials)

    }
}
