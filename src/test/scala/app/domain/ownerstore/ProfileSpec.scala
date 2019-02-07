package app.domain.ownerstore

import builders.BuildOwnerProfile
import org.scalatest.FunSuite

class ProfileSpec extends FunSuite {

  test("Has proper attributes") {
    val givenProfile = BuildOwnerProfile.any(
      withFirstname = "anyfirstname",
      withSurname = "anysurname",
      withEmail = "whatever@email.com"
    )

    assert(givenProfile.firstname === "anyfirstname")
    assert(givenProfile.surname === "anysurname")
    assert(givenProfile.email === "whatever@email.com")

    assert(givenProfile.datebirth.getDayOfMonth ===  20)
    assert(givenProfile.datebirth.getMonthOfYear ===  8)
    assert(givenProfile.datebirth.getYear ===  2030)
  }
}
