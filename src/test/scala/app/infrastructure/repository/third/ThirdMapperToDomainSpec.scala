package test.app.infrastructure.repository.third

import app.domain.third.Third
import app.infrastructure.repository.third.ThirdMapper
import org.scalatest.FunSuite
import test.builders.infrastructure.BuildThirdPersistedModel

class ThirdMapperToDomainSpec extends FunSuite {

  test("Fields are mapped to domain") {
    val givenPersistent = BuildThirdPersistedModel.anyPersisted(
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
    val givenPersistent = BuildThirdPersistedModel.anyPersisted()

    assert(givenPersistent.id.isInstanceOf[Some[_]])

    val thenDomain = ThirdMapper.toDomain(givenPersistent)

    assert(thenDomain.isInstanceOf[Third])
    assert(thenDomain.getSurrogateId().isInstanceOf[Some[_]])
  }
}
