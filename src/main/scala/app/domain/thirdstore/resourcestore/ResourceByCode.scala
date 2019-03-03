package app.domain.thirdstore.resourcestore

import app.domain.Scope
import app.domain.factories.FactoryToken
import app.domain.ownerstore.OwnerProfile
import app.domain.thirdstore.ThirdProfile

case class ResourceByCode(
                     private val thirdProfile: ThirdProfile,
                     private val ownerProfile: OwnerProfile,
                     private val scope: Scope,
                     private val code: Code
                   ) {

  def exchangeByResourceByToken(): ResourceByToken = {
    new ResourceByToken(
      thirdProfile = thirdProfile,
      ownerProfile = ownerProfile,
      scope = scope,
      token = FactoryToken.create()
    )
  }

  def exportMemento(): MementoResourceByCode = {
    MementoResourceByCode(
      // third
      thirdProfile.name,
      thirdProfile.clientid,
      thirdProfile.clientsecret,
      thirdProfile.callback,
      thirdProfile.homepage,
      thirdProfile.description,
      // owner
      ownerProfile.firstname,
      ownerProfile.surname,
      ownerProfile.email,
      ownerProfile.emailconfirmed,
      ownerProfile.datebirth,
      // scope
      scope.firstname,
      scope.surname,
      scope.email,
      // code
      code.code,
      code.expiresIn,
      code.generatedIn,
      code.state
    )
  }
}
