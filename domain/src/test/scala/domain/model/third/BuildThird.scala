package domain.test.model.third

import domain.test.model.BuildSurrogateId
import domain.model.third.ThirdId
import domain.model.third.{Third, ThirdCredentials, ThirdProfile}
import domain.test.builders.BuildUuid

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
