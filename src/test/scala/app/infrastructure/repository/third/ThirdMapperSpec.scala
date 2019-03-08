package app.infrastructure.repository.third

import app.domain.third.Third
import org.scalatest.FunSuite
import test.builders.{BuildThird, BuildThirdCredentials, BuildThirdProfile}

class ThirdMapperSpec extends FunSuite {

  test("ThirdPersistedModel -> Third") {
    val persistent = ThirdPersistedModel(
      None,
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
    assert(domain.credentials.clientId === "client_id")
  }

  test("ThirdPersistedModel <- Third") {
    val third = BuildThird.any(
      withThirdProfile = BuildThirdProfile.any(
        withName = "whatever",
        withCallback = "callback",
        withHomepage = "homepage",
        withDescription = "my description"
      ),
      withCredentials = BuildThirdCredentials.any(
        withClientid = "client_id",
        withClientsecret = "client_secret"
      )
    )

    val persistent = ThirdMapper.toPersistent(third)

    assert(persistent.isInstanceOf[ThirdPersistedModel])
    assert(persistent.name === "whatever")
    assert(persistent.callback === "callback")
    assert(persistent.clientId === "client_id")
  }
}
