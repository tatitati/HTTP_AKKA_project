package app.domain.ownerstore

import builders.BuildOwnerProfile
import org.scalatest.FunSuite
import com.github.nscala_time.time.Imports.DateTime

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
}
