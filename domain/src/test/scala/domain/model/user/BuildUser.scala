package domain.test.model.user

import domain.test.model.BuildSurrogateId
import domain.model.user.User
import domain.model.user._
import domain.test.model.user.BuildUserId
import com.github.nscala_time.time.Imports.DateTime
import domain.test.builders.{BuildDate, Faker}

object BuildUser {
    def any(
             withSurrogateId: Option[Long] =  BuildSurrogateId.any(),
             withId: UserId = BuildUserId.any(),
             withProfile: UserProfile = BuildUserProfile.any(),
             withRegisteredDateTime: DateTime = BuildDate.any(),
             withEmailConfirmed: Boolean = Faker.boolean(),
             withUserCredentials: UserCredentials = BuildUserCredentials.any()
           ):User  = {
      val user = new User(
        withId,
        withProfile,
        withRegisteredDateTime,
        withEmailConfirmed,
        withUserCredentials
      )

      if(withSurrogateId != None) {
        user.setSurrogateId(withSurrogateId)
      }

      user
    }
}
