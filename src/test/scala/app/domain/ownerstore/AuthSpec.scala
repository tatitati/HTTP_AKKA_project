package test.app.domain.ownerstore

import app.domain.ownerstore.Auth
import builders.BuildThirdProfile
import builders.authorizes.{BuildAuth, BuildScope}
import org.scalatest.FunSuite

class AuthSpec extends FunSuite {

  test("User can know what permissions were granted to a third") {
    val givenAuth = BuildAuth.any(
      withScope = BuildScope.onlySurname()
    )

    assert(givenAuth.canFirstname === false, "=> Third should be able to access to firstname")
    assert(givenAuth.canSurname === true, "=> Third should be able to access to surname")
  }

  test("User can see basic information about the third that was granted permissions") {
    val givenAuth = BuildAuth.any(
        withThirdProfile = BuildThirdProfile.any(
          withName = "CircleCI", withDescription = "any description"
        )
    )

    assert(givenAuth.name() == "CircleCI", "=> Should show third-name")
    assert(givenAuth.description() == "any description", "=> Should show third-description")
  }

  test("Auth can have a token (or not if it was revoked)") {
    val givenAuth = BuildAuth.any()
    givenAuth.isInstanceOf[Auth]
  }
}
