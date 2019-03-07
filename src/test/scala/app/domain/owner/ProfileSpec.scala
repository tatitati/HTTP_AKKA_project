package test.app.domain.ownerstore

import app.domain.owner.OwnerProfile
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
      withFirstname = "anyfirstname"
    )

    val profileUpdated = givenProfile.setFirstname("new name")

    assert(profileUpdated.isInstanceOf[OwnerProfile])
    assert(profileUpdated.firstname === "new name")
  }

  test("When changed the emal, this is not confirmed until we confirm it") {
    val givenProfile = BuildOwnerProfile.any(
      withEmail = "whatever@email.com",
      withEmailConfirmed = false
    )

    val profileUpdated = givenProfile.setEmail("newemail@whatever.com")

    assert(profileUpdated.isInstanceOf[OwnerProfile])
    assert(profileUpdated.email === "newemail@whatever.com")
    assert(profileUpdated.emailconfirmed === false)
  }
}
