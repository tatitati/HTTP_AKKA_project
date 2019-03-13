package test.builders

import app.domain.owner.OwnerProfile
import app.domain.resource.{Code, ResourceByCode, Scope}
import app.domain.third.{Third, ThirdProfile}
import builders.authorizes.BuildScope
import com.github.nscala_time.time.Imports._

object BuildResourceByCode {

  def any(
           withThird: Third = BuildThird.any(),
           withOwnerProfile: OwnerProfile = BuildOwnerProfile.any(),
           withScope: Scope = BuildScope.any(),
           withCode: Code = BuildCode.anyLive()
         ): ResourceByCode  = {

    new ResourceByCode(withThird, withOwnerProfile, withScope, withCode)
  }

  def specific(): ResourceByCode = {
    any(
      BuildThird.any(
        withSurrogateId = Some(22),
        withThirdProfile = BuildThirdProfile.specific(),
        withCredentials = BuildThirdCredentials.specific()
      ),
      withOwnerProfile = BuildOwnerProfile.any(
        withEmail = "email",
        withEmailConfirmed = true,
        withFirstname = "firstname",
        withSurname = "surname",
        withDatebirth = new DateTime("1900-03-10")
      ),
      withScope = BuildScope.onlyEmailAndFirstname(),
      withCode = BuildCode.any(
        withCode = "code",
        withState = "state",
        generatedIn = new DateTime("2015-02-10")
      )
    )
  }
}

