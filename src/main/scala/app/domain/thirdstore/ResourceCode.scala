package app.domain.thirdstore

import java.util.UUID
import app.domain.{Scope, Token}
import app.domain.ownerstore.OwnerProfile
import com.github.nscala_time.time.Imports.DateTime

class ResourceCode(
                     private val thirdProfile: ThirdProfile,
                     private val ownerProfile: OwnerProfile,
                     private val scope: Scope,
                     private val code: Code
                   ){

  def isCodeExpired(): Boolean = {
    code.isExpired
  }

  def toResourceToken(): ResourceToken = {
    if (isCodeExpired()) {
      throw new IllegalArgumentException("An expired code cannot be used to get a token")
    }

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
