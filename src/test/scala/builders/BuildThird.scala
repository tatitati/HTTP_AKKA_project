package test.builders

import app.domain.third.{Third, ThirdCredentials, ThirdProfile}

object BuildThird {
    def any(
             withId: Option[Long] = Faker(Some(Faker.number()), None),
             withThirdProfile: ThirdProfile = BuildThirdProfile.any(),
             withCredentials: ThirdCredentials = BuildThirdCredentials.any()
        ): Third = {

      new Third(withId, withThirdProfile, withCredentials)
    }
}
