package test.app.infrastructure.repository.owner

import app.domain.owner.OwnerProfile
import app.infrastructure.Persistence.owner.{BuildOwnerProfilePersistedModel, OwnerProfileMapper}
import org.joda.time.DateTime
import org.scalatest.FunSuite

class OwnerProfileMapperToDomainSpec extends FunSuite {

  test("Fields are mapped to domain") {

    val givenPersistent = BuildOwnerProfilePersistedModel.anyPersisted(
      withFirstname = "any firstname",
      withDateBirth = (new DateTime)
        .withYear(2016)
        .withDayOfMonth(1)
    )

    val thenDomain = OwnerProfileMapper.toDomain(givenPersistent)

    assert(thenDomain.isInstanceOf[OwnerProfile], "Should be an instance of OwnerProfile")
    assert(thenDomain.memento.firstname === "any firstname", "email should match")
    assert(thenDomain.memento.datebirth.dayOfMonth().get() === 1, "day month birth should match")
    assert(thenDomain.memento.datebirth.year().get() === 2016, "year birth should match")
  }

  test("Surrogate id is also mapped properly to domain") {
    val givenPersistedModel = BuildOwnerProfilePersistedModel.anyPersisted()
    val thenMappedDomain = OwnerProfileMapper.toDomain(givenPersistedModel)

    assert(thenMappedDomain.getSurrogateId().get.isInstanceOf[Long])
  }

  test("A persisted one must have a surrogate id in order to be mapped to domai") {
    val givenPersistent = BuildOwnerProfilePersistedModel.anyNoPersisted()

    val thrown = intercept[IllegalArgumentException] {
      OwnerProfileMapper.toDomain(givenPersistent)
    }
    assert(thrown.getMessage() === "A persisted OwnerProfile is expected to have a surrogate id in order to be mapped to domain")

  }
}
