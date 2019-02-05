package builders

import app.domain.thirdstore.{ThirdProfile, Third}

object BuildThird {
    def any(
           name: String = "travis",
           clientId: String = "anyclientid",
           clientSecret: String = "anyclientsecret",
           callBack: String = "callback",
           homepage: String = "homepage",
           description: String = "description"
           ): Third = {

      new Third(ThirdProfile(name, clientId, clientSecret, callBack, homepage, description))

    }

    def anyWithClientId(clientId: String): Third = {
      new Third(ThirdProfile("travis", clientId, "anyclientsecret", "callback", "homepage", "description"))
    }

}
