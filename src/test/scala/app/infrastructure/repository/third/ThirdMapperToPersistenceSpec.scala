package test.app.infrastructure.repository.third

import app.infrastructure.repository.third.{ThirdMapper, ThirdPersistedModel}
import org.scalatest.FunSuite
import test.builders.{BuildThird, BuildThirdCredentials, BuildThirdProfile}

class ThirdMapperToPersistenceSpec extends FunSuite {

  test("ThirdDomain -> ThirdPersistedModel with no surrogate id in domain yet") {
    val givenThirdDomain = BuildThird.any(
      withSurrogateId = None,
      withThirdProfile = BuildThirdProfile.specific(),
      withCredentials = BuildThirdCredentials.specific()
    )

    val thenPersistent = ThirdMapper.toPersistent(givenThirdDomain)

    assert(thenPersistent.isInstanceOf[ThirdPersistedModel])
    assert(thenPersistent.name === "whatever")
    assert(thenPersistent.clientId === "client_id")
  }

  test("Surrogate id is mapped to None persistent model") {
    val givenThirdDomain = BuildThird.any(
      withSurrogateId = None
    )

    val thenPersistent = ThirdMapper.toPersistent(givenThirdDomain)

    assert(thenPersistent.isInstanceOf[ThirdPersistedModel])
    assert(thenPersistent.id === None)
  }

  test("Surrogate id is mapped to the proper value in persistent model") {
    val givenThirdDomain = BuildThird.any(
      withSurrogateId = Some(6)
    )

    val persistent = ThirdMapper.toPersistent(givenThirdDomain)

    assert(persistent.isInstanceOf[ThirdPersistedModel])
    assert(persistent.id === Some(6))
  }
}
