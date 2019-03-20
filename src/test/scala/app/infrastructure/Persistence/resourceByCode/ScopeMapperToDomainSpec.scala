package app.infrastructure.Persistence.resourceByCode

import builders.domain.BuildScope
import org.scalatest.FunSuite

class ScopeMapperToDomainSpec extends FunSuite {

  test("I can map from a domain-scope to a persistence-scope") {
    val givenDomainScope = BuildScope.onlyEmailAndFirstname()
    val thenMapped = ScopeMapper.toPersistedModel(givenDomainScope)

    assert(thenMapped.email == true)
    assert(thenMapped.firstname == true)
    assert(thenMapped.surname == false)
  }

  test("Surrogate id is also mapped properly") {
    val givenDomainScope = BuildScope.onlyEmailAndFirstname(
      withSurrogateId = Some(6)
    )
    val thenMapped = ScopeMapper.toPersistedModel(givenDomainScope)

    assert(thenMapped.id === Some(6))
  }
}
