package test.app.domain.ownerstore

import app.domain.ownerstore.OwnerProfile
import org.scalatest.FunSuite
import com.github.nscala_time.time.Imports.DateTime
import test.builders.BuildOwnerProfile

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

    assert(givenProfile.datebirth.isInstanceOf[DateTime])
  }

  test("Can be updated in a FP way") {
    val givenProfile = BuildOwnerProfile.any(
      withFirstname = "anyfirstname",
      withSurname = "anysurname",
      withEmail = "whatever@email.com"
    )

    val profileUpdated = givenProfile.setFirstname("new name")

    assert(profileUpdated.isInstanceOf[OwnerProfile])
    assert(profileUpdated.firstname === "new name")
  }
}
