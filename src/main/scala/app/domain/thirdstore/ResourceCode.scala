package app.domain.thirdstore

import app.domain.{Scope, Token}
import app.domain.ownerstore.OwnerProfile
import com.github.nscala_time.time.Imports.DateTime

class ResourceCode(
                     val thirdProfile: ThirdProfile,
                     val ownerProfile: OwnerProfile,
                     val scope: Scope,
                     private val code: Code
                   ){

  def toResourceToken(): ResourceToken = {
    new ResourceToken(
      thirdProfile = thirdProfile,
      ownerProfile = ownerProfile,
      scope = scope,
      token = new Token(
        accessToken = java.util.UUID.randomUUID,
        refreshToken = java.util.UUID.randomUUID,
        generatedIn = DateTime.now(),
        tokenType = "bearer"
      )
    )
  }
}
