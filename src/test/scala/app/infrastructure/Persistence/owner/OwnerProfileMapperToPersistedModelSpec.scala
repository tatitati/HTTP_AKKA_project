package test.app.infrastructure.Persistence.owner

import app.infrastructure.Persistence.owner.{OwnerProfileMapper, OwnerProfilePersistModel}
import org.scalatest.FunSuite
import test.builders.BuildOwnerProfile

class OwnerProfileMapperToPersistedModelSpec extends FunSuite {

  test("Domain is mapped to persistence") {

    val givenDomain = BuildOwnerProfile.specific()
    val thenPersistence = OwnerProfileMapper.toPersistent(givenDomain)

    assert(thenPersistence.isInstanceOf[OwnerProfilePersistModel], "Should be an instance of OwnerProfile")
    assert(thenPersistence.email === "email", "email should match")
    assert(thenPersistence.datebirth.dayOfMonth().get() === 10, "day month birth should match")
    assert(thenPersistence.datebirth.year().get() === 1900, "year birth should match")
  }

  test("Surrogate id is also mapped properly to persistence") {
    val givenDomain = BuildOwnerProfile.any(withSurrogateId = Some(6))
    val thenPersistent = OwnerProfileMapper.toPersistent(givenDomain)

    assert(thenPersistent.id === Some(6))
  }
}
