package test.app.infrastructure.repository.third

import app.domain.third.{BuildThird, BuildThirdCredentials, BuildThirdProfile}
import app.infrastructure.Persistence.third.{ThirdMapper, ThirdPersistentModel}
import org.scalatest.FunSuite

class ThirdMapperToPersistenceSpec extends FunSuite {

  test("ThirdDomain -> ThirdPersistentModel produce a ThirdPersistentModel") {
    val givenThirdDomain = BuildThird.any()
    val thenPersistent = ThirdMapper.toPersistent(givenThirdDomain)

    assert(thenPersistent.isInstanceOf[ThirdPersistentModel])
  }

  test("ThirdDomain -> ThirdPersistentModel gives the expected ThirdPersistentModel") {
    val givenThirdDomain = BuildThird.any(
      withSurrogateId = None,
      withThirdProfile = BuildThirdProfile.specific(),
      withCredentials = BuildThirdCredentials.specific()
    )

    val thenPersistent = ThirdMapper.toPersistent(givenThirdDomain)

    assert(thenPersistent.id === None)
    assert(thenPersistent.name === "whatever")
    assert(thenPersistent.clientId === "client_id")
  }

  test("Surrogate id is mapped to the proper value in persistent model") {
    val givenThirdDomain = BuildThird.any(withSurrogateId = Some(6))
    val persistent = ThirdMapper.toPersistent(givenThirdDomain)

    assert(persistent.id === Some(6))
  }
}
