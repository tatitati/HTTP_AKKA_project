package app.domain.third

import java.util.UUID

import builders.{BuildSurrogateId, BuildUuid}
import builders.domain.BuildUuid

object BuildThird {
    def any(
             withSurrogateId: Option[Long] =  BuildSurrogateId.anyPersisted(),
             withUUID: UUID = BuildUuid.any(),
             withThirdProfile: ThirdProfile = BuildThirdProfile.any(),
             withCredentials: ThirdCredentials = BuildThirdCredentials.any()
        ): Third = {

      val third = new Third(withUUID, withThirdProfile, withCredentials)

      if (withSurrogateId != None) {
        third.setSurrogateId(withSurrogateId)
      }

      third
    }

}
