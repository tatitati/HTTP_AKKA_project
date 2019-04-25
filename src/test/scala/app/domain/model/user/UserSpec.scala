package app.domain.model.user

import test.app.domain.user.{BuildUser, BuildUserProfile}
import org.scalatest.FunSuite
import test.app.domain.model.user.BuildUserId

class UserSpec extends FunSuite {

  test("Can compare two owners") {
    val owner1 = BuildUser.any(
      withId = BuildUserId.any(withValue = "email1")
    )

    val owner2 = BuildUser.any(
      withId = BuildUserId.any(withValue = "email2")
    )

    val owner3 = BuildUser.any(
      withId = BuildUserId.any(withValue = "email2")
    )

    assert(owner1.equals(owner2) === false)
    assert(owner2.equals(owner3) === true)
  }

  test("Can edit profile") {
    val owner = BuildUser.any(
      withProfile = BuildUserProfile.specific()
    )

    assert(owner.getProfile.firstname === "firstname")
    owner.updateFirstname("new firstname")
    assert(owner.getProfile.firstname === "new firstname")
  }

  test("Set confirmed email to false after updating email") {
    val owner = BuildUser.any(
      withProfile = BuildUserProfile.any(
        withEmail = "myemail"
      ),
      withEmailConfirmed = true
    )

    owner.updateEmail("any new email")

    assert(owner.isEmailConfirmed() === false)
  }
}
