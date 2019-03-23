package test.app.domain.model.ownerstore

import app.domain.model.owner.OwnerProfileMemento
import app.domain.owner.BuildOwnerProfile
import org.scalatest.FunSuite

class OwnerProfileSpec extends FunSuite {

  test("Has proper attributes") {
    val givenProfile = BuildOwnerProfile.any(withFirstname = "anyfirstname")

    assert(givenProfile.memento.isInstanceOf[OwnerProfileMemento])
    assert(givenProfile.memento.firstname === "anyfirstname")
  }

  test("Profile can be updated") {
    val givenProfile = BuildOwnerProfile.any(withFirstname = "anyfirstname")

    givenProfile.firstname = "a new firstname"

    assert(givenProfile.memento.firstname === "a new firstname")
  }
}
