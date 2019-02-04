package app.domain.thirdstore

import java.util.UUID
import com.github.nscala_time.time.Imports._

class Token(
             val accessToken: UUID,
             val tokenType: String,
             val refreshToken: UUID,
             private var generatedIn: DateTime,
             private val expiresIn: Int = 360000 // 10 hour,
           )  {

  def isExpired: Boolean = {
    val expireInDate = generatedIn + expiresIn.seconds
    val now = DateTime.now()
    expireInDate < now
  }

  def canRefreshWith(givenReshToken: UUID, givenGrantType: String): Boolean = {
    givenGrantType match {
      case "refresh_token" => refreshToken.equals(givenReshToken)
      case _ => false
    }
  }

  def refresh(withRefreshToken: UUID, withGrantType: String): Option[Token] = {
      if (canRefreshWith(withRefreshToken, withGrantType) && isExpired) {
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

  def exportMemento(): MementoToken = {
      new MementoToken(accessToken.toString, tokenType, refreshToken.toString, expiresIn)
  }
}
