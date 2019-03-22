package builders.domain

import java.util.UUID

import app.domain.auth.Token
import com.github.nscala_time.time.Imports._
import test.builders.Faker

object BuildToken {
  def anyLive(
               withSurrogateId: Option[Long] =  BuildSurrogateId.any(),
               withTokenType: String = "bearer",
               withExpirationIn: Int = 10,
               withRefreshToken: UUID = java.util.UUID.randomUUID,
               withAccessToken: UUID = java.util.UUID.randomUUID
             ): Token = {
    val token = new Token(
      accessToken = withAccessToken,
      tokenType = withTokenType,
      refreshToken = withRefreshToken,
      generatedIn = DateTime.now() - 5.seconds,
      expiresIn = withExpirationIn
    )

    if (withSurrogateId != None) {
        token.setSurrogateId(withSurrogateId)
    }

    token
  }

  def anyExpired(
                  withSurrogateId: Option[Long] =  BuildSurrogateId.any(),
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

  def any(withSurrogateId: Option[Long] =  BuildSurrogateId.any()): Token = {
    Faker(
      anyLive(withSurrogateId),
      anyExpired(withSurrogateId)
    )
  }
}
