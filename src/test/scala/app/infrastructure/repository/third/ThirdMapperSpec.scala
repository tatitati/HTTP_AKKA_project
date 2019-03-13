package app.infrastructure.repository.third

import app.domain.third.Third
import org.scalatest.FunSuite
import test.builders.infrastructure.BuildThirdPersistedModel
import test.builders.{BuildThird, BuildThirdCredentials, BuildThirdProfile}

class ThirdMapperSpec extends FunSuite {

  test("ThirdPersistedModel -> ThirdDomain") {
    val persistent = BuildThirdPersistedModel.any(
      withId = Some(5),
      withName = "whatever",
      withCallback = "callback",
      withClientId = "client_id"
    )

    val domain = ThirdMapper.toDomain(persistent)

    assert(domain.isInstanceOf[Third])
    assert(domain.getSurrogateId() === Some(5))
    assert(domain.getProfile.name === "whatever")
    assert(domain.getProfile.callback === "callback")
    assert(domain.getCredentials.clientId === "client_id")
  }

  test("ThirdDomain -> ThirdPersistedModel with no surrogate id in domain yet") {
    val thirdDomain = BuildThird.any(
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
    assert(persistent.id === None)
    assert(persistent.name === "whatever")
    assert(persistent.callback === "callback")
    assert(persistent.clientId === "client_id")
  }

  test("ThirdDomain -> ThirdPersistedModel with surrogate") {
    val thirdDomain = BuildThird.any()
    thirdDomain.setSurrogateId(Some(6))

    val persistent = ThirdMapper.toPersistent(thirdDomain)

    assert(persistent.isInstanceOf[ThirdPersistedModel])
    assert(persistent.id === Some(6))
  }
}
