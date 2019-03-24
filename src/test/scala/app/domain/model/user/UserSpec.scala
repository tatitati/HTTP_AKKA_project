package app.domain.model.user

import app.domain.owner.{BuildUser, BuildUserProfile}
import builders.BuildUuid
import org.scalatest.FunSuite
import test.app.domain.model.auth.BuildAuthId
import test.app.domain.model.owner.BuildUserId

class UserSpec extends FunSuite {

  test("Can compare two owners") {
    val owner1 = BuildUser.any(
      withUserId = BuildUserId.any(withValue = BuildUuid.uuidOne())
    )

    val owner2 = BuildUser.any(
      withUserId = BuildUserId.any(withValue = BuildUuid.uuidTwo())
    )

    val owner3 = BuildUser.any(
      withUserId = BuildUserId.any(withValue = BuildUuid.uuidTwo())
    )

    assert(owner1.equals(owner2) === false)
    assert(owner2.equals(owner3) === true)
  }

  test("Get right properties") {
    val owner = BuildUser.any()

    assert(owner.getProfileMemento.isInstanceOf[UserProfileMemento])
  }

  test("Can edit profile") {
    val owner = BuildUser.any(
      withProfile = BuildUserProfile.specific()
    )

    assert(owner.getProfileMemento.firstname === "firstname")
    owner.setFirstname("new firstname")
    assert(owner.getProfileMemento.firstname === "new firstname")
  }

  test("Can check if is related to an specific Auth") {
    val owner = BuildUser.any(withAuths = Vector(
      BuildAuthId.any1(),
      BuildAuthId.any(),
    ))

    val auth1 = BuildAuthId.any1()
    val auth2 = BuildAuthId.any2()

    assert(owner.exist(auth1) === true)
    assert(owner.exist(auth2) === false)
  }

}
