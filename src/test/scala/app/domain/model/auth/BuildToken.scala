package test.app.domain.model.auth

import java.util.UUID
import app.domain.model.auth.Token
import test.builders.BuildSurrogateId
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
    new Token(
      accessToken = withAccessToken,
      tokenType = withTokenType,
      refreshToken = withRefreshToken,
      generatedIn = DateTime.now() - 5.seconds,
      expiresIn = withExpirationIn
    )
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
