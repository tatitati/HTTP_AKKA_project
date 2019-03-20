package app.infrastructure.Persistence.resourceByCode

import builders.domain.BuildScope
import org.scalatest.FunSuite

class ScopeMapperToPersistedSpec extends FunSuite {

  test("I can map from a domain-scope to a persistence-scope") {
    val givenDomainScope = BuildScope.onlyEmailAndFirstname()
    val thenPersisted = ScopeMapper.toPersistedModel(givenDomainScope)

    assert(thenPersisted.email == true)
    assert(thenPersisted.firstname == true)
    assert(thenPersisted.surname == false)
  }

  test("Surrogate id is also mapped properly") {
    val givenDomainScope = BuildScope.onlyEmailAndFirstname(withSurrogateId = Some(6))
    val thenPersisted = ScopeMapper.toPersistedModel(givenDomainScope)

    assert(thenPersisted.id === Some(6))
  }
}
