package builders

import app.domain.thirdstore.{ThirdProfile, Third}

object BuildThird {
    def any(
             withName: String = "travis",
             withClientId: String = "anyclientid",
             withClientSecret: String = "anyclientsecret",
             withCallback: String = "callback",
             withHomepage: String = "homepage",
             withDescxription: String = "description"
           ): Third = {

      new Third(ThirdProfile(withName, withClientId, withClientSecret, withCallback, withHomepage, withDescxription))

    }

    def anyWithClientId(clientId: String): Third = {
      new Third(ThirdProfile("travis", clientId, "anyclientsecret", "callback", "homepage", "description"))
    }

}
