package test.app.domain.ownerstore

import app.domain.owner.{BuildOwnerProfile, OwnerProfileMemento}
import org.scalatest.FunSuite

class OwnerProfileSpec extends FunSuite {

  test("Has proper attributes") {
    val givenProfile = BuildOwnerProfile.any(withFirstname = "anyfirstname")

    assert(givenProfile.memento.isInstanceOf[OwnerProfileMemento])
    assert(givenProfile.memento.firstname === "anyfirstname")
  }

  test("Profile can be updated") {
    val givenProfile = BuildOwnerProfile.any(withFirstname = "anyfirstname")

    givenProfile.setFirstname("a new firstname")

    assert(givenProfile.memento.firstname === "a new firstname")
  }
}
