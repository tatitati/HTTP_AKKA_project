package builders

import app.domain.thirdstore.Third

object BuilderThird {
    def any(): Third = {
      new Third("travis", "anyclientid", "anyclientsecret", "callback", "homepage", "description")
    }

    def anyWithClientId(clientId: String): Third = {
      new Third("travis", clientId, "anyclientsecret", "callback", "homepage", "description")
    }
}
