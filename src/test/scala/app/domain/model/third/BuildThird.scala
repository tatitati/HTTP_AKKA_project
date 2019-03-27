package test.app.domain.third

import java.util.UUID

import app.domain.model.third.ThirdId
import app.domain.third.{Third, ThirdCredentials, ThirdProfile}
import test.builders.{BuildSurrogateId, BuildUuid}

object BuildThird {
    def any(
             withSurrogateId: Option[Long] =  BuildSurrogateId.anyPersisted(),
             withId: ThirdId = ThirdId(BuildUuid.any()),
             withThirdProfile: ThirdProfile = BuildThirdProfile.any(),
             withCredentials: ThirdCredentials = BuildThirdCredentials.any()
        ): Third = {

      val third = new Third(withId, withThirdProfile, withCredentials)

      if (withSurrogateId != None) {
        third.setSurrogateId(withSurrogateId)
      }

      third
    }

}
