package test.builders

import app.domain.Scope
import app.domain.ownerstore.OwnerProfile
import app.domain.thirdstore.ThirdProfile
import app.domain.thirdstore.resourcestore.{Code, ResourceByCode}
import builders.authorizes.BuildScope

object BuildResourceByCode {

  def any(
           withThirdProfile: ThirdProfile = BuildThirdProfile.any(),
           withOwnerProfile: OwnerProfile = BuildOwnerProfile.any(),
           withScope: Scope = BuildScope.any(),
           withCode: Code = BuildCode.anyLive()
         ): ResourceByCode  = {

    new ResourceByCode(withThirdProfile, withOwnerProfile, withScope, withCode)
  }

  def specific(): ResourceByCode = {

    any(
      withThirdProfile = BuildThirdProfile.any(
        withName = "name",
        withClientid = "clientid",
        withClientsecret = "clientsecret",
        withCallback = "callback",
        withHomepage = "homepage",
        withDescription = "description"
      ),
      withOwnerProfile = BuildOwnerProfile.any(
        withEmail = "email",
        withEmailConfirmed = true,
        withFirstname = "firstname",
        withSurname = "surname"
      ),
      withScope = BuildScope.onlyEmailAndFirstname(),
      withCode = BuildCode.anyLive(
        withCode = "code",
        withState = "state"
      )
    )
  }
}

