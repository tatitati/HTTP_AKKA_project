package builders

import app.domain.thirdstore.Third

object BuildThird {
    def any(
           name: String = "travis",
           clientId: String = "anyclientid",
           clientSecret: String = "anyclientsecret",
           callBack: String = "callback",
           homepage: String = "homepage",
           description: String = "description"
           ): Third = {
      new Third(name, clientId, clientSecret, callBack, homepage, description)
    }

    def anyWithClientId(clientId: String): Third = {
      new Third("travis", clientId, "anyclientsecret", "callback", "homepage", "description")
    }

}
