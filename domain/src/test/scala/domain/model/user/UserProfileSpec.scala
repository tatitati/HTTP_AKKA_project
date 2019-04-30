package domain.test.model.user

import domain.test.model.user.BuildUserProfile
import org.scalatest.FunSuite

class UserProfileSpec extends FunSuite {

  test("Has proper attributes") {
    val givenProfile = BuildUserProfile.any(withFirstname = "anyfirstname")

    assert(givenProfile.firstname === "anyfirstname")
  }
}
