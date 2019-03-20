package test.app.domain.ownerstore

import builders.domain.BuildOwnerProfile
import org.scalatest.FunSuite
import com.github.nscala_time.time.Imports.DateTime

class ProfileSpec extends FunSuite {

  test("Has proper attributes") {
    val givenProfile = BuildOwnerProfile.any(
      withFirstname = "anyfirstname",
      withSurname = "anysurname",
      withEmail = "whatever@email.com"
    )

    assert(givenProfile.memento.firstname === "anyfirstname")
    assert(givenProfile.memento.surname === "anysurname")
    assert(givenProfile.memento.email === "whatever@email.com")

    assert(givenProfile.memento.datebirth.isInstanceOf[DateTime])
  }
}
