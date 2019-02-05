package app.domain.ownerstore

import builders.BuildOwnerProfile
import org.scalatest.FunSuite

class ProfileSpec extends FunSuite {

  test("Has proper attributes") {
    val profile = BuildOwnerProfile.any()

    assert(profile.firstname === "any firstname")
    assert(profile.surname === "then surname")
    assert(profile.email === "whatever@email.com")

    assert(profile.datebirth.getDayOfMonth ===  20)
    assert(profile.datebirth.getMonthOfYear ===  8)
    assert(profile.datebirth.getYear ===  2030)
  }
}
