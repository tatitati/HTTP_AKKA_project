package app.domain

import java.util.UUID
import com.github.nscala_time.time.Imports._

class Token(
             val accessToken: UUID,
             val tokenType: String,
             val refreshToken: UUID,
             val expiresIn: Int = 360000,
             private var generatedIn: DateTime
  ){

  def isExpired: Boolean = {
    val expireInDate = generatedIn + expiresIn.seconds
    val now = DateTime.now()
    expireInDate < now
  }

  def canRefresh(givenRefreshToken: UUID, givenGrantType: String): Boolean = {
    givenGrantType match {
      case "refresh_token" => refreshToken.equals(givenRefreshToken) && isExpired
      case _ => false
    }
  }

  def refresh(refreshToken: UUID, grantType: String): Option[Token] = {
      if (canRefresh(refreshToken, grantType) && isExpired) {
          Some(new Token(
              accessToken = java.util.UUID.randomUUID,
              refreshToken = java.util.UUID.randomUUID,
              generatedIn = DateTime.now(),
              tokenType = "bearer"
          ))
      } else {
        None
      }
  }
}
