package test.app.domain.user

import app.domain.model.BuildSurrogateId
import app.domain.user.User
import app.domain.model.user._
import test.app.domain.model.user.BuildUserId
import com.github.nscala_time.time.Imports.DateTime
import test.builders.{BuildDate, Faker}

object BuildUser {
    def any(
             withSurrogateId: Option[Long] =  BuildSurrogateId.any(),
             withId: UserId = BuildUserId.any(),
             withProfile: UserProfile = BuildUserProfile.any(),
             withRegisteredDateTime: DateTime = BuildDate.any(),
             withEmailConfirmed: Boolean = Faker.boolean(),
           ):User  = {
      val user = new User(withId, withProfile, withRegisteredDateTime, withEmailConfirmed)

      if(withSurrogateId != None) {
        user.setSurrogateId(withSurrogateId)
      }

      user
    }
}
