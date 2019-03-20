package test.app.domain.ownerstore

import app.domain.owner.Auth
import builders.domain.{BuildAuth, BuildScope, BuildThird, BuildThirdProfile}
import org.scalatest.FunSuite

class AuthSpec extends FunSuite {

  test("User can know what permissions were granted to a third") {
    val givenAuth = BuildAuth.any(
      withScope = BuildScope.onlySurname()
    )

    assert(givenAuth.canThirdReadFirstname === false, "=> Third should be able to access to firstname")
    assert(givenAuth.canThirdReadSurname === true, "=> Third should be able to access to surname")
  }

  test("User can see basic information about the third that was granted permissions") {
    val givenAuth = BuildAuth.any(
        withThird = BuildThird.any(
          withThirdProfile = BuildThirdProfile.any(
            withName = "CircleCI", withDescription = "any description"
          )
        )
    )

    assert(givenAuth.getThirdProfile.name == "CircleCI", "=> Should show third-name")
    assert(givenAuth.getThirdProfile.description == "any description", "=> Should show third-description")
  }

  test("Auth can have a token (or not if it was revoked)") {
    val givenAuth = BuildAuth.any()
    givenAuth.isInstanceOf[Auth]
  }
}
