package app.domain.model.auth

import java.util.UUID
import app.domain.model.IdentifiableInPersistence
import com.github.nscala_time.time.Imports._

class Token(
             val accessToken: UUID,
             val tokenType: String = "bearer",
             val refreshToken: UUID,
             val expiresIn: Int = 360000,
             val generatedIn: DateTime
  ) extends IdentifiableInPersistence {

  def isExpired: Boolean = {
    val expireInDate = generatedIn + expiresIn.seconds
    val now = DateTime.now()
    expireInDate < now
  }

  def canRefreshWithParams(givenRefreshToken: UUID, givenGrantType: String): Boolean = {
    givenGrantType match {
      case "refresh_token" => refreshToken.equals(givenRefreshToken)
      case _ => false
    }
  }
}
