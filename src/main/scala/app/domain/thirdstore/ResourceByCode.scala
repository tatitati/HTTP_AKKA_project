package app.domain.thirdstore

import app.domain.{Scope, Token}
import app.domain.ownerstore.OwnerProfile
import com.github.nscala_time.time.Imports.DateTime

// By definition, if a resource code exists, is live. It cannot exists in any other state like expired
class ResourceByCode(
                     val thirdProfile: ThirdProfile,
                     val ownerProfile: OwnerProfile,
                     val scope: Scope,
                     private val code: Code
                   ){

  def toResourceByToken(): ResourceByToken = {
    new ResourceByToken(
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
