package builders

import app.domain.thirdstore.ThirdProfile

object BuildThirdProfile {
    def any(
        withName: String = "travis",
        withClientid: String = "anyclientid",
        withClientsecret: String = "anyclientsecret",
        withCallback: String = "callback",
        withHomepage: String = "homepage",
        withDescription: String = "description"
           ): ThirdProfile = {

      new ThirdProfile(
          name = withName,
          clientid = withClientid,
          clientsecret = withClientsecret,
          callback = withCallback,
          homepage = withHomepage,
          description = withDescription
      )
    }
}
