package app.domain.resource

import app.domain.factories.FactoryToken
import app.domain.owner.OwnerProfile
import app.domain.third.Third

case class ResourceByCode(
                     private val third: Third,
                     private val ownerProfile: OwnerProfile,
                     private val scope: Scope,
                     private val code: Code
                   ) {

  def exchangeByResourceByToken(): ResourceByToken = {
    new ResourceByToken(
      thirdProfile = third.getProfile,
      ownerProfile = ownerProfile,
      scope = scope,
      token = FactoryToken.create()
    )
  }

  def exportMemento(): MementoResourceByCode = {
    MementoResourceByCode(
      // third
      third.id.get,
      third.getProfile.name,
      third.getCredentials.clientId,
      third.getCredentials.clientSecret,
      third.getProfile.callback,
      third.getProfile.homepage,
      third.getProfile.description,
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
