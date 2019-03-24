package app.domain.model.owner

import app.domain.owner.{BuildOwner, BuildOwnerProfile}
import builders.BuildUuid
import org.scalatest.FunSuite
import test.app.domain.model.auth.BuildAuthId
import test.app.domain.model.owner.BuildOwnerId

class OwnerSpec extends FunSuite {

  test("Can compare two owners") {
    val owner1 = BuildOwner.any(
      withOwnerId = BuildOwnerId.any(withValue = BuildUuid.uuidOne())
    )

    val owner2 = BuildOwner.any(
      withOwnerId = BuildOwnerId.any(withValue = BuildUuid.uuidTwo())
    )

    val owner3 = BuildOwner.any(
      withOwnerId = BuildOwnerId.any(withValue = BuildUuid.uuidTwo())
    )

    assert(owner1.equals(owner2) === false)
    assert(owner2.equals(owner3) === true)
  }

  test("Get right properties") {
    val owner = BuildOwner.any()

    assert(owner.getProfileMemento.isInstanceOf[OwnerProfileMemento])
  }

  test("Can edit profile") {
    val owner = BuildOwner.any(
      withProfile = BuildOwnerProfile.specific()
    )

    assert(owner.getProfileMemento.firstname === "firstname")
    owner.setFirstname("new firstname")
    assert(owner.getProfileMemento.firstname === "new firstname")
  }

  test("Can check if is related to an specific Auth") {
    val owner = BuildOwner.any(withAuths = Vector(
      BuildAuthId.any1(),
      BuildAuthId.any(),
    ))

    val auth1 = BuildAuthId.any1()
    val auth2 = BuildAuthId.any2()

    assert(owner.exist(auth1) === true)
    assert(owner.exist(auth2) === false)
  }

}
