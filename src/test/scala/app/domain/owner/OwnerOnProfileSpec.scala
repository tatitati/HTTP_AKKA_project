package test.app.domain.ownerstore

import app.domain.owner.OwnerProfileMemento
import builders.domain.{BuildOwner, BuildOwnerProfile}
import org.scalatest.FunSuite

class OwnerOnProfileSpec extends FunSuite {

  test("Return a memento of profile, no editable, to external world") {
    val givenUser = BuildOwner.any(
      withProfile = BuildOwnerProfile.any(
        withFirstname = "gutierrez"
      )
    )

    assert(givenUser.getOwnerProfile.isInstanceOf[OwnerProfileMemento])
  }

  test("Has an editable profile that only the owner can edit") {
    val givenUser = BuildOwner.any(
      withProfile = BuildOwnerProfile.any(
        withFirstname = "gutierrez"
      )
    )

    givenUser.setFirstname("new name")
    assert(givenUser.getOwnerProfile.firstname === "new name")
  }
}
