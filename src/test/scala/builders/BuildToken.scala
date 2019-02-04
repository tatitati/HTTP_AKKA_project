package builders

import java.util.UUID

import com.github.nscala_time.time.Imports._
import app.domain.thirdstore.Token

object BuildToken {
  def anyLive(
               tokenType: String = "bearer",
               expiresIn: Int = 10,
               refreshToken: UUID = java.util.UUID.randomUUID,
               accessToken: UUID = java.util.UUID.randomUUID
             ): Token = {
    new Token(
      accessToken,
      tokenType,
      refreshToken,
      DateTime.now() - 5.seconds,
      expiresIn
    )
  }

  def anyExpired(
                  tokenType: String = "bearer",
                  expiresIn: Int = 10,
                  refreshToken: UUID = java.util.UUID.randomUUID,
                  accessToken: UUID = java.util.UUID.randomUUID
                ): Token = {
    new Token(
      accessToken,
      tokenType,
      refreshToken,
      DateTime.now() - 20.seconds,
      expiresIn
    )
  }
}
