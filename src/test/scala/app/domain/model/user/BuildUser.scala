package test.app.domain.user

import app.domain.user.User
import app.domain.model.auth.AuthId
import app.domain.model.user.{UserId, UserProfile}
import test.app.domain.model.auth.BuildAuthId
import test.app.domain.model.user.BuildUserId

object BuildUser {
    def any(
             withId: UserId = BuildUserId.any(),
             withProfile: UserProfile = BuildUserProfile.any(),
             withAuths: Vector[AuthId] = Vector(BuildAuthId.any(), BuildAuthId.any())
           ):User  = {
      new User(withId, withProfile, withAuths)
    }
}
