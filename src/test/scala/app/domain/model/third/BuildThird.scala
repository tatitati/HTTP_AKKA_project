package app.domain.third

import java.util.UUID
import test.builders.{BuildSurrogateId, BuildUuid}

object BuildThird {
    def any(
             withSurrogateId: Option[Long] =  BuildSurrogateId.anyPersisted(),
             withId: UUID = BuildUuid.any(),
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
