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
      thirdProfile = third.profile,
      ownerProfile = ownerProfile,
      scope = scope,
      token = FactoryToken.create()
    )
  }

  def exportMemento(): MementoResourceByCode = {
    MementoResourceByCode(
      // third
      third.id.get,
      third.profile.name,
      third.credentials.clientId,
      third.credentials.clientSecret,
      third.profile.callback,
      third.profile.homepage,
      third.profile.description,
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
