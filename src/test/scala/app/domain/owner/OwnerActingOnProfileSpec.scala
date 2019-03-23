package test.app.domain.ownerstore

import app.domain.owner.{BuildOwner, BuildOwnerProfile, OwnerProfileMemento}
import builders.domain.BuildOwnerProfile
import org.scalatest.FunSuite

class OwnerActingOnProfileSpec extends FunSuite {

  test("Has an editable profile that only the owner can edit") {
    val givenOwner = BuildOwner.any(
      withProfile = BuildOwnerProfile.any(
        withFirstname = "gutierrez"
      )
    )

    givenOwner.setFirstname("new name")
    assert(givenOwner.getOwnerProfile.firstname === "new name")
  }

  test("Return a memento of profile, no editable, to external world") {
    val givenUser = BuildOwner.any(
      withProfile = BuildOwnerProfile.any(
        withFirstname = "gutierrez"
      )
    )

    assert(givenUser.getOwnerProfile.isInstanceOf[OwnerProfileMemento])
  }

  test("Can compare to another owner by the Identifier EMAIL") {
    val givenOwner1 = BuildOwner.any(
      withProfile = BuildOwnerProfile.any(
        withEmail = "whatever@something.com"
      )
    )
    val givenOwner2 = BuildOwner.any(
      withProfile = BuildOwnerProfile.any(
        withEmail = "somethingdifferent@something.com"
      )
    )
    val givenOwner3 = BuildOwner.any(
      withProfile = BuildOwnerProfile.any(
        withEmail = "somethingdifferent@something.com"
      )
    )

    assert(givenOwner1.equals(givenOwner2) === false)
    assert(givenOwner2.equals(givenOwner3) === true)
  }
}
