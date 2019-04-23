package app.infrastructure.persistence.thirdapp

import java.util.UUID

import app.domain.model.third.ThirdId
import app.domain.model.thirdapp.{Thirdapp, ThirdappCredentials, ThirdappId, ThirdappProfile}

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

  def toDomain(thirdappPersistentModel: ThirdappPersistentModel): Thirdapp = {
    val thirdapp = new Thirdapp(
      thirdappId = ThirdappId(UUID.fromString(thirdappPersistentModel.thirdappId)),
      thirdId = ThirdId(UUID.fromString(thirdappPersistentModel.thirdId)),
      credentials = ThirdappCredentials(
        clientId = thirdappPersistentModel.clientid,
        clientSecret = thirdappPersistentModel.clientsecret
      ),
      profile = ThirdappProfile(
        name = thirdappPersistentModel.name,
        domain = thirdappPersistentModel.domain,
        description = thirdappPersistentModel.description
      )
    )

    thirdapp.setSurrogateId(thirdappPersistentModel.surrogateId)

    thirdapp
  }
}
