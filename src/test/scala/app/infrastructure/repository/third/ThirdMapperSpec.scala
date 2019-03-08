package app.infrastructure.repository.third

import app.domain.third.Third
import org.scalatest.FunSuite
import test.builders.infrastructure.BuildThirdPersistedModel
import test.builders.{BuildThird, BuildThirdCredentials, BuildThirdProfile}

class ThirdMapperSpec extends FunSuite {

  test("ThirdPersistedModel -> Third") {
    val persistent = BuildThirdPersistedModel.any(
      withId = Some(5),
      withName = "whatever",
      withCallback = "callback",
      withClientId = "client_id"
    )

    val domain = ThirdMapper.toDomain(persistent)

    assert(domain.isInstanceOf[Third])
    assert(domain.id === Some(5))
    assert(domain.getProfile.name === "whatever")
    assert(domain.getProfile.callback === "callback")
    assert(domain.getCredentials.clientId === "client_id")
  }

  test("ThirdPersistedModel <- Third") {
    val thirdDomain = BuildThird.any(
      withId = Some(5),
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

    val persistent = ThirdMapper.toPersistent(thirdDomain)

    assert(persistent.isInstanceOf[ThirdPersistedModel])
    assert(persistent.id === Some(5))
    assert(persistent.name === "whatever")
    assert(persistent.callback === "callback")
    assert(persistent.clientId === "client_id")
  }
}
