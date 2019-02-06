package app.domain.ownerstore

import builders.BuildOwnerProfile
import org.scalatest.FunSuite

class ProfileSpec extends FunSuite {

  test("Has proper attributes") {
    val givenProfile = BuildOwnerProfile.any()

    assert(givenProfile.firstname === "any firstname")
    assert(givenProfile.surname === "then surname")
    assert(givenProfile.email === "whatever@email.com")

    assert(givenProfile.datebirth.getDayOfMonth ===  20)
    assert(givenProfile.datebirth.getMonthOfYear ===  8)
    assert(givenProfile.datebirth.getYear ===  2030)
  }
}
