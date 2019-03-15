package app.infrastructure.Persistence.third

import app.domain.third.{Third, ThirdCredentials, ThirdProfile}

object ThirdMapper {

  def toDomain(fromPersistent: ThirdPersistModel): Third = {
    val domain = Third(
      profile = new ThirdProfile(
        name = fromPersistent.name,
        callback = fromPersistent.callback,
        homepage = fromPersistent.homepage,
        description = fromPersistent.description
      ),
      credentials = ThirdCredentials(
        clientId = fromPersistent.clientId,
        clientSecret = fromPersistent.clientSecret
      )
    )

    domain.setSurrogateId(fromPersistent.id)

    domain
  }

  def toPersistent(third: Third): ThirdPersistModel= {
    ThirdPersistModel(
      id = third.getSurrogateId(),
      name = third.getProfile.name,
      callback = third.getProfile.callback,
      homepage = third.getProfile.homepage,
      description = third.getProfile.description,
      clientId = third.getCredentials.clientId,
      clientSecret = third.getCredentials.clientSecret
    )
  }
}
