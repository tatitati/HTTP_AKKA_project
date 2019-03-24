package app.domain.third

import java.util.UUID
import test.builders.{BuildSurrogateId, BuildUuid}

object BuildThird {
    def any(
             withSurrogateId: Option[Long] =  BuildSurrogateId.anyPersisted(),
             withUUID: UUID = BuildUuid.any(),
             withThirdProfile: ThirdProfile = BuildThirdProfile.any(),
             withCredentials: Credentials = BuildThirdCredentials.any()
        ): Third = {

      val third = new Third(withUUID, withThirdProfile, withCredentials)

      if (withSurrogateId != None) {
        third.setSurrogateId(withSurrogateId)
      }

      third
    }

}
