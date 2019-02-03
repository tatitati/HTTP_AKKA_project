package builders

import java.util.UUID

import com.github.nscala_time.time.Imports._
import app.domain.thirdstore.Token

object BuilderToken {
  def anyLive(tokenType: String = "bearer", expiresIn: Int = 10, refreshToken: Option[UUID] = None, accessToken: Option[UUID] = None): Token = {
    new Token(
      accessToken.getOrElse(java.util.UUID.randomUUID),
      tokenType,
      refreshToken.getOrElse(java.util.UUID.randomUUID),
      DateTime.now() - 5.seconds,
      expiresIn
    )
  }

  def anyExpired(tokenType: String = "bearer", expiresIn: Int = 10, refreshToken: Option[UUID] = None,  accessToken: Option[UUID] = None): Token = {
    new Token(
      accessToken.getOrElse(java.util.UUID.randomUUID),
      tokenType,
      refreshToken.getOrElse(java.util.UUID.randomUUID),
      DateTime.now() - 20.seconds,
      expiresIn
    )
  }
}
