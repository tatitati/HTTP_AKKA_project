package builders

import java.util.UUID

import app.domain.Token
import com.github.nscala_time.time.Imports._

object BuildToken {
  def anyLive(
               withTokenType: String = "bearer",
               withExpirationIn: Int = 10,
               withRefreshToken: UUID = java.util.UUID.randomUUID,
               withAccessToken: UUID = java.util.UUID.randomUUID
             ): Token = {
    new Token(
      accessToken = withAccessToken,
      tokenType = withTokenType,
      refreshToken = withRefreshToken,
      generatedIn = DateTime.now() - 5.seconds,
      expiresIn = withExpirationIn
    )
  }

  def anyExpired(
                  withTokenType: String = "bearer",
                  withExpirationIn: Int = 10,
                  withRefreshToken: UUID = java.util.UUID.randomUUID,
                  withAccessToken: UUID = java.util.UUID.randomUUID
                ): Token = {
    new Token(
      accessToken = withAccessToken,
      tokenType = withTokenType,
      refreshToken = withRefreshToken,
      generatedIn = DateTime.now() - 20.seconds,
      expiresIn = withExpirationIn
    )
  }
}
