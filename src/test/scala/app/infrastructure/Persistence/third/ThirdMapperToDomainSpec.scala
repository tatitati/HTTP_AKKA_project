package test.app.infrastructure.repository.third

import app.domain.third.Third
import app.infrastructure.Persistence.third.{BuildThirdPersistentModel, ThirdMapper}
import org.scalatest.FunSuite

class ThirdMapperToDomainSpec extends FunSuite {

  test("Fields are mapped to domain") {
    val givenPersistent = BuildThirdPersistentModel.anyPersisted(
      withName = "whatever",
      withCallback = "callback",
      withClientId = "client_id"
    )

    val thenDomain = ThirdMapper.toDomain(givenPersistent)

    assert(thenDomain.isInstanceOf[Third])
    assert(thenDomain.getProfile.name === "whatever")
    assert(thenDomain.getProfile.callback === "callback")
    assert(thenDomain.getCredentials.clientId === "client_id")
  }

  test("Surrogate id is also mapped properly to domain") {
    val givenPersistent = BuildThirdPersistentModel.anyPersisted()

    assert(givenPersistent.surrogateId.isInstanceOf[Some[_]])

    val thenDomain = ThirdMapper.toDomain(givenPersistent)

    assert(thenDomain.isInstanceOf[Third])
    assert(thenDomain.getSurrogateId().isInstanceOf[Some[_]])
  }
}
