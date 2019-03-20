package test.app.infrastructure.repository.owner

import app.domain.owner.OwnerProfile
import app.infrastructure.Persistence.owner.OwnerProfileMapper
import org.joda.time.DateTime
import org.scalatest.FunSuite
import test.builders.infrastructure.BuildOwnerProfilePersistedModel

class OwnerProfileMapperToDomainSpec extends FunSuite {

  test("Fields are mapped to domain") {

    val givenPersistent = BuildOwnerProfilePersistedModel.anyPersisted(
      withEmail = "any@something.com",
      withFirstname = "any firstname",
      withDateBirth = (new DateTime).withYear(2016)
        .withMonthOfYear(12)
        .withDayOfMonth(1)
        .withHourOfDay(10)
    )

    val thenDomain = OwnerProfileMapper.toDomain(givenPersistent)

    assert(thenDomain.isInstanceOf[OwnerProfile], "Should be an instance of OwnerProfile")

    println(thenDomain.memento.datebirth.toString)
    assert(thenDomain.memento.email === "any@something.com", "email should match")
    assert(thenDomain.memento.firstname === "any firstname", "firstname should match")
    assert(thenDomain.memento.datebirth.dayOfMonth().get() === 1, "day month birth should match")
    assert(thenDomain.memento.datebirth.year().get() === 2016, "year birth should match")
  }

//  test("Surrogate id is also mapped properly to domain") {
//    val givenPersistent = BuildThirdPersistedModel.anyPersisted()
//
//    assert(givenPersistent.id.isInstanceOf[Some[_]])
//
//    val thenDomain = ThirdMapper.toDomain(givenPersistent)
//
//    assert(thenDomain.isInstanceOf[Third])
//    assert(thenDomain.getSurrogateId().isInstanceOf[Some[_]])
//  }
}
