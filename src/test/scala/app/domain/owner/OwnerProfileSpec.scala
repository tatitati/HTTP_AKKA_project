package test.app.domain.ownerstore

import builders.domain.BuildOwnerProfile
import org.scalatest.FunSuite
import com.github.nscala_time.time.Imports.DateTime

class OwnerProfileSpec extends FunSuite {

  test("Has proper attributes") {
    val givenProfile = BuildOwnerProfile.any(
      withFirstname = "anyfirstname"
    )

    assert(givenProfile.memento.firstname === "anyfirstname")
    assert(givenProfile.memento.datebirth.isInstanceOf[DateTime])
  }

  test("Can compare to another profile by the Identifier EMAIL") {
    val givenProfile1 = BuildOwnerProfile.any(withEmail = "whatever@something.com")
    val givenProfile2 = BuildOwnerProfile.any(withEmail = "somethingdifferent@something.com")
    val givenProfile3 = BuildOwnerProfile.any(withEmail = "somethingdifferent@something.com")

    assert(givenProfile1.equals(givenProfile2) === false)
    assert(givenProfile2.equals(givenProfile3) === true)
  }
}
