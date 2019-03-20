package app.infrastructure.Persistence.resourceByCode

import app.domain.resource.Scope
import builders.infrastructure.BuildScopePersistedModel
import org.scalatest.FunSuite

class ScopeMapperToDomainSpec extends FunSuite {
  test("persisted can be mapped to domain") {
    val givenPersisted = BuildScopePersistedModel.anyWithOnlyEmail(withId = Some(6))
    val thenDomain = ScopeMapper.toDomain(givenPersisted)

    assert(thenDomain.isInstanceOf[Scope])
    assert(thenDomain.email === true)
  }

  test("a persisted must have an id in order to be mapped to a domain") {
    val givenPersisted = BuildScopePersistedModel.anyWithOnlyEmail(withId = None)

    val thrown = intercept[IllegalArgumentException] {
      ScopeMapper.toDomain(givenPersisted)
    }
    assert(thrown.getMessage() === "A persisted Scope is expected to have an id in order to be mapped to domain")
  }
}
