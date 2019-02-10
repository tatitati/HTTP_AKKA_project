package app.domain

import java.util.UUID
import com.github.nscala_time.time.Imports._

class Token(
             private val accessToken: UUID,
             private val tokenType: String,
             private val refreshToken: UUID,
             private val expiresIn: Int = 360000,
             private val generatedIn: DateTime
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

  def canRefreshWithParams(givenRefreshToken: UUID, givenGrantType: String): Boolean = {
    givenGrantType match {
      case "refresh_token" => refreshToken.equals(givenRefreshToken)
      case _ => false
    }
  }
}
