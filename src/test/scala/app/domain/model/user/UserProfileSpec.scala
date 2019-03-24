package test.app.domain.model.ownerstore

import app.domain.model.user.UserProfileMemento
import test.app.domain.user.BuildUserProfile
import org.scalatest.FunSuite

class UserProfileSpec extends FunSuite {

  test("Has proper attributes") {
    val givenProfile = BuildUserProfile.any(withFirstname = "anyfirstname")

    assert(givenProfile.memento.isInstanceOf[UserProfileMemento])
    assert(givenProfile.memento.firstname === "anyfirstname")
  }

  test("Profile can be updated") {
    val givenProfile = BuildUserProfile.any(withFirstname = "anyfirstname")

    givenProfile.firstname = "a new firstname"

    assert(givenProfile.memento.firstname === "a new firstname")
  }
}
