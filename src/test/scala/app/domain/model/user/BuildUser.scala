package test.app.domain.user

import app.domain.model.BuildSurrogateId
import app.domain.user.User
import app.domain.model.user.{UserId, UserProfile}
import test.app.domain.model.user.BuildUserId

object BuildUser {
    def any(
             withSurrogateId: Option[Long] =  BuildSurrogateId.any(),
             withId: UserId = BuildUserId.any(),
             withProfile: UserProfile = BuildUserProfile.any()
           ):User  = {
      val user = new User(withId, withProfile)

      if(withSurrogateId != None) {
        user.setSurrogateId(withSurrogateId)
      }

      user
    }
}
