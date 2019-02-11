package app.domain.thirdstore.resourcestore

import app.domain.Scope
import app.domain.factories.FactoryToken
import app.domain.ownerstore.OwnerProfile
import app.domain.thirdstore.ThirdProfile

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
      token = FactoryToken.create()
    )
  }
}
