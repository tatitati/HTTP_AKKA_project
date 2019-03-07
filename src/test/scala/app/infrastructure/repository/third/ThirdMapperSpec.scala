package app.infrastructure.repository.third

import app.domain.third.Third
import org.scalatest.FunSuite

class ThirdMapperSpec extends FunSuite {

  test("ThirdPersistedModel -> Third") {
    val persistent = ThirdPersistedModel(
      name = "whatever",
      callback = "callback",
      homepage = "homepage",
      description = "my description",
      clientId = "client_id",
      clientSecret = "client_secret"
    )

    val domain = ThirdMapper.toDomain(persistent)

    assert(domain.isInstanceOf[Third])
    assert(domain.profile.name === "whatever")
    assert(domain.profile.callback === "callback")
    assert(domain.credentials.clientId=== "client_id")
  }
}
