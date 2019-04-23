package app.infrastructure.persistence.thirdapp

import app.domain.model.thirdapp.Thirdapp

object ThirdappMapper {
  def toPersistent(thirdapp: Thirdapp): ThirdappPersistentModel = {
    ThirdappPersistentModel(
      thirdappId = thirdapp.thirdappId.toString(),
      thirdId = thirdapp.thirdappId.toString(),
      clientid = thirdapp.getCredentials.clientId,
      clientsecret = thirdapp.getCredentials.clientSecret,
      name = thirdapp.getProfile.name,
      domain = thirdapp.getProfile.domain,
      description = thirdapp.getProfile.description
    )
  }
}
