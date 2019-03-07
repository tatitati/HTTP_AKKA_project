package app.domain.thirdstore.resourcestore

import app.domain.Scope
import app.domain.factories.FactoryToken
import app.domain.ownerstore.OwnerProfile
import app.domain.thirdstore.Third

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
