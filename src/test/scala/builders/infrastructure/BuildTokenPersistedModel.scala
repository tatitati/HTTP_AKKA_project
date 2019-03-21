package builders.infrastructure

import app.infrastructure.Persistence.resource.TokenPersistentModel
import builders.domain.{BuildSurrogateId, BuildUuid}
import com.github.nscala_time.time.Imports._
import test.builders.Faker

object BuildTokenPersistedModel {
  def any(
           withId: Option[Long] = BuildSurrogateId.any(),
           withAccessToken: String = BuildUuid.uuidOne().toString,
           withTokenType: String = Faker.text(),
           withRefreshToken: String = BuildUuid.uuidTwo().toString,
           withExpiresIn: Int = Faker.int(),
           withGeneratedIn: DateTime = new DateTime("2020-10-15")
         ): TokenPersistentModel = {
    TokenPersistentModel(
      id = withId,
      accessToken = withAccessToken,
      tokenType = withTokenType,
      refreshToken = withRefreshToken,
      expiresIn = withExpiresIn,
      generatedIn = withGeneratedIn
    )
  }
}