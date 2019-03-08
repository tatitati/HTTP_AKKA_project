package app.infrastructure.repository.third

import app.domain.third.{Third, ThirdCredentials, ThirdProfile}

object ThirdMapper {

  def toDomain(fromPersistent: ThirdPersistedModel): Third = {
    Third(
      id = fromPersistent.id,
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
  }

  def toPersistent(third: Third): ThirdPersistedModel= {
    ThirdPersistedModel(
      id = third.id,
      name = third.getProfile.name,
      callback = third.getProfile.callback,
      homepage = third.getProfile.homepage,
      description = third.getProfile.description,
      clientId = third.getCredentials.clientId,
      clientSecret = third.getCredentials.clientSecret
    )
  }
}
