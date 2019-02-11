package app.domain.thirdstore

import app.domain.Token
import com.github.nscala_time.time.Imports.DateTime

object ResourceTokenFactory {

  def fromResourceCode(resourceCode: ResourceCode): ResourceToken = {
    new ResourceToken(
      thirdProfile = resourceCode.thirdProfile,
      ownerProfile = resourceCode.ownerProfile,
      scope = resourceCode.scope,
      token = new Token(
        accessToken = java.util.UUID.randomUUID,
        refreshToken = java.util.UUID.randomUUID,
        generatedIn = DateTime.now(),
        tokenType = "bearer"
      )
    )
  }
}
