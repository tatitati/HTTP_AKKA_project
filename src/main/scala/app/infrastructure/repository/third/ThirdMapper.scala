package app.infrastructure.repository.third

import app.domain.third.{Third, ThirdCredentials, ThirdProfile}

object ThirdMapper {
  def toDomain(fromPersistent: ThirdPersistedModel): Third = {
    Third(
      profile = ThirdProfile(
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
}
