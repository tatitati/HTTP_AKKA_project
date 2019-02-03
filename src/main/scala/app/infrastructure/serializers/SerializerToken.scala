package app.infrastructure.serializers

import app.domain.thirdstore.MementoToken
import net.liftweb.json._

class SerializerToken(mementoToken: MementoToken) {

  def toJson(): String = {
    implicit val formats = DefaultFormats

    Serialization.write(
      Map(
          "access_token" -> mementoToken.accessToken,
          "refresh_token" -> mementoToken.refreshToken,
          "token_type" -> mementoToken.tokenType,
          "expires" -> mementoToken.expiresIn
      )
    )
  }
}
