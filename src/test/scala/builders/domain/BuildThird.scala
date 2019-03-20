package builders.domain

import app.domain.third.{Third, ThirdCredentials, ThirdProfile}

object BuildThird {
    def any(
             withSurrogateId: Option[Long] =  BuildSurrogateId.anyPersisted(),
             withThirdProfile: ThirdProfile = BuildThirdProfile.any(),
             withCredentials: ThirdCredentials = BuildThirdCredentials.any()
        ): Third = {

      val third = new Third(withThirdProfile, withCredentials)

      if (withSurrogateId != None) {
        third.setSurrogateId(withSurrogateId)
      }

      third
    }

}
