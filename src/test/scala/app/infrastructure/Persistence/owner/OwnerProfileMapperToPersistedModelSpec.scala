package test.app.infrastructure.Persistence.owner

import app.infrastructure.Persistence.owner.{OwnerProfileMapper, OwnerProfilePersistModel}
import org.scalatest.FunSuite
import test.builders.BuildOwnerProfile
import test.builders.infrastructure.BuildOwnerProfilePersistedModel

class OwnerProfileMapperToPersistedModelSpec extends FunSuite {

  test("Domain is mapped to persistence") {

    val givenDomain = BuildOwnerProfile.specific()
    val thenPersistence = OwnerProfileMapper.toPersistent(givenDomain)

    assert(thenPersistence.isInstanceOf[OwnerProfilePersistModel], "Should be an instance of OwnerProfile")

//    assert(thenPersistence.memento.email === "any@something.com", "email should match")
//    assert(thenPersistence.memento.firstname === "any firstname", "firstname should match")
//    assert(thenPersistence.memento.datebirth.dayOfMonth().get() === 1, "day month birth should match")
//    assert(thenPersistence.memento.datebirth.year().get() === 2016, "year birth should match")
  }

//  test("Surrogate id is also mapped properly to domain") {
//    val givenPersistent = BuildOwnerProfilePersistedModel.anyPersisted()
//
//    assert(givenPersistent.id.isInstanceOf[Some[_]])
//
//    val thenDomain = OwnerProfileMapper.toDomain(givenPersistent)
//
//    assert(thenDomain.getSurrogateId().isInstanceOf[Some[_]])
//  }
}
