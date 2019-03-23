package app.infrastructure.Persistence.resource

import app.domain.auth.Token
import org.scalatest.FunSuite
import test.builders.Faker

class TokenMapperToDomainSpec extends FunSuite {

  test("persisted can map to domain") {
    val persisted = BuildTokenPersistedModel.any(
      withId = Some(Faker.int),
      withTokenType = "any token type"
    )
    val domain = TokenMapper.toDomain(persisted)

    assert(domain.isInstanceOf[Token])
    assert(domain.tokenType === "any token type")
  }

  test("Surrogate id is also mapped") {
    val persisted = BuildTokenPersistedModel.any(withId = Some(8))
    val domain = TokenMapper.toDomain(persisted)

    assert(domain.getSurrogateId() === Some(8))
  }

  test("to mapp to domain is needed a surrogate id") {
    val persisted = BuildTokenPersistedModel.any(withId = None)

    val thrown = intercept[IllegalArgumentException] {
      TokenMapper.toDomain(persisted)
    }
    assert(thrown.getMessage() === "A persisted token is expected to have an id in order to be mapped to domain")


  }
}
