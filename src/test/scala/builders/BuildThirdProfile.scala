package builders

import app.domain.thirdstore.ThirdProfile

object BuildThirdProfile {
    def any(
        withName: String = AnyFrom.text(),
        withClientid: String = "anyclientid",
        withClientsecret: String = AnyFrom.text(),
        withCallback: String = AnyFrom.text(),
        withHomepage: String = AnyFrom.text(),
        withDescription: String = AnyFrom.text()
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
