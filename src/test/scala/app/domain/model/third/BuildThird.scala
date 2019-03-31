package test.app.domain.third

import app.domain.model.BuildSurrogateId
import app.domain.model.third.ThirdId
import app.domain.third.{Third, ThirdCredentials, ThirdProfile}
import test.builders.BuildUuid

object BuildThird {
    def any(
             withSurrogateId: Option[Long] =  BuildSurrogateId.anyPersisted(),
             withId: ThirdId = ThirdId(BuildUuid.any()),
             withThirdProfile: ThirdProfile = BuildThirdProfile.any(),
        ): Third = {

      val third = new Third(withId, withThirdProfile)

      if (withSurrogateId != None) {
        third.setSurrogateId(withSurrogateId)
      }

      third
    }

}
